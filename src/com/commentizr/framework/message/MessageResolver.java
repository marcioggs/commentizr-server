package com.commentizr.framework.message;

/**
 * Classe responsável por resolver as mensagens nos arquivos properties.
 */
public interface MessageResolver {
	/**
	 * Resolve a mensagem a partir da sua chave.
	 * @param msg Mensagem
	 */
	void resolveMessage(Message msg);
}