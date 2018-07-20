package com.commentizr.framework.exception;

import java.util.List;

import com.commentizr.framework.message.Message;

/**
 * Classe responsável pelas exceções de negócio.
 */
public class BusinessException extends BaseException {
	
	private static final long serialVersionUID = -6346136771921121798L;
	
	/**
	 * Construtor padrão.
	 */
	public BusinessException(List<Message> messages) {
		super(messages);
	}
	
	/**
	 * Construtor com a mensagem e a causa da exceção.
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Construtor com a mensagem.
	 */
	public BusinessException(String message) {
		super(message, new Message[0]);
	}
	
	/**
	 * Construtor com a causa.
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Construtor com a lista de mensagens.
	 */
	public BusinessException(Message... messages) {
		super(messages);
	}
	
	/**
	 * Construtor com a mensagem e lista de mensagens.
	 */
	public BusinessException(String message, Message... messages) {
		super(message, messages);
	}
	
	/**
	 * Construtor com a mensagem, causa e lista de mensagens.
	 */
	public BusinessException(String message, Throwable cause, Message... messages) {
		super(message, cause, messages);
	}
	
	/**
	 * Construtor com a causa e a lista de mensagens.
	 */
	public BusinessException(Throwable cause, Message... messages) {
		super(cause, messages);
	}
}
