package com.commentizr.facade;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentizr.dao.ComentarioDAO;
import com.commentizr.dto.AcaoUsuarioDTO;
import com.commentizr.dto.AplicacaoOrigemDTO;
import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.DislikeMensagemDTO;
import com.commentizr.dto.DominioUrlDTO;
import com.commentizr.dto.LikeMensagemDTO;
import com.commentizr.dto.MensagemDTO;
import com.commentizr.dto.RespostaDTO;
import com.commentizr.dto.TipoAcaoMensagemDTO;
import com.commentizr.dto.UrlDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.framework.exception.BusinessException;
import com.commentizr.framework.message.Message;

/**
 * Classe responsável pela lógica das operações de comentário.
 */
@Service
public class ComentarioFacadeImpl extends BaseFacade implements ComentarioFacade {
	
	@Autowired
	private ComentarioDAO dao;
	
	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Override
	public void inserirComentario(ComentarioDTO comentario) {
		comentario.setUrl(this.obterUrl(comentario.getUrl().getUrlCompleta(), true));
		this.gravarMensagem(comentario);
		this.getDao().criarComentario(comentario);
	}
	
	/**
	 * Grava a mensagem.
	 * @param mensagem Mensagem
	 */
	private void gravarMensagem(MensagemDTO mensagem) {
		this.getDao().criarMensagem(mensagem);
		this.gravarHistoricoMensagem(mensagem);
	}
	
	/**
	 * Grava o histórico da mensagem.
	 * @param mensagem mensagem
	 */
	private void gravarHistoricoMensagem(MensagemDTO mensagem) {
		this.gravarAcaoUsuario(mensagem.getAcaoUsuario());
		
		TipoAcaoMensagemDTO tipoAcao = super.getDominioFacade()
				.obterTipoAcaoMensagem(TipoAcaoMensagemDTO.CHV_ADICIONAR);
		if (tipoAcao == null) {
			throw new BusinessException(new Message("tipo.acao.mensagem.inexistente"));
		}
		mensagem.setTipoAcaoMensagem(tipoAcao);
		
		if (GenericValidator.isBlankOrNull(mensagem.getDscTextoMensagem())) {
			throw new BusinessException(new Message("erro.campo.obrigatorio", "mensagem"));
		}
		
		this.getDao().criarHistoricoMensagem(mensagem);
	}
	
	/**
	 * Grava a ação do usuário.
	 * @param acao Ação do usuário
	 */
	private void gravarAcaoUsuario(AcaoUsuarioDTO acao) {
		acao.setDatAcaoUsuario(new DateTime());
		
		AplicacaoOrigemDTO app = super.getDominioFacade().obterAplicacaoOrigem(AplicacaoOrigemDTO.CHV_EXTENSAO_CHROME);
		if (app.getIdAplicacaoOrigem() == null) {
			throw new BusinessException(new Message("aplicacao.origem.inexistente"));
		}
		acao.setAplicacaoOrigem(app);
		
		this.getDao().criarAcaoUsuario(acao);
	}
	
	/**
	 * Obtém a URL.
	 * @param urlCompleta URL completa
	 * @param criar Cria caso não exista
	 * @return UrlDTO
	 */
	private UrlDTO obterUrl(String urlCompleta, boolean criar) {
		UrlDTO url = null;
		if (GenericValidator.isBlankOrNull(urlCompleta)) {
			throw new BusinessException(new Message("erro.campo.obrigatorio", "url"));
		}
		
		URL urlJava;
		try {
			urlJava = new URL(urlCompleta);
		} catch (MalformedURLException e) {
			throw new BusinessException(new Message("url.invalida"));
		}
		
		DominioUrlDTO dominio = this.getDao().obterDominio(urlJava.getHost());
		if ((dominio == null) && criar) {
			dominio = new DominioUrlDTO();
			dominio.setDscDominioUrl(urlJava.getHost());
			this.getDao().criarDominio(dominio);
		}
		
		if (dominio != null) {
			url = this.getDao().obterUrl(dominio.getIdDominioUrl(), urlJava.getPath());
			if ((url == null) && criar) {
				url = new UrlDTO();
				url.setDscCaminho(urlJava.getPath());
				url.setDominio(dominio);
				this.getDao().criarUrl(url);
			}
			if (url != null) {
				url.setDominio(dominio);
			}
		}
		
		return url;
	}
	
	/**
	 * Obtém o campo dao.
	 * @return dao
	 */
	private ComentarioDAO getDao() {
		return this.dao;
	}
	
	@Override
	public List<ComentarioDTO> obterComentarios(UrlDTO urlParam) {
		List<ComentarioDTO> comentarios = new ArrayList<>();
		UrlDTO url = this.obterUrl(urlParam.getUrlCompleta(), false);
		if (url != null) {
			comentarios = this.getDao().obterComentarios(url);
			
			for (ComentarioDTO comentario : comentarios) {
				comentario.setDadosHistoricoMensagem(this.getDao().obterHistoricoMensagem(comentario.getIdMensagem()));
				
				comentario.setQtdLikes(this.getDao().obterQtdLikes(comentario.getIdMensagem()));
				comentario.setQtdDislikes(this.getDao().obterQtdDislikes(comentario.getIdMensagem()));
				comentario.setQtdRespostas(this.getDao().obterQtdRespostas(comentario.getIdComentario()));
				
				AcaoUsuarioDTO acao = this.getDao().obterAcaoUsuario(comentario.getIdAcaoUsuario());
				comentario.setAcaoUsuario(acao);
				
				acao.setUsuario(this.getUsuarioFacade().obterUsuario(acao.getIdUsuario()));
			}
		}
		
		return comentarios;
	}
	
