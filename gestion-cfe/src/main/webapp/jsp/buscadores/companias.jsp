<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<h5>Compañías</h5>
<br>
<div id="buscadorCompanias">
	<form action="buscaCompanias">
		<fieldset>
			<legend>Buscador de Compañías</legend>
			<label for="nombrec">Nombre</label>
			<input type="text" id="nombrec" />
			<input type="submit" value="Buscar" />
		</fieldset>
	</form>
</div>
<br>
<div id="resultadosBuscador">
	<h6>Resultados</h6>
	<display:table name="listaCompanias" />
</div>


    