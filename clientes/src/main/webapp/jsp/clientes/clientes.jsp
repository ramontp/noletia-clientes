<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>


<div id="showmensaje"></div>
<fieldset>
	<legend><a href="#" onclick="muestraAlta();" class="leyenda">Alta de Clientes</a> / <a href="#" onclick="muestraBuscador();" class="leyenda">Buscar Clientes</a></legend>
	<s:form action="altaCliente" onsubmit="return validaform();" theme="simple" id="form1">
		<div id="errores">
			<s:fielderror />
		</div>
		<s:hidden name="contactos" id="contactos" theme="simple"></s:hidden>
		<s:hidden name="idcliente" id="idcliente" theme="simple"></s:hidden>
		<s:hidden name="categoriasseleccionadas" id="categoriasseleccionadas" theme="simple"></s:hidden>
		<div id="capa1">
		<label for="empresa">Empresa</label>
		<s:textfield theme="simple" name="empresa" id="empresa" maxlength="45"></s:textfield>
		<br>
		<label for="datosfiscales">Datos Fiscales</label>
		<s:textarea theme="simple" name="datosfiscales" id="datosfiscales" cols="50" rows="3"></s:textarea>
		<br>
		<label for="provincia">Provincia</label>
		<s:select theme="simple" list="listaProvincias" name="provincia" listKey="idprovincia" listValue="nombre" headerKey="" headerValue="--Seleccione--"></s:select>
		<br>
		<label for="fechault">Último contacto</label>
		<sx:datetimepicker name="fechault" displayFormat="dd-MM-yyyy"></sx:datetimepicker>
		<br>
		<label for="contactado">Contactado por</label>
		<s:textfield theme="simple" name="contactado" id="contactado" maxlength="45"></s:textfield>
		<br>
		<label for="observaciones">Observaciones</label>
		<s:textarea theme="simple" name="observaciones" id="observaciones" cols="50" rows="6"></s:textarea>
		</div>
		<div id="capa2">
			<a href="#" onclick="addContacto(); return false;" class="addcontacto">Añadir contacto</a>
			<div style="clear:both"></div>
			<br>
			<table id="tablaC" style="width: 100%">
				<tr>
					<th width="25%">Contacto</th>
					<th width="18%">Departamento</th>
					<th width="34%">Email</th>
					<th width="18%">Telefono</th>
					<th width="5%"></th>
				</tr>
				<c:if test="${listacontactos ne null}">
					<c:forEach items="${listacontactos}" var="con" varStatus="index">
						<tr id="ncont-${index.count}">
							<td><input type="text" class="input1" value="${con.contacto}" /></td>
							<td><input type="text" class="input2" value="${con.departamento}" /></td>
							<td><input type="text" class="input3" value="${con.email}" /></td>
							<td><input type="text" class="input4" value="${con.telefono}" /></td>
							<td>
								<a href='#' onclick='borraContacto(${index.count},${con.idcontacto})'><img src='img/borrar.png'></a>
								<input type="hidden" name="idcontactoaux" value="${con.idcontacto}" />
							</td>
						</tr>
					</c:forEach>
					<script type="text/javascript">
						ncontacto = '<c:out value="${fn:length(listacontactos)}"/>';
						edicion = true;
					</script>
				</c:if>
			</table>
		</div>
		<div id="capa4">
			<span class="categoria">Categorias</span>
			<br style="clear:both;">
			<br>
			<s:iterator value="listacategorias" var="cat">
				<s:checkbox name="nombrecategoria" id="cat-%{idcategoria}" value="%{seleccionado}"></s:checkbox>${cat.nombrecategoria}<br>
			</s:iterator>
		</div>
		<div style="clear:both"></div>
		<div id="capa3">
			<div style="float:left">
				<label for="empresab">Por empresa</label>
				<s:textfield theme="simple" name="empresab" id="empresab"></s:textfield>
			</div>
			<div style="float:left; margin-left:30px">
				<label for="contactob">y/o por contacto</label>
				<s:textfield theme="simple" name="contactob" id="contactob"></s:textfield>
			</div>
			<div style="clear:both"><br></div>
			<div>
				<label for="nombrecategoria">Por categoría</label>
				<br>
				<s:iterator value="listacategorias" var="cat">
					<s:checkbox name="nombrecategoria" id="b_cat-%{idcategoria}" value="%{seleccionado}"></s:checkbox>${cat.nombrecategoria}<br>
				</s:iterator>
			</div>
			<div style="clear:both"><br></div>
		</div>
		<br>
		<input type="button" id="cancelar" value="Cancelar" onclick="cancelarEdicion();" style="display:none">
		<input type="submit" id="boton1" value="Aceptar">
	</s:form>
	<form id="form2" action="listadoCliente" method="post"></form>
</fieldset>
<br>
<div id="listaExistentes">
	<h4>Listado de Clientes</h4>
	<br>
	<display:table name="listaClientes" id="lista" class="elmtos" 
		decorator="es.noletia.clientes.decorator.ContactosDecorator" requestURI="listadoCliente"
		pagesize="10">
		<display:setProperty name="export.excel.filename" value="clientes.xls"/>
		<display:column title="Empresa" property="empresa" class="res" sortable="true"></display:column>
		<display:column title="Datos Fiscales" property="datosfiscales" class="res"></display:column>
		<display:column title="Provincia" property="provincia.nombre" class="res"></display:column>
		<display:column title="Fecha Última" property="fechault" format="{0,date,dd-MM-yyyy}" class="res"></display:column>
		<display:column title="Contactado Por" property="contactado" class="res"/>
		<display:column title="Observaciones" property="observaciones" class="res" style="width:40%"></display:column>
		<display:column class="res" style="width:54px">
			<c:choose>
				<c:when test="${fn:length(lista.listacontactos) gt 0}">
					<a href="#" onclick='vercontactos(<c:out value="${lista.idcliente}" />); return false;'><img src="img/vercontactos.png" /></a>
				</c:when>
				<c:otherwise>
					<div style="width:19px; height: 15px; float: left;"></div>
				</c:otherwise>
			</c:choose>
			<a href="editaCliente.action?idcliente=${lista.idcliente}"><img src="img/editar.gif" /></a>
			<a href="borraCliente.action?idcliente=${lista.idcliente}"><img src="img/borrar.png" /></a>
		</display:column>
	</display:table>
</div>
<script>
var showBuscador = '<c:out value="${muestraBuscador}"/>';
var mensaje = '<c:out value="${mensaje}"/>';
var objeto = "Cliente";
</script>