package com.commentizr.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.commentizr.dto.AcaoUsuarioDTO;
import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.SenhaUsuarioDTO;
import com.commentizr.dto.UrlDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.facade.ComentarioFacade;
import com.commentizr.facade.UsuarioFacade;
import com.commentizr.framework.exception.BaseException;
import com.opensymphony.xwork2.Action;

/**
 * Classe responsável pelas ações de comentário.
 */
@Controller
@Scope("Request")
public class TesteAction extends BaseAction {
	
	private static final long serialVersionUID = -5305643227387943440L;
	
	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Autowired
	private ComentarioFacade comentarioFacade;
	
	/**
	 * Processa o login.
	 * @return Resultado
	 */
	public String testar() {
		boolean executar = false;
		
		if (executar) {
			UsuarioDTO usuario = new UsuarioDTO();
			
			usuario.setNmeConta("teste1");
			usuario.setDscEmail("teste1@gmail.com");
			usuario.setNmeExibicao("Márcio Gabriel");
			
			SenhaUsuarioDTO senha = new SenhaUsuarioDTO();
			senha.setDscSenha("Commentizr#2014");
			senha.setDscConfirmacaoSenha("Commentizr#2014");
			
			usuario.setSenhaConta(senha);
			
			try {
				this.usuarioFacade.criarUsuario(usuario, "http://localhost:8080/commentizr-app/");
			} catch (BaseException e) {
				e.getMessages();
			}
		}
		
		if (executar) {
			UsuarioDTO u = new UsuarioDTO();
			u.setNmeConta("teste1");
			SenhaUsuarioDTO s = new SenhaUsuarioDTO();
			s.setDscSenha("xxxxxx");
			u.setSenhaConfirmacaoConta(s);
			
			try {
				this.usuarioFacade.confirmarConta(u);
			} catch (BaseException e) {
				e.getMessages();
			}
		}
		
		if (executar) {
			try {
				this.usuarioFacade.autenticarUsuario("teste1", "Commentizr#2014a");
			} catch (BaseException e) {
				e.getMessages();
			}
		}
		
		if (executar) {
			try {
				this.usuarioFacade.enviarEmailRecuperacaoConta("teste1@gmail.com",
						"http://localhost:8080/commentizr-app/");
			} catch (BaseException e) {
				e.getMessages();
			}
		}
		
		if (executar) {
			try {
				UsuarioDTO u = new UsuarioDTO();
				u.setNmeConta("teste1");
				
				SenhaUsuarioDTO sc = new SenhaUsuarioDTO();
				sc.setDscSenha("Commentizr#2014a");
				sc.setDscConfirmacaoSenha("Commentizr#2014a");
				u.setSenhaConta(sc);
				
				SenhaUsuarioDTO sr = new SenhaUsuarioDTO();
				sr.setDscSenha("3FELQ2Ud");
				u.setSenhaRecuperacaoConta(sr);
				
				this.usuarioFacade.trocarSenhaRecuperacaoConta(u);
			} catch (BaseException e) {
				e.getMessages();
			}
		}
		
		return Action.SUCCESS;
	}
	
	public String inserirUsuario() {
		ComentarioDTO c = new ComentarioDTO();
		c.setDscTextoMensagem("Esse é o meu comentário!!!");
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setIdUsuario(10);
		AcaoUsuarioDTO acao = new AcaoUsuarioDTO();
		acao.setUsuario(usuario);
		c.setAcaoUsuario(acao);
		
		UrlDTO url = new UrlDTO();
		url.setUrlCompleta("http://struts.apache.org/release/2.1.x/docs/action-configuration.html");
		c.setUrl(url);
		
		this.comentarioFacade.inserirComentario(c);
		return Action.SUCCESS;
	}
	
}
