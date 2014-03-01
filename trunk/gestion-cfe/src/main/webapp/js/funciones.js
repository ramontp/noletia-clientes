/**
 * funciones genéricas JavaScript
 */

$(document).ready(function(){
	$('a[href*="' + procesaURL(location.pathname.split("/")[2]) + '"]').addClass('active');
	
	$("tr.odd>td").removeClass("res");
	$("tr.odd>td").addClass("res2");
	
	$('a[href*="borra"]').click(function(){
		var confirma = "";
		if (objeto == 'Provincia'){
			confirma="Vas a eliminar una provincia. ¿Estás seguro?";
		} else if (objeto == 'Genero'){
			confirma="Vas a eliminar un genero. ¿Estás seguro?";
		} else if (objeto == 'Espacio'){
			confirma="Vas a eliminar un espacio. ¿Estás seguro?";
		}
		if (!confirm(confirma)){
			return false;
		}
	});	
	
	if (typeof edicion != 'undefined' && edicion){
		// realizamos los cambios necesarios para la edición
		$("#form1").prop("action","actualiza"+objeto+".action");
		$("#cancelar").css("display","");
		$("#cuerpo>#capaform>fieldset>legend").html("<a href='#'>Edición de "+objeto+"</a>");
	}
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
	
	// mostramos el mensaje si tuviera algo
	muestraMensaje();

});

function procesaURL(url){
	var res = "";
	var aux = url;
	var index = 0;
	if (url.indexOf('?') > -1){
		aux = (url.split("?"))[0];
	}
	for (var i = 0; i < aux.length ; i++){
		if (aux.charAt(i) == aux.charAt(i).toUpperCase()){
			index = i;
			break;
		}
	}
	res = aux.substring(index);
	return res;
}

function muestraMensaje(){
	if (mensaje != ''){
		$("#showmensaje").html("<div id='spanshowmensaje' class='oculto'>"+mensaje+"</div>");
		$("#spanshowmensaje").fadeIn(500);
		setTimeout(function(){$("#spanshowmensaje").fadeOut(1000);},2000);
	}	
}

