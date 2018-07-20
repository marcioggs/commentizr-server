package com.commentizr.framework.interceptor;

import com.commentizr.framework.exception.BusinessException;
import com.commentizr.framework.message.Message;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Classe interceptadora responsável pela verificação da autenticação do usuário.
 */
public class BusinessExceptionInterceptor extends BaseInterceptor implements Interceptor {
	
	private static final long serialVersionUID = 2330117671393932392L;
	
	@Override
	public void init() {
	}
	
	@Override
	public void destroy() {
	}
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		try {
			return actionInvocation.invoke();
		} catch (BusinessException e) {
			ActionSupport action = (ActionSupport) actionInvocation.getAction();
			for (Message msg : e.getMessages()) {
				action.addActionError(msg.getMessage());
			}
			return Action.ERROR;
		}
	}
}
