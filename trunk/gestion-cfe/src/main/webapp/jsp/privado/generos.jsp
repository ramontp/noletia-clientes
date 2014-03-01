<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>



<div id="capaform">
	<fieldset>
		<s:if test="(nombreGenero == null || nombreGenero.equals(''))">
			<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Género</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Generos</a></legend>
			<form id="form1" action="altaGenero" method="post">
				<label for="nombreGenero">Género:</label>
				<input type="text" name="nombreGenero" id="nombreGenero" maxlength="45" />
				<br><br>
				<input type="submit" id="boton1" value="Aceptar">
			</form>
		</s:if>
		<s:else>
			<legend>Edición de Generos</legend>
			<form id="form1" action="actualizaGenero" method="post">
				<input type="hidden" name="idgenero" value="<s:property value="idgenero" />" />
				<label for="nombreGenero">Genero:</label>
				<input type="text" name="nombreGenero" id="nombreGenero" value="<s:property value="nombreGenero" />"  maxlength="45" />
				<br><br>
				<input type="button" value="Cancelar" onclick="cancelarEdicion();">
				<input type="submit" value="Actualizar">
			</form>
			<form id="form2" action="entradaGenero" method="post"></form>
		</s:else>
	</fieldset>
</div>
<br>
<div id="listaExistentes">
	Lista de géneros dados de alta:<br><br>
	<display:table name="listaGeneros" id="lista" class="elmtos">
		<display:column title="Nombre" property="nombreGenero" class="res"></display:column>
		<display:column class="res" style="width: 50px">
			<a href="editaGenero.action?idgenero=${lista.idgenero}"><img src="img/editar.gif" /></a>
			<a href="borraGenero.action?idgenero=${lista.idgenero}"><img src="img/borrar.png" /></a>
		</display:column>
	</display:table>
</div>

<script type="text/javascript">
<!--
var objeto = 'Genero';

function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','buscaGenero');
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
}
function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','altaGenero');
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
