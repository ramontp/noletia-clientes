<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>



<div id="capaform">
	<fieldset>
		<s:if test="(idespacio == null || idespacio.equals(''))">
			<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Espacio</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Espacios</a></legend>
			<form id="form1" action="altaEspacio" method="post">
				<s:fielderror/>
				<label for="espacio">Espacio:</label>
				<s:textfield name="espacio" id="espacio" maxlength="45" theme="simple"></s:textfield>
				<br>
				<label for="contacto">Contacto:</label>
				<s:textfield name="contacto" id="contacto" maxlength="100"/>
				<br>
				<label for="telefonos">Teléfonos:</label>
				<input type="text" name="telefonos" id="telefonos" maxlength="45" />
				<!-- <br>
				<label for="emails">Emails:</label>
				<input type="text" name="emails" id="emails" maxlength="100" /> -->
				<br>
				<label for="provincia">Provincia:</label>
				<s:select list="listaProvincias" name="provincia" headerKey="" headerValue="-Seleccione-" listKey="idprovincia" listValue="nombreProvincia"></s:select>
				<br><br>
				<input type="submit" id="boton1" value="Aceptar">
			</form>
		</s:if>
		<s:else>
			<legend>Edición de Espacios</legend>
			<form id="form1" action="actualizaEspacio" method="post">
				<s:fielderror/>
				<input type="hidden" name="idespacio" value="<s:property value="idespacio" />" />
				<label for="espacio">Espacio:</label>
				<input type="text" name="espacio" id="espacio" value="<s:property value="espacio" />"  maxlength="45" />
				<br>
				<label for="contacto">Contacto:</label>
				<input type="text" name="contacto" id="contacto" value="<s:property value="contacto" />"  maxlength="100" />
				<br>
				<label for="telefonos">Teléfonos:</label>
				<input type="text" name="telefonos" id="telefonos" value="<s:property value="telefonos" />"  maxlength="45" />
				<%-- <br>
				<label for="emails">Emails:</label>
				<input type="text" name="emails" id="emails" value="<s:property value="emails" />"  maxlength="100" /> --%>
				<br>
				<label for="provincia">Provincia:</label>
				<s:select list="listaProvincias" value="provincia" name="provincia" listKey="idprovincia" listValue="nombreProvincia" id="provincia" emptyOption="true"></s:select>
				<br><br>
				<input type="button" value="Cancelar" onclick="cancelarEdicion();">
				<input type="submit" value="Actualizar">
			</form>
			<form id="form2" action="gestionEspacios" method="post"></form>
		</s:else>
	</fieldset>
</div>
<br>
<div id="listaExistentes">
	Lista de Espacios dados de alta:
	<br><br>
	<display:table name="listaEspacios" id="lista" class="elmtos">
		<display:column title="Espacio" property="espacio" class="res"></display:column>
		<display:column title="Contacto" property="contacto" class="res"></display:column>
		<display:column title="Telefonos" property="telefonos" class="res"></display:column>
		<%-- <display:column title="Emails" property="emails"></display:column> --%>
		<display:column title="Provincia" property="provincia.nombreProvincia" class="res"></display:column>
		<display:column class="res" style="width: 50px;">
			<a href="editaEspacio.action?idespacio=${lista.idespacio}"><img src="img/editar.gif" /></a>
			<a href="borraEspacio.action?idespacio=${lista.idespacio}"><img src="img/borrar.png" /></a>
		</display:column>
	</display:table>
</div>

<script type="text/javascript">
<!--
var objeto = 'Espacio';

function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','buscaEspacio');
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
	//borramos los posibles mensajes de error
	$("#form1>ul").remove();
}
function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','altaEspacio');
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").removeClass("leyendaSeleccionada");
}

function cancelarEdicion(){
	$("#form2").submit();
}

$(document).ready(function(){
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
});
//-->
</script>
