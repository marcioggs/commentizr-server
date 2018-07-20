package com.commentizr.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.commentizr.framework.message.Message;

/**
 * Classe responsável pela padronização das classes de exceção.
 */
public abstract class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = -7200750339756872695L;
	
	private String message;
	private List<Message> messages;
	
	/**
	 * Construtor padrão.
	 */
	public BaseException() {
	}
	
	/**
	 * Construtor com a mensagem e a causa da exceção.
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	/**
	 * Construtor com a lista de mensagens.
	 */
	public BaseException(List<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * Construtor com a causa.
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Construtor com a lista de mensagens.
	 */
	public BaseException(Message... messages) {
		this.messages = new ArrayList<>(Arrays.asList(messages));
	}
	
	/**
	 * Construtor com a mensagem, causa e lista de mensagens.
	 */
	public BaseException(String message, Throwable cause, Message... messages) {
		super(message, cause);
		this.messages = new ArrayList<>(Arrays.asList(messages));
		this.message = message;
	}
	
	/**
	 * Construtor com a mensagem e lista de mensagens.
	 */
	public BaseException(String message, Message... messages) {
		super(message);
		this.messages = new ArrayList<>(Arrays.asList(messages));
		this.message = message;
	}
	
	/**
	 * Construtor com a causa e a lista de mensagens.
	 */
	public BaseException(Throwable cause, Message... messages) {
		super(cause);
		this.messages = new ArrayList<>(Arrays.asList(messages));
	}
	
	@Override
	public String getMessage() {
		if ((this.message == null) && (this.getCause() != null)) {
			this.message = this.getCause().getMessage();
		}
		if ((this.message == null) && (this.messages != null)) {
			this.message = "";
			
			for (int i = 0; i < this.messages.size(); i++) {
				String innerMessage = this.messages.get(i).getMessage();
				if (innerMessage == null) {
					innerMessage = this.messages.get(i).getKey();
				}
				this.message += innerMessage;
				if ((i + 1) < this.messages.size()) {
					this.message += ", ";
				}
			}
		}
		return this.message;
	}
	
	@Override
	public void printStackTrace(PrintStream err) {
		String exceptionDetail = this.getExceptionDetail();
		if ((exceptionDetail != null) && (exceptionDetail.length() > 0)) {
			err.append(exceptionDetail + " - ");
		}
		super.printStackTrace(err);
	}
	
	@Override
	public void printStackTrace(PrintWriter err) {
		String exceptionDetail = this.getExceptionDetail();
		if ((exceptionDetail != null) && (exceptionDetail.length() > 0)) {
			err.append(exceptionDetail + " - ");
		}
		super.printStackTrace(err);
	}
	
	/**
	 * Obtém detalhes da exceção
	 * @return Detalhes
	 */
	private String getExceptionDetail() {
		StringBuilder sb = new StringBuilder();
		if (this.getMessages() != null) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append("messages=").append(this.getMessages());
		}
		if (sb.length() > 0) {
			return "[" + sb.toString() + "]";
		}
		return "";
	}
	
	/**
	 * Obtém o campo messages.
	 * @return messages
	 */
	public List<Message> getMessages() {
		return this.messages;
	}
	
	/**
	 * Especificao o campo messages.
	 * @param messages messages
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * Especificao o campo message.
	 * @param message message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
