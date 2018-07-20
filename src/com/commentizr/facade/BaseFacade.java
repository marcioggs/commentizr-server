package com.commentizr.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.annotation.Transactional;

import com.commentizr.framework.message.MessageResolver;

/**
 * Classe responsável por padronização das classs Facade.
 */
@Transactional
abstract class BaseFacade {
	
	@Autowired
	private DadosDominioFacade dominioFacade;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private MessageResolver messageResolver;
	
	/**
	 * Envia um email.
	 * @param de De
	 * @param para Para
	 * @param assunto Assunto
	 * @param msg
	 */
	protected void enviarEmail(String de, String para, String assunto, String msg) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(de);
		message.setTo(para);
		message.setSubject(assunto);
		message.setText(msg);
		
		this.mailSender.send(message);
	}
	
	/**
	 * Obtém o campo dominioFacade.
	 * @return dominioFacade
	 */
	protected DadosDominioFacade getDominioFacade() {
		return this.dominioFacade;
	}
	
	/**
	 * Obtém o campo mailSender.
	 * @return mailSender
	 */
	protected MailSender getMailSender() {
		return this.mailSender;
	}
	
	/**
	 * Obtém o campo messageResolver.
	 * @return messageResolver
	 */
	protected MessageResolver getMessageResolver() {
		return this.messageResolver;
	}
	
}
