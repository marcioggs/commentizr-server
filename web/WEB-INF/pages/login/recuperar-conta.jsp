<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="hasActionErrors()">
	<s:iterator value="actionErrors">
		<div class="erro"><s:property /></div>
	</s:iterator>
</s:if>

<s:form namespace="login" action="recuperarConta.do">
	<s:hidden name="usuario.nmeConta" />
	<s:hidden name="usuario.senhaRecuperacaoConta.dscSenha" />
	
	Nome da conta: <s:property value="usuario.nmeConta"/>
	<br />
	Nova senha: <s:password name="usuario.senhaConta.dscSenha" />
	<br />
	Confirmação nova senha: <s:password name="usuario.senhaConta.dscConfirmacaoSenha" />
	<br />
	<s:submit value="Recuperar conta"/>
</s:form>
