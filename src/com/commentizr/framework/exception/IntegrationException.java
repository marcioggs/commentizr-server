package com.commentizr.framework.exception;

import java.util.List;

import com.commentizr.framework.message.Message;

/**
 * Classe responsável pelas exceções de integração.
 */
public class IntegrationException extends BaseException {
	
	private static final long serialVersionUID = -3083527524730068702L;
	
	/**
	 * Construtor padrão.
	 */
	public IntegrationException() {
	}
	
	/**
	 * Construtor com a lista de mensagens.
	 */
	public IntegrationException(List<Message> messages) {
		super(messages);
	}
	
	/**
	 * Construtor com a lista de mensagens.
	 */
	public IntegrationException(Message... messages) {
		super(messages);
	}
	
	/**
	 * Construtor com a mensagem e lista de mensagens.
	 */
	public IntegrationException(String message, Message... messages) {
		super(message, messages);
	}
	
	/**
	 * Construtor com a mensagem, causa e lista de mensagens.
	 */
	public IntegrationException(String message, Throwable cause, Message... messages) {
		super(message, cause, messages);
	}
	
	/**
	 * Construtor com a mensagem e a causa da exceção.
	 */
	public IntegrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Construtor com a mensagem.
	 */
	public IntegrationException(String message) {
		super(message, new Message[0]);
	}
	
	/**
	 * Construtor com a causa e mensagem.
	 */
	public IntegrationException(Throwable cause, Message... messages) {
		super(cause, messages);
	}
	
	/**
	 * Construtor com a causa.
	 */
	public IntegrationException(Throwable cause) {
		super(cause);
	}
	
}
