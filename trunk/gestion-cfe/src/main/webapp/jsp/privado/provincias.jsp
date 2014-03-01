<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="showmensaje"></div>
<div id="capaform">
	<fieldset>
		<s:if test="(nombreProvincia != null)">
			<script type="text/javascript">
				edicion = true;
			</script>
		</s:if>
			<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Provincias</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Provincias</a></legend>
			<form id="form1" action="altaProvincia" method="post">
				<div id="errores">
					<s:fielderror />
				</div>
				<s:hidden name="idprovincia" id="idprovincia" theme="simple"></s:hidden>
				<label for="nombreProvincia">Provincia:</label>
				<s:textfield theme="simple" name="nombreProvincia" id="nombreProvincia" maxlength="45"></s:textfield>
				<br><br>
				<input type="button" id="cancelar" value="Cancelar" onclick="cancelarEdicion();" style="display:none">
				<input type="submit" id="boton1" value="Aceptar">
			</form>
			<form id="form2" action="entradaProvincia" method="post"></form>
	</fieldset>
</div>
<br>
<div id="listaExistentes">
	Lista de provincias dadas de alta:<br><br>
	<display:table name="listaProvincias" id="lista" class="elmtos">
		<display:column title="Nombre" property="nombreProvincia" class="res"></display:column>
		<display:column class="res" style="width: 50px">
			<a href="editaProvincia.action?idprovincia=${lista.idprovincia}"><img src="img/editar.gif" /></a>
			<a href="borraProvincia.action?idprovincia=${lista.idprovincia}"><img src="img/borrar.png" /></a>
		</display:column>
	</display:table>
</div>

<script type="text/javascript">
<!--
var objeto = "Provincia";

function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','buscaProvincia');
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
}
function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','altaProvincia');
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").removeClass("leyendaSeleccionada");
}

function cancelarEdicion(){
	$("#form2").submit();
}

$(document).ready(function(){
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
});

var mensaje = '<c:out value="${mensaje}"/>';
//-->
</script>
