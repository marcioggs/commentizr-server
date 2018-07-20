package com.commentizr.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe responsável por padronização das classes Action.
 */
public class BaseAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 270907568156253987L;
	
	protected Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	/**
	 * Obtém a sessão do usuário.
	 * @return Sessão
	 */
	protected Map<String, Object> getSession() {
		return this.session;
	}
	
	/**
	 * Obtém o request.
	 * @return Request
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	/**
	 * Obtém a URL base da aplicação.
	 * Ex.: http://localhost:8080/commentizr-app/
	 * @return URL
	 */
	protected String getBaseUrl() {
		return "http://" + this.getRequest().getServerName() + ":" + this.getRequest().getServerPort()
				+ this.getRequest().getContextPath() + "/";
	}
	
}
