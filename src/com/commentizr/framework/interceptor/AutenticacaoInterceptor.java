package com.commentizr.framework.interceptor;

import java.util.Map;

import com.commentizr.dto.UsuarioDTO;
import com.commentizr.util.Constantes;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Classe interceptadora responsável pela verificação da autenticação do usuário.
 */
public class AutenticacaoInterceptor extends BaseInterceptor implements Interceptor {
	
	private static final long serialVersionUID = 2822559026918150438L;
	
	@Override
	public void init() {
	}
	
	@Override
	public void destroy() {
	}
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> sessao = actionInvocation.getInvocationContext().getSession();
		UsuarioDTO usuario = (UsuarioDTO) sessao.get(Constantes.SESSAO_USUARIO);
		if (usuario == null) {
			return Action.LOGIN;
		}
		return actionInvocation.invoke();
	}
}
