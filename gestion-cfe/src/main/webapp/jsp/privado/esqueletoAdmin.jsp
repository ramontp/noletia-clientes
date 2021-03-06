<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="../css/admin.css">
<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
<sx:head />
</head>
<body>

<script type="text/javascript">
	$(document).ready(function (){
		$('a[href*="borra"]').click(function(){
			if (!confirm('Va a eliminar un registro. �Est� seguro?')){
				return false;
			}
		});	
	});
</script>

<div id="wrapper">
	<div id="heading"><tiles:insertAttribute name="header" /></div>
	<div id="divnav"><tiles:insertAttribute name="nav" /></div>
	<div id="centro">
		<div id="cuerpo"><tiles:insertAttribute name="body" /></div>
	</div>
	<div id="pie"><tiles:insertAttribute name="footer" /></div>
</div>

</body>
</html>