package com.commentizr.framework.aspect;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import com.commentizr.framework.exception.BaseException;
import com.commentizr.framework.exception.BusinessException;
import com.commentizr.framework.exception.IntegrationException;
import com.commentizr.framework.message.Message;
import com.commentizr.framework.message.MessageResolver;

/**
 * Classe responsável pelos aspectos de exceção.
 */
@Aspect
public class ExceptionAspect {
	
	private static final Log LOGGER = LogFactory.getLog(ExceptionAspect.class);
	
	@Autowired
	private MessageResolver messageResolver;
	
	// TODO: Logar no struts.xml em vez de aqui.
	// TODO: Não precisa mais converter as runtimes
	
	/**
	 * Método responsável por:
	 * - Conversão de RuntimeException em IntegrationException.
	 * - Logar o erro.
	 * - Resolver as mensagens nos arquivos properties.
	 */
	@Around("@within(org.springframework.stereotype.Service)")
	public Object adviceExcecaoDAO(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			return joinPoint.proceed();
		} catch (BusinessException e) {
			this.resolverMensagens(e);
			throw e;
		} catch (IntegrationException e) {
			this.resolverMensagens(e);
			ExceptionAspect.LOGGER.error(e.getMessage(), e);
			throw e;
		} catch (RuntimeException e) {
			ExceptionAspect.LOGGER.error(e.getMessage(), e);
			throw new IntegrationException(e);
		}
	}
	
	/**
	 * Resolve as mensagens da exceção.
	 * @param e Exceção
	 */
	private void resolverMensagens(BaseException e) {
		if (e.getMessages() != null) {
			List<Message> messages = e.getMessages();
			for (Message message : messages) {
				this.getMessageResolver().resolveMessage(message);
			}
		}
	}
	
	/**
	 * Não lançar exceção ao realizar uma query no banco de dados e não obter resultado.
	 */
	@Around("@within(org.springframework.stereotype.Repository)")
	public Object adviceResultSetVazio(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			return joinPoint.proceed();
		} catch (IncorrectResultSizeDataAccessException e) {
			// Quando não retornar nenhum registro do banco, apenas retornar nulo
			if (e.getActualSize() != 0) {
				throw e;
			}
			return null;
		}
	}
	
	/**
	 * Obtém o campo messageResolver.
	 * @return messageResolver
	 */
	private MessageResolver getMessageResolver() {
		return this.messageResolver;
	}
	
}
