<%@ taglib prefix="s" uri="/struts-tags"%>

	<nav id="navigation">
		<ul>
		<s:if test="#session.usuario_autenticado.rol == 'USUARIO' or #session.usuario_autenticado.rol == 'ADMIN'">
			<li><a href="entradaConsultas.action"><span>Consultas</span></a></li>
		</s:if>
		<s:if test="#session.usuario_autenticado.rol == 'ADMIN'">
			<li><a href="gestionCompanias.action"><span>Compa��as</span></a></li>
			<li><a href="gestionFunciones.action"><span>Funciones</span></a></li>
			<li><a href="gestionEspacios.action"><span>Espacios</span></a></li>
			<li><a href="entradaGenero.action"><span>G�neros</span></a></li>
			<li><a href="entradaProvincia.action"><span>Provincia</span></a></li>
		</s:if>
		</ul>
	</nav>
	
	<br>
	