	/**
	 * Obtém o campo usuarioFacade.
	 * @return usuarioFacade
	 */
	private UsuarioFacade getUsuarioFacade() {
		return this.usuarioFacade;
	}
	
	@Override
	public void likarComentario(UsuarioDTO usuario, Integer idComentario) {
		ComentarioDTO comentario = this.getDao().obterComentario(idComentario);
		this.likarMensagem(comentario.getIdMensagem(), usuario);
	}
	
	/**
	 * Lika uma mensagem
	 * @param idMensagem Id da mensagem
	 * @param usuario Usuário
	 */
	private void likarMensagem(Integer idMensagem, UsuarioDTO usuario) {
		LikeMensagemDTO like = new LikeMensagemDTO();
		like.setIdMensagem(idMensagem);
		
		LikeMensagemDTO likeJaFeito = this.getDao().obterLikeMensagem(idMensagem, usuario.getIdUsuario());
		
		if (likeJaFeito != null) {
			this.getDao().removerLikeMensagem(likeJaFeito.getIdLikeMensagem());
			return;
		}
		
		DislikeMensagemDTO dislike = this.getDao().obterDislikeMensagem(idMensagem, usuario.getIdUsuario());
		
		if (dislike != null) {
			this.getDao().removerDislikeMensagem(dislike.getIdDislikeMensagem());
		}
		
		AcaoUsuarioDTO acao = new AcaoUsuarioDTO();
		acao.setUsuario(usuario);
		this.gravarAcaoUsuario(acao);
		like.setAcaoUsuario(acao);
		
		this.getDao().criarLikeMensagem(like);
	}
	
	@Override
	public void dislikarComentario(UsuarioDTO usuario, Integer idComentario) {
		ComentarioDTO comentario = this.getDao().obterComentario(idComentario);
		this.dislikarMensagem(comentario.getIdMensagem(), usuario);
	}
	
	/**
	 * Dislika a mensagem.
	 * @param idMensagem Id da mensagem
	 * @param usuario Usuário
	 */
	private void dislikarMensagem(Integer idMensagem, UsuarioDTO usuario) {
		DislikeMensagemDTO dislike = new DislikeMensagemDTO();
		dislike.setIdMensagem(idMensagem);
		
		DislikeMensagemDTO dislikeJaFeito = this.getDao().obterDislikeMensagem(idMensagem, usuario.getIdUsuario());
		
		if (dislikeJaFeito != null) {
			this.getDao().removerDislikeMensagem(dislikeJaFeito.getIdDislikeMensagem());
			return;
		}
		
		LikeMensagemDTO like = this.getDao().obterLikeMensagem(idMensagem, usuario.getIdUsuario());
		
		if (like != null) {
			this.getDao().removerLikeMensagem(like.getIdLikeMensagem());
		}
		
		AcaoUsuarioDTO acao = new AcaoUsuarioDTO();
		acao.setUsuario(usuario);
		this.gravarAcaoUsuario(acao);
		dislike.setAcaoUsuario(acao);
		
		this.getDao().criarDislikeMensagem(dislike);
	}
	
	@Override
	public void inserirResposta(RespostaDTO resposta) {
		this.gravarMensagem(resposta);
		this.getDao().criarResposta(resposta);
	}
	
	@Override
	public List<RespostaDTO> obterRespostas(Integer idComentario) {
		List<RespostaDTO> respostas = this.getDao().obterRespostas(idComentario);
		
		for (RespostaDTO resposta : respostas) {
			resposta.setDadosHistoricoMensagem(this.getDao().obterHistoricoMensagem(resposta.getIdMensagem()));
			
			resposta.setQtdLikes(this.getDao().obterQtdLikes(resposta.getIdMensagem()));
			resposta.setQtdDislikes(this.getDao().obterQtdDislikes(resposta.getIdMensagem()));
			
			AcaoUsuarioDTO acao = this.getDao().obterAcaoUsuario(resposta.getIdAcaoUsuario());
			resposta.setAcaoUsuario(acao);
			
			acao.setUsuario(this.getUsuarioFacade().obterUsuario(acao.getIdUsuario()));
		}
		
		return respostas;
	}
	
	@Override
	public void likarResposta(UsuarioDTO usuario, Integer idResposta) {
		RespostaDTO resposta = this.getDao().obterResposta(idResposta);
		this.likarMensagem(resposta.getIdMensagem(), usuario);
		
	}
	
	@Override
	public void dislikarResposta(UsuarioDTO usuario, Integer idResposta) {
		RespostaDTO resposta = this.getDao().obterResposta(idResposta);
		this.dislikarMensagem(resposta.getIdMensagem(), usuario);
	}
	
}
