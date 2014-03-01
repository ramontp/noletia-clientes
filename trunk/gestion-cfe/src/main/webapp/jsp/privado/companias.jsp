<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="capaform">
	<fieldset>
		<s:if test="(idcompania == null || idcompania.equals(''))">
			<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Compañía</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Compañías</a></legend>
			<form id="form1" action="altaCompania" method="post">
				<s:fielderror/>
				<label for="nombre">Nombre:</label>
				<s:textfield name="nombre" id="nombre" maxlength="45" theme="simple" />
				<br>
				<label for="genero">Género:</label>
				<s:select list="listaGeneros" id="genero" name="idgenero" headerKey="" headerValue="-Seleccione-" listKey="idgenero" listValue="nombreGenero" theme="simple"></s:select>
				<br>
				<label for="contacto">Contacto:</label>
				<s:textfield name="contacto" id="contacto" maxlength="100" theme="simple"/>
				<br>
				<label for="telefonos">Teléfonos:</label>
				<s:textfield name="telefonos" id="telefonos" maxlength="45" theme="simple" />
				<br>
				<label for="emails">Emails:</label>
				<s:textfield name="emails" id="emails" maxlength="100" theme="simple" />
				<br>
				<label for="provincia">Provincia:</label>
				<s:select list="listaProvincias" id="provincia" name="idprovincia" headerKey="" headerValue="-Seleccione-" listKey="idprovincia" listValue="nombreProvincia" theme="simple"></s:select>
				<br>
				<label for="emails">Compromiso ECE:</label>
				<s:checkbox id="compromisoECE" name="compromisoECE" theme="simple"></s:checkbox>
				<br>
				<label for="nfunciones">Nº funciones adeudadas:</label>
				<s:textfield name="nfunciones" id="nfunciones" maxlength="3" theme="simple" />
				<br>
				<label for="observaciones">Observaciones</label>
				<s:textarea name="observaciones" id="observaciones" theme="simple"></s:textarea>
				<br>
				<input type="submit" id="boton1" value="Aceptar">
			</form>
		</s:if>
		<s:else>
			<legend><a href="#" class="leyenda">Edición de Compañías</a></legend>
			<form id="form1" action="actualizaCompania" method="post">
				<s:fielderror/>
				<input type="hidden" name="idcompania" value="<s:property value="idcompania" />" />
				<label for="nombre">Nombre:</label>
				<s:textfield name="nombre" id="nombre" maxlength="45" theme="simple" />
				<br>
				<label for="provincia">Género:</label>
				<s:select list="listaGeneros" name="idgenero" headerKey="" headerValue="-Seleccione-" listKey="idgenero" listValue="nombreGenero" theme="simple"></s:select>
				<br>
				<label for="contacto">Contacto:</label>
				<s:textfield name="contacto" id="contacto" maxlength="100" theme="simple"/>
				<br>
				<label for="telefonos">Teléfonos:</label>
				<s:textfield name="telefonos" id="telefonos" maxlength="45" theme="simple" />
				<br>
				<label for="emails">Emails:</label>
				<s:textfield name="emails" id="emails" maxlength="100" theme="simple" />
				<br>
				<label for="provincia">Provincia:</label>
				<s:select list="listaProvincias" name="idprovincia" headerKey="" headerValue="-Seleccione-" listKey="idprovincia" listValue="nombreProvincia" theme="simple"></s:select>
				<br>
				<label for="emails">Compromiso ECE:</label>
				<s:checkbox id="compromisoECE" name="compromisoECE" theme="simple"></s:checkbox>
				<br>
				<label for="nfunciones">Nº funciones adeudadas:</label>
				<s:textfield name="nfunciones" id="nfunciones" maxlength="3" theme="simple" />
				<br>
				<label for="observaciones">Observaciones</label>
				<s:textarea name="observaciones" id="observaciones" theme="simple"></s:textarea>

				<br>
				<input type="button" value="Cancelar" onclick="cancelarEdicion();">
				<input type="submit" value="Actualizar">
			</form>
			<form id="form2" action="gestionCompanias" method="post"></form>
		</s:else>
	</fieldset>
</div>
<br>
<div id="listaExistentes">
	Lista de Compañías dadas de alta:
	<br>
	<display:table name="listaCompanias" id="lista">
		<display:column title="Nombre" property="nombre"></display:column>
		<display:column title="Género" property="genero.nombreGenero"></display:column>
		<display:column title="Contacto" property="contacto"></display:column>
		<display:column title="Telefonos" property="telefonos"></display:column>
		<display:column title="Emails" property="emails"></display:column>
		<display:column title="Provincia" property="provincia.nombreProvincia"></display:column>
		<display:column title="Compromiso ECE">
			<c:choose>
				<c:when test="${lista.compromisoECE eq 1}">Sí</c:when>	
				<c:otherwise>No</c:otherwise>
			</c:choose>
		</display:column>
		<display:column title="Nº Funciones Adeudadas" property="nFuncionesAdeudadas"></display:column>
		<display:column title="Observaciones" property="observaciones"></display:column>
		<display:column href="editaCompania.action" paramId="idcompania" paramProperty="idcompania" >
			Editar
		</display:column>
		<display:column href="borraCompania.action" paramId="idcompania" paramProperty="idcompania" >
			Borrar
		</display:column>
	</display:table>
</div>

<script type="text/javascript">
<!--
function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','buscaCompania');
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
	//borramos los posibles mensajes de error
	$("#form1>ul").remove();
}
function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','altaCompania');
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
