<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="frmInserirResposta">
	<s:hidden name="comentario.idComentario" cssClass="idComentario" value="%{comentario.idComentario}" />
	<s:hidden name="resposta.idComentario" value="%{comentario.idComentario}" />
	<s:textfield name="resposta.dscTextoMensagem" />
	<input type="button" class="btInserirResposta" value="Responder" />
</div>

<s:iterator value="respostas">
	<div class="resposta">
		<s:hidden name="resposta.idResposta" value="%{idResposta}" />
		<s:property value="acaoUsuario.usuario.nmeExibicao"/>
		@<s:property value="acaoUsuario.usuario.nmeConta"/>
		<s:property value="acaoUsuario.datAcaoUsuarioFormatada"/>
		<br />
				<s:property value="dscTextoMensagem"/>
		<br />
		<span class="btLikeResposta">
			<s:property value="qtdLikes" /> likes
		</span>
		<span class="btDislikeResposta">
			<s:property value="qtdDislikes" /> dislikes
		</span>
	</div>
</s:iterator>
