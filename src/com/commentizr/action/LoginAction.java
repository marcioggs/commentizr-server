package com.commentizr.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.commentizr.dto.UrlDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.facade.UsuarioFacade;
import com.commentizr.util.Constantes;
import com.opensymphony.xwork2.Action;

/**
 * Classe responsável pelas ações de comentário.
 */

@Controller
@Scope("Request")
public class LoginAction extends BaseAction {
	
	private static final long serialVersionUID = -5305643227387943440L;
	
	@Autowired
	private UsuarioFacade facade;
	
	private UsuarioDTO usuario = new UsuarioDTO();
	private UrlDTO url;
	
	/**
	 * Cria a conta de usuário
	 * @return Resultado
	 */
	public String criarConta() {
		this.facade.criarUsuario(this.usuario, this.getBaseUrl());
		return Action.SUCCESS;
	}
	
	/**
	 * Processa o login.
	 * @return Resultado
	 */
	public String processarLogin() {
		this.getFacade().autenticarUsuario(this.getUsuario().getNmeConta(),
				this.getUsuario().getSenhaConta().getDscSenha());
		
		UsuarioDTO usuarioObtido = this.getFacade().obterUsuarioPorNomeConta(this.getUsuario().getNmeConta());
		this.getSession().put(Constantes.SESSAO_USUARIO, usuarioObtido);
		
		return Action.SUCCESS;
	}
	
	/**
	 * Recupera a conta do usuário.
	 * @return Retorno
	 */
	public String recuperarConta() {
		this.getFacade().trocarSenhaRecuperacaoConta(this.getUsuario());
		return Action.SUCCESS;
	}
	
	/**
	 * Confirma a conta do usuário.
	 * @return Resultado
	 */
	public String confirmarConta() {
		this.facade.confirmarConta(this.getUsuario());
		return Action.SUCCESS;
	}
	
	/**
	 * Envia o email para recuperação da conta.
	 * @return Resultado
	 */
	public String enviarEmailRecuperacaoConta() {
		this.facade.enviarEmailRecuperacaoConta(this.getUsuario().getDscEmail(), this.getBaseUrl());
		return Action.SUCCESS;
	}
	
	/**
	 * Obtém o campo usuario.
	 * @return usuario
	 */
	public UsuarioDTO getUsuario() {
		return this.usuario;
	}
	
	/**
	 * Especificao o campo usuario.
	 * @param usuario usuario
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
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
	 * Obtém o campo facade.
	 * @return facade
	 */
	private UsuarioFacade getFacade() {
		return this.facade;
	}
	
}
