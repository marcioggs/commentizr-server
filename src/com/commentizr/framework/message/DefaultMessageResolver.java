package com.commentizr.framework.message;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import com.commentizr.framework.aspect.ExceptionAspect;

/**
 * Classe responsável pela implementação da resolução padrão das mensagens de properties.
 */
@Component
public class DefaultMessageResolver implements MessageResolver {
	
	private static final Log LOGGER = LogFactory.getLog(ExceptionAspect.class);
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private Locale defaultLocale;
	
	@Override
	public void resolveMessage(Message msg) {
		this.resolveMessage(msg, this.getDefaultLocale());
	}
	
	/**
	 * Resolve a mensagem de acordo com o locale informado.
	 * @param msg Mensagem
	 * @param locale Locale
	 */
	private void resolveMessage(Message msg, Locale locale) {
		try {
			this.internalResolveMessage(msg, locale);
		} catch (NoSuchMessageException e) {
			try {
				this.internalResolveMessage(msg, null);
			} catch (NoSuchMessageException e2) {
				DefaultMessageResolver.LOGGER.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * Resolve a mensagem.
	 * @param msg Mensagem
	 * @param locale Locale
	 */
	private void internalResolveMessage(Message msg, Locale locale) {
		try {
			String textoMensagem = StringUtils.capitalize(this.getMessageSource().getMessage(msg.getKey(),
					msg.getParameters(), locale));
			msg.setMessage(textoMensagem);
		} catch (NoSuchMessageException e) {
			msg.setMessage("Mensagem [" + msg.getKey() + "] não encontrada.");
			throw e;
		}
	}
	
	/**
	 * Obtém o campo messageSource.
	 * @return messageSource
	 */
	public MessageSource getMessageSource() {
		return this.messageSource;
	}
	
	/**
	 * Especificao o campo messageSource.
	 * @param messageSource messageSource
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * Obtém o campo defaultLocale.
	 * @return defaultLocale
	 */
	public Locale getDefaultLocale() {
		return this.defaultLocale;
	}
	
	/**
	 * Especificao o campo defaultLocale.
	 * @param defaultLocale defaultLocale
	 */
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}
	
}
