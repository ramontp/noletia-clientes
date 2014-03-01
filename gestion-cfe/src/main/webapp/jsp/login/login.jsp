<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
&nbsp;
<s:div id="loginCentro">
<h3>Acceso administración:</h3>
<s:form action="login">
<table>
	<tr>
		<td>Usuario</td>
		<td><input type="text" name="usuario"/></td>
	</tr>
	<tr>
		<td>Contrase&ntilde;a</td>
		<td><input type="password" name="password" /></td>
	</tr>
  <s:submit value="Acceder"/>
</table>
</s:form>
</s:div>