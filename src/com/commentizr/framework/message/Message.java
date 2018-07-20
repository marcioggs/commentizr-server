package com.commentizr.framework.message;

import java.util.Arrays;

/**
 * Classe responsável pelas mensagens do sistema.
 */
public class Message {
	
	private String key;
	private String message;
	private Object[] parameters;
	
	/**
	 * Construtor padrão.
	 */
	public Message() {
	}
	
	/**
	 * Construtor com a chave da mensagem.
	 */
	public Message(String key) {
		this.key = key;
	}
	
	/**
	 * Construtor com a chave da mensagem e seus parâmetros.
	 */
	public Message(String key, Object... parameters) {
		this.key = key;
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		return "Message [key='" + this.key + "', message='" + this.message + "', parameters="
				+ Arrays.toString(this.parameters) + "]";
	}
	
	/**
	 * Obtém o campo key.
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Especificao o campo key.
	 * @param key key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Obtém o campo message.
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Especificao o campo message.
	 * @param message message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Obtém o campo parameters.
	 * @return parameters
	 */
	public Object[] getParameters() {
		return this.parameters;
	}
	
	/**
	 * Especificao o campo parameters.
	 * @param parameters parameters
	 */
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}