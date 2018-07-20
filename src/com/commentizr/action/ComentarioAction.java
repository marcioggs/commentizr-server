package com.commentizr.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.commentizr.dto.AcaoUsuarioDTO;
import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.RespostaDTO;
import com.commentizr.dto.UrlDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.facade.ComentarioFacade;
import com.commentizr.util.Constantes;
import com.opensymphony.xwork2.Action;

/**
 * Classe responsável pelas ações de comentário.
 */
@Controller
@Scope("Request")
public class ComentarioAction extends BaseAction {
	
	private static final long serialVersionUID = 4854226147972924178L;
	
	@Autowired
	private ComentarioFacade facade;
	
	private UrlDTO url;
	private List<ComentarioDTO> comentarios;
	private ComentarioDTO comentario;
	private List<RespostaDTO> respostas;
	private RespostaDTO resposta;
	
	/**
	 * Insere o comentário.
	 * @return Retorno
	 */
	public String inserirComentario() {
		AcaoUsuarioDTO acao = new AcaoUsuarioDTO();
		acao.setUsuario((UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO));
		this.getComentario().setAcaoUsuario(acao);
		
		this.facade.inserirComentario(this.getComentario());
		return Action.SUCCESS;
	}
	
	/**
	 * Obtém os comentários
	 * @return Retorno
	 */
	public String obterComentarios() {
		this.setComentarios(this.facade.obterComentarios(this.getUrl()));
		return Action.SUCCESS;
	}
	
	/**
	 * Likar o comentário
	 * @return Retorno
	 */
	public String likarComentario() {
		UsuarioDTO usuario = (UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO);
		this.facade.likarComentario(usuario, this.comentario.getIdComentario());
		return Action.SUCCESS;
	}
	
	/**
	 * Dislikar o comentário
	 * @return Retorno
	 */
	public String dislikarComentario() {
		UsuarioDTO usuario = (UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO);
		this.facade.dislikarComentario(usuario, this.comentario.getIdComentario());
		return Action.SUCCESS;
	}
	
	/**
	 * Exibe as respostas.
	 * @return Retorno
	 */
	public String exibirRespostas() {
		this.setRespostas(this.facade.obterRespostas(this.getComentario().getIdComentario()));
		return Action.SUCCESS;
	}
	
	/**
	 * Insere o comentário.
	 * @return Retorno
	 */
	public String inserirResposta() {
		AcaoUsuarioDTO acao = new AcaoUsuarioDTO();
		acao.setUsuario((UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO));
		this.getResposta().setAcaoUsuario(acao);
		
		this.facade.inserirResposta(this.getResposta());
		
		this.exibirRespostas();
		
		return Action.SUCCESS;
	}
	
	/**
	 * Likar a resposta
	 * @return Retorno
	 */
	public String likarResposta() {
		UsuarioDTO usuario = (UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO);
		this.facade.likarResposta(usuario, this.getResposta().getIdResposta());
		return Action.SUCCESS;
	}
	
	/**
	 * Dislikar a resposta.
	 * @return Retorno
	 */
	public String dislikarResposta() {
		UsuarioDTO usuario = (UsuarioDTO) this.getSession().get(Constantes.SESSAO_USUARIO);
		this.facade.dislikarResposta(usuario, this.getResposta().getIdResposta());
		return Action.SUCCESS;
	}
	
	/**
	 * Obtém o campo url.
	 * @return url
	 */
	public UrlDTO getUrl() {
		return this.url;
	}
	
	/**
	 * Especificao o campo url.
	 * @param url url
	 */
	public void setUrl(UrlDTO url) {
		this.url = url;
	}
	
	/**
	 * Obtém o campo comentarios.
	 * @return comentarios
	 */
	public List<ComentarioDTO> getComentarios() {
		return this.comentarios;
	}
	
	/**
	 * Especificao o campo comentarios.
	 * @param comentarios comentarios
	 */
	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * Obtém o campo comentario.
	 * @return comentario
	 */
	public ComentarioDTO getComentario() {
		return this.comentario;
	}
	
	/**
	 * Especificao o campo comentario.
	 * @param comentario comentario
	 */
	public void setComentario(ComentarioDTO comentario) {
		this.comentario = comentario;
	}
	
	/**
	 * Obtém o campo respostas.
	 * @return respostas
	 */
	public List<RespostaDTO> getRespostas() {
		return this.respostas;
	}
	
	/**
	 * Especificao o campo respostas.
	 * @param respostas respostas
	 */
	public void setRespostas(List<RespostaDTO> respostas) {
		this.respostas = respostas;
	}
	
	/**
	 * Obtém o campo resposta.
	 * @return resposta
	 */
	public RespostaDTO getResposta() {
		return this.resposta;
	}
	
	/**
	 * Especificao o campo resposta.
	 * @param resposta resposta
	 */
	public void setResposta(RespostaDTO resposta) {
		this.resposta = resposta;
	}
	
}
