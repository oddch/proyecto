$(document).on("ready",inicio);

function inicio(){
	$("span.help-block").hide();
	$("a#infoFormat").hide();
	$("br.brl").hide();
	$("#clave").keyup(validarClave);		
	$("#claveN").keyup(validarClaveN);		
	$("#claveC").keyup(validarClaveC);		
	$("#btnCambC").click(validarFormClave);		
	$("#nombre").keyup(validarNombre);		
	$("#apellido").keyup(validarApellido);		
	$("#id").keyup(validarId);	
	$("#idFormat").change(validarId);	
	$("#cargo").change(validarCargo);	
	$("#email").keyup(validarCorreo);	
	$("#telefono").keyup(validarTelefono);	
	$("#direccion").keyup(validarDireccion);
	$("#confClave").keyup(validarClaveConf);
	$("#inicClave").keyup(validarClaveInic);
	$("#guardar").click(validarGuardar);		
}

function validarClave(){

	var clave = $('#clave').val();

	if (clave==null || clave.length ==0){
		$("#iconoFeed").remove();
		$("#clave").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#clave").parent().append('<span id="iconoFeed" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#clave").parent().children("span.help-block").text("Debes Ingresar una contraseña").show();
		$("#clave").parent().children("a").text("").show();
		$("#clave").parent().children("br").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed").remove();
		$("#clave").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#clave").parent().append('<span id="iconoFeed" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#clave").parent().children("span.help-block").text("Formato invalido de contraseña").show();
		$("#clave").parent().children("a").text("").show();
		$("#clave").parent().children("br").text("").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed").remove();
		$("#clave").parent().attr("class", "form-group has-success has-feedback cambioPass")
		$("#clave").parent().append('<span id="iconoFeed" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#clave").parent().children("span.help-block").text("").hide();
		$("#clave").parent().children("a").text("").hide();
		$("#clave").parent().children("br").text("").hide();
		return true;
	}
}

function validarClaveN(){

	var clave = $('#claveN').val();

	if (clave==null || clave.length ==0){
		$("#iconoFeed2").remove();
		$("#claveN").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#claveN").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#claveN").parent().children("span.help-block").text("Debes Ingresar una contraseña").show();
		$("#claveN").parent().children("a").text("").show();
		$("#claveN").parent().children("br").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed2").remove();
		$("#claveN").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#claveN").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#claveN").parent().children("span.help-block").text("Formato invalido de contraseña").show();
		$("#claveN").parent().children("a").text("").show();
		$("#claveN").parent().children("br").text("").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed2").remove();
		$("#claveN").parent().attr("class", "form-group has-success has-feedback cambioPass")
		$("#claveN").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#claveN").parent().children("span.help-block").text("").hide();
		$("#claveN").parent().children("a").text("").hide();
		$("#claveN").parent().children("br").text("").hide();
		return true;
	}
}

function validarClaveC(){

	var clave = $('#claveC').val();
	var claveN = $('#claveN').val();

	if (clave==null || clave.length ==0){
		$("#iconoFeed3").remove();
		$("#claveC").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#claveC").parent().append('<span id="iconoFeed3" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#claveC").parent().children("span.help-block").text("Debes Ingresar una contraseña").show();
		$("#claveC").parent().children("a").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed3").remove();
		$("#claveC").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#claveC").parent().append('<span id="iconoFeed3" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#claveC").parent().children("span.help-block").text("Formato invalido de contraseña").show();
		$("#claveC").parent().children("a").text("").show();
		return false;

	}else if (clave!=claveN) {
		$("#iconoFeed3").remove();
		$("#claveC").parent().attr("class", "form-group has-error has-feedback cambioPass")
		$("#claveC").parent().append('<span id="iconoFeed3" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#claveC").parent().children("span.help-block").text("La contraseña no coincide").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed3").remove();
		$("#claveC").parent().attr("class", "form-group has-success has-feedback cambioPass")
		$("#claveC").parent().append('<span id="iconoFeed3" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#claveC").parent().children("span.help-block").text("").hide();
		$("#claveC").parent().children("a").text("").hide();
		return true;
	}
}

function validarFormClave(){
	
	var clave = $('#clave').val();
	var claveN = $('#claveN').val();
	var claveC = $('#claveC').val();

	if (validarClave()==true && validarClaveN()==true && validarClaveC()==true) {

		if (clave=="123456789") {
			if (claveN==claveC) {
				swal({
					title: "Cambio Exitoso!",
					text: "La contraseña se cambio exitosamente",
					imageUrl: "img/"
				},
				function(){
					window.location.href = 'crearUsuario.html';
				});
			}
		}else{
			$("#iconoFeed").remove();
			$("#clave").parent().attr("class", "form-group has-error has-feedback cambioPass")
			$("#clave").parent().append('<span id="iconoFeed" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
			$("#clave").parent().children("span.help-block").text("La contraseña actual no es correcta").show();
			$("#clave").parent().children("br").text("").show();
			return false;
			
		}
	}return false;
}


$().ready(function(){
	$(".cambiar").click(function(){
		swal("Formato de la contraseña", "La contraseña debe tener mínimo 8 y maximo 15 caracteres");
	})
})


function validarNombre(){

	format = /^([A-Za-zñÑ-áéíóúÁÉÍÓÚ\s\t-])+$/;
	var nombre = $('#nombre').val();

	if (nombre==null || nombre.length ==0){
		$("#iconoFeed4").remove();
		$("#nombre").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#nombre").parent().append('<span id="iconoFeed4" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#nombre").parent().children("span.help-block").text("Debes Ingresar un Nombre").show();
		
		return false;

	}else if (/^\s+$/.test(nombre) || !format.test(nombre)){
		$("#iconoFeed4").remove();
		$("#nombre").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#nombre").parent().append('<span id="iconoFeed4" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#nombre").parent().children("span.help-block").text("Formato invalido de Nombre").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed4").remove();
		$("#nombre").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
		$("#nombre").parent().append('<span id="iconoFeed4" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#nombre").parent().children("span.help-block").text("").hide();
		return true;
	}
}

function validarApellido(){

	format = /^([A-Za-zñÑ-áéíóúÁÉÍÓÚ\s\t-])+$/;
	var apellido = $('#apellido').val();

	if (apellido==null || apellido.length ==0){
		$("#iconoFeed5").remove();
		$("#apellido").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#apellido").parent().append('<span id="iconoFeed5" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#apellido").parent().children("span.help-block").text("Debes Ingresar un Apellido").show();
		return false;

	}else if (/^\s+$/.test(apellido) || !format.test(apellido)){
		$("#iconoFeed5").remove();
		$("#apellido").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#apellido").parent().append('<span id="iconoFeed5" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#apellido").parent().children("span.help-block").text("Formato invalido de Apellido").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed5").remove();
		$("#apellido").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
		$("#apellido").parent().append('<span id="iconoFeed5" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#apellido").parent().children("span.help-block").text("").hide();
		return true;
	}
}


function validarId(){

	formatNIT = /^(\d{9})+\-(\d{1})+$/;
	formatCE = /^(\d{9})+\-(\d{1})+$/;
	indice = document.getElementById("idFormat").selectedIndex;
	
	var id = $('#id').val();

	if( indice == null || indice == 0 ) {
		$("#iconoFeed6").remove();
		$("#idFormat").parent().attr("class", "col-sm-2 backnone has-error has-feedback cambioPass");
		$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass");
		$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#id").parent().children("span.help-block").text("Debes selecionar un tipo documento").show();
		return false;
		}else if (indice == 1) {//CC

			if (id==null || id.length ==0){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone");
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass");
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Debes Ingresar un Documento").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else if (/^\s+$/.test(id) || !(/^\d{6,12}$/.test(id))){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone");
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Formato invalido de CC").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else{//formato Correcto
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone has-success has-feedback cambioPass")
				$("#id").parent().attr("class", "col-sm-5 backnone has-success has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("").hide();
				$("#id").parent().children("a").text("").hide();
				return true;
			}
		}

		if (indice == 2) {//NIT
			$("#id").parent().children("span.help-block").text("").hide();
			if (id==null || id.length ==0){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone")
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Debes Ingresar un Documento").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else if (/^\s+$/.test(id) || !formatNIT.test(id)){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone")
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Formato invalido de NIT").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else{//formato Correcto
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone has-success has-feedback cambioPass")
				$("#id").parent().attr("class", "col-sm-5 backnone has-success has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("").hide();
				$("#id").parent().children("a").text("").hide();
				return true;
			}
		}

		if (indice == 3) {//cc
			$("#id").parent().children("span.help-block").text("").hide();
			if (id==null || id.length ==0){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone");
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Debes Ingresar un Documento").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else if (/^\s+$/.test(id) || !formatCE.test(id)){
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone");
				$("#id").parent().attr("class", "col-sm-5 backnone has-error has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("Formato invalido de CC").show();
				$("#id").parent().children("a").text("").show();
				return false;

			}else{//formato Correcto
				$("#iconoFeed6").remove();
				$("#idFormat").parent().attr("class", "col-sm-2 backnone has-success has-feedback cambioPass");
				$("#id").parent().attr("class", "col-sm-5 backnone has-success has-feedback cambioPass")
				$("#id").parent().append('<span id="iconoFeed6" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
				$("#id").parent().children("span.help-block").text("").hide();
				$("#id").parent().children("a").text("").hide();
				return true;
			}
		}
	}
	

	function validarCargo(){
		var cargo = $('#cargo option:selected').val();
		if( cargo == null || cargo == 0 ) {
			$("#iconoFeed7").remove();
			$("#cargo").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass");
			$("#cargo").parent().append('<span id="iconoFeed7" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
			$("#cargo").parent().children("span.help-block").text("Debes seleccionar un cargo").show();
			return false;
		}else{
			$("#iconoFeed7").remove();
			$("#cargo").parent().append('<span id="iconoFeed7" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
			$("#cargo").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass");
			$("#cargo").parent().children("span.help-block").text("").hide();
			return true;
		}

	}


	function validarCorreo(){
		format = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/  || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+(([a-zA-Z0-9]{2,4})+\.)+([a-zA-Z]{2,4})+$/;
		var correo = $('#email').val();

	if (correo==null || correo.length ==0 || /^\s+$/.test(correo)) {//correo vacio
		$("#iconoFeed8").remove();
		$("#email").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#email").parent().append('<span id="iconoFeed8" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#email").parent().children("span.help-block").text("Debes Ingresar un correo").show();
		return false;

	}else if( !format.test(correo)) {//formato correo invalido
		$("#iconoFeed8").remove();
		$("#email").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#email").parent().append('<span id="iconoFeed8" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#email").parent().children("span.help-block").text("Formato invalido de correo").show();
		return false;	

  	}else{//formato Correcto
  		$("#iconoFeed8").remove();
  		$("#email").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
  		$("#email").parent().append('<span id="iconoFeed8" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
  		$("#email").parent().children("span.help-block").text("").hide();

  		return true;
  	}
  }

	function validarClaveInic(){

	var clave = $('#inicClave').val();

	if (clave==null || clave.length ==0){
		$("#iconoFeed11").remove();
		$("#inicClave").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#inicClave").parent().append('<span id="iconoFeed11" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#inicClave").parent().children("span.help-block").text("Debes Ingresar una contraseña").show();
		$("#inicClave").parent().children("a").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed11").remove();
		$("#inicClave").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#inicClave").parent().append('<span id="iconoFeed11" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#inicClave").parent().children("span.help-block").text("Formato invalido de contraseña").show();
		$("#inicClave").parent().children("a").text("").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed11").remove();
		$("#inicClave").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
		$("#inicClave").parent().append('<span id="iconoFeed11" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#inicClave").parent().children("span.help-block").text("").hide();
		$("#inicClave").parent().children("a").text("").hide();
	return true;
	}
}

function validarClaveConf(){

	var claveN = $('#inicClave').val();
	var clave = $('#confClave').val();

	if (clave==null || clave.length ==0){
		$("#iconoFeed12").remove();
		$("#confClave").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#confClave").parent().append('<span id="iconoFeed12" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#confClave").parent().children("span.help-block").text("Debes Ingresar una contraseña").show();
		$("#confClave").parent().children("a").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed12").remove();
		$("#confClave").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#confClave").parent().append('<span id="iconoFeed12" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#confClave").parent().children("span.help-block").text("Formato invalido de contraseña").show();
		$("#confClave").parent().children("a").text("").show();
		return false;

	}else if (clave!=claveN) {
		$("#iconoFeed12").remove();
		$("#confClave").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#confClave").parent().append('<span id="iconoFeed12" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#confClave").parent().children("span.help-block").text("La contraseña no coincide").show();
		return false;

	}else{//formato Correcto
		$("#iconoFeed12").remove();
		$("#confClave").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
		$("#confClave").parent().append('<span id="iconoFeed12" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#confClave").parent().children("span.help-block").text("").hide();
		$("#confClave").parent().children("a").text("").hide();
		return true;
	}
}
	
  function validarTelefono(){

  	var telefono = $('#telefono').val();

	if (telefono==null || telefono.length ==0 || /^\s+$/.test(telefono)) {//correo vacio
		$("#iconoFeed9").remove();
		$("#telefono").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#telefono").parent().append('<span id="iconoFeed9" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#telefono").parent().children("span.help-block").text("Debes Ingresar un Télefono").show();
		return false;

	}else if( !/^\d\d\d[- .]?\d\d\d\d$/.test(telefono)  && !/^\(?(?:\d{3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/.test(telefono)) {//formato correo invalido
		$("#iconoFeed9").remove();
		$("#telefono").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#telefono").parent().append('<span id="iconoFeed9" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#telefono").parent().children("span.help-block").text("Formato invalido de télefono").show();
		return false;	

  	}else{//formato Correcto
  		$("#iconoFeed9").remove();
  		$("#telefono").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
  		$("#telefono").parent().append('<span id="iconoFeed9" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
  		$("#telefono").parent().children("span.help-block").text("").hide();

  		return true;
  	}
  }

  function validarDireccion(){

  	var direccion = $('#direccion').val();

	if (direccion==null || direccion.length ==0 || /^\s+$/.test(direccion)) {//correo vacio
		$("#iconoFeed0").remove();
		$("#direccion").parent().attr("class", "col-sm-7 backnone has-error has-feedback cambioPass")
		$("#direccion").parent().append('<span id="iconoFeed0" class="glyphicon glyphicon-remove form-control-feedback cambioPass"></span>');
		$("#direccion").parent().children("span.help-block").text("Debes Ingresar una dirección").show();
		return false;

	}else {//formato correcto
		$("#iconoFeed0").remove();
		$("#direccion").parent().attr("class", "col-sm-7 backnone has-success has-feedback cambioPass")
		$("#direccion").parent().append('<span id="iconoFeed0" class="glyphicon glyphicon-ok form-control-feedback cambioPass"></span>');
		$("#direccion").parent().children("span.help-block").text("").hide();

		return true;
	}
}

function validarGuardar(){

	if (validarNombre()==true  && validarApellido()==true && validarId()==true && validarCargo()==true  && validarCorreo()==true && validarClaveInic()==true && validarClaveConf()==true && validarDireccion()==true && validarTelefono()==true) {

		
		swal({
			title: "¿Estas seguro?",
			text: "Si deseas permanecer en esta página, presiona 'Cancelar'",
			type: "info",
			showCancelButton: true,
			confirmButtonColor: "#53BCDC",
			confirmButtonText: "Cancelar",
			cancelButtonText: "Crear Usuario",
			closeOnConfirm: true,
			closeOnCancel: false
		},
		function(isConfirm){
			if (isConfirm==false) {

				swal({
					title: "Usuario Creado",
					text: "El usuario fue creado correctamente",
					imageUrl: "img/validado.png",

					confirmButtonColor: "#2A6598",
					confirmButtonText: "OK",
					closeOnConfirm: true
				},
				function(){
					window.location.href = 'sesionIniciada.html';
				});

			} 
		}

		);

	}else{
		return false;
	}
}


$().ready(function(){
	$(".identifica").click(function(){
		swal("Formato de Identificacion", "CC: Entre 8 y 12 numeros (ej: 123456)\nNIT: 9 numeros, un guion (-) y otro número\nCE:");
	})
})



$().ready(function(){
	$("#finalizar").click(function(){
		swal({
			title: "Estas seguro?",
			text: "Si deseas permanecer en esta página, presiona 'Cancelar'",
			type: "info",
			showCancelButton: true,
			confirmButtonColor: "#53BCDC",
			confirmButtonText: "Finalizar",
			cancelButtonText: "Cancelar",
			closeOnConfirm: true,
			closeOnCancel: true
		},
		function(isConfirm){
			if (isConfirm) {
				window.location.href = 'sesionIniciada.html';
			} else {
			}
		});
	})
})
