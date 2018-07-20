<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="frmLogin">
	Usuário: <s:textfield name="usuario.nmeConta" />
	<br />
	Senha: <s:password name="usuario.senhaConta.dscSenha" />
	<br />
	<input type="button" id="btLogin" value="Login" />
	<br />
	<input type="button" id="btIniciarCriarConta" value="Criar nova conta" />
	<br />
	<input type="button" id="btIniciarEnviarEmailRecuperacaoConta" value="Esqueci minha senha" />
</div>
