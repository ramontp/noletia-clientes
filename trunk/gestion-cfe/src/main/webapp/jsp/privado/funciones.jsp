<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>


<div id="capaform">
	<fieldset>
		<s:if test="(idfuncion == null || idfuncion.equals(''))">
			<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Función</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Función</a></legend>
			<form id="form1" action="altaFuncion" method="post">
				<s:fielderror/>
				<label for="compania">Compañía:</label>
				<s:select list="listaCompanias" name="idcompania" headerKey="" headerValue="-Seleccione-" listKey="idcompania" listValue="nombre" theme="simple"></s:select>
				<br>
				<label for="espacio">Espacio:</label>
				<s:select list="listaEspacios" name="idespacio" headerKey="" headerValue="-Seleccione-" listKey="idEspacio" listValue="espacio" theme="simple"></s:select>
				<br>
				<label for="fecha">Fecha:</label>
				<sx:datetimepicker name="fecha" id="fecha" displayFormat="dd-MM-yyyy" value="fechaActual" />
				<br>
				<label for="telefonos">Recaudacion:</label>
				<s:textfield name="recaudacion" id="recaudacion" maxlength="45" theme="simple" />
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
				<input type="hidden" name="idfuncion" value="<s:property value="idfuncion" />" />
				<label for="compania">Compañía:</label>
				<s:select list="listaCompanias" name="idcompania" headerKey="" headerValue="-Seleccione-" listKey="idcompania" listValue="nombre" theme="simple"></s:select>
				<br>
				<label for="espacio">Espacio:</label>
				<s:select list="listaEspacios" name="idespacio" headerKey="" headerValue="-Seleccione-" listKey="idEspacio" listValue="espacio" theme="simple"></s:select>
				<br>
				<label for="fecha">Fecha:</label>
				<sx:datetimepicker name="fecha" id="fecha" displayFormat="dd-MM-yyyy" value="fechaActual" />
				<br>
				<label for="telefonos">Recaudacion:</label>
				<s:textfield name="recaudacion" id="recaudacion" maxlength="45" theme="simple" />
				<br>
				<label for="observaciones">Observaciones</label>
				<s:textarea name="observaciones" id="observaciones" theme="simple"></s:textarea>

				<br>
				<input type="button" value="Cancelar" onclick="cancelarEdicion();">
				<input type="submit" value="Actualizar">
			</form>
			<form id="form2" action="gestionFunciones" method="post"></form>
		</s:else>
	</fieldset>
</div>
<br>
<div id="listaExistentes">
	Lista de funciones dadas de alta:
	<br>
	<display:table name="listaFunciones" id="lista">
		<display:column title="Compañía" property="compania.nombre"></display:column>
		<display:column title="Espacio" property="espacio.espacio"></display:column>
		<display:column title="Fecha" property="fecha" format="{0,date,dd-MM-yyyy}"></display:column>
		<display:column title="Recaudación">
			<c:out value="${lista.recaudacion}"></c:out> €
		</display:column>
		<display:column title="Observaciones" property="observaciones"></display:column>
		<display:column href="editaFuncion.action" paramId="idfuncion" paramProperty="idfuncion" >
			Editar
		</display:column>
		<display:column href="borraFuncion.action" paramId="idfuncion" paramProperty="idfuncion" >
			Borrar
		</display:column>
	</display:table>
</div>

<script type="text/javascript">
<!--
function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','buscaFuncion');
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
	//borramos los posibles mensajes de error
	$("#form1>ul").remove();
}
function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','altaFuncion');
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
