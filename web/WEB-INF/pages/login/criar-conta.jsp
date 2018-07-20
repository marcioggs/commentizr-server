<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="frmCriarConta">
	Nome da conta: <s:textfield name="usuario.nmeConta" />
	<br />
	Email: <s:textfield name="usuario.dscEmail" />
	<br />
	Nome de exibição: <s:textfield name="usuario.nmeExibicao" />
	<br />
	Senha: <s:password name="usuario.senhaConta.dscSenha" />
	<br />
	Confirmação da senha: <s:password name="usuario.senhaConta.dscConfirmacaoSenha" />
	<br />
	<input type="button" id="btCriarConta" value="Criar conta" />
</div>
