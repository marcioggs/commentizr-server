<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<% response.setStatus(409); %>

<s:if test="hasActionErrors()">
	<s:iterator value="actionErrors">
		<div class="erro"><s:property /></div>
	</s:iterator>
</s:if>
