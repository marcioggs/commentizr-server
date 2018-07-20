<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="usuarioLogado">
	<s:property value="#session['usuario'].nmeExibicao" />
	@<s:property value="#session['usuario'].nmeConta" />
	<br />
	<div id="frmInserirComentario">
		<s:textfield name="comentario.dscTextoMensagem" />
		<input type="button" id="btInserirComentario" value="Comentar" />
	</div>
</div>

<div id="comentarios">
	<s:iterator value="comentarios">
		<div class="comentario">
			<div class="detalhesComentario ">
				<s:hidden name="comentario.idComentario" cssClass="idComentario" value="%{idComentario}" />
				<s:property value="acaoUsuario.usuario.nmeExibicao"/>
				@<s:property value="acaoUsuario.usuario.nmeConta"/>
				<s:property value="acaoUsuario.datAcaoUsuarioFormatada"/>
				<br />
				<s:property value="dscTextoMensagem"/>
				<br />
				<span class="btLikeComentario">
					<s:property value="qtdLikes" /> likes
				</span>
				<span class="btDislikeComentario">
					<s:property value="qtdDislikes" /> dislikes
				</span>
				<span class="btExibirRespostas">
					<s:property value="qtdRespostas" /> respostas
				</span>
			</div>
			
			<div class="respostas"></div>
		</div>
	</s:iterator>
</div>
