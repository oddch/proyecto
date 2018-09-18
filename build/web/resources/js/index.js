

$(document).on("ready",inicio);

function inicio(){
	$("span.help-block").hide();
	$("#infoFormat").hide();
	$("#btnIngresar").click(validarForm);		
	$("#email").keyup(validarCorreo);
	$("#clave").keyup(validarClave);
}

function validarCorreo(){
	format = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/  || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+(([a-zA-Z0-9]{2,4})+\.)+([a-zA-Z]{2,4})+$/;
	var correo = $('#email').val();
	
	if (correo==null || correo.length ==0 || /^\s+$/.test(correo)) {//correo vacio
		$("#iconoFeed1").remove();
		$("#email").parent().parent().attr("class", "form-group has-error has-feedback")
		$("#email").parent().append('<span id="iconoFeed1" class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$("#email").parent().parent().children("span").text("Debes Ingresar un Correo").show();
		return false;
kkk
	}else if( !format.test(correo)) {//formato correo invalido
		$("#iconoFeed1").remove();
		$("#email").parent().parent().attr("class", "form-group has-error has-feedback")
		$("#email").parent().append('<span id="iconoFeed1" class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$("#email").parent().parent().children("span").text("Formato de correo no valido").show();
		return false;	

  	}else{//formato Correcto
  		$("#iconoFeed1").remove();
  		$("#email").parent().parent().attr("class", "form-group has-success has-feedback")
  		$("#email").parent().append('<span id="iconoFeed1" class="glyphicon glyphicon-ok form-control-feedback"></span>');
  		$("#email").parent().parent().children("span").text("").hide();
  		return true;
  	}
  }

  function validarClave(){

  	formatC = /^\d{7,15}$/;
  	var clave = $('#clave').val();

	if (clave==null || clave.length ==0) {//correo vacio
		$("#iconoFeed2").remove();
		$("#clave").parent().parent().attr("class", "form-group has-error has-feedback")
		$("#clave").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$("#clave").parent().parent().children("span").text("Debes Ingresar una contraseña").show();
		$("#clave").parent().parent().children("a").text("").show();
		return false;

	}else if (/^\s+$/.test(clave) || clave.length<8 || clave.length>15){
		$("#iconoFeed2").remove();
		$("#clave").parent().parent().attr("class", "form-group has-error has-feedback")
		$("#clave").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$("#clave").parent().parent().children("span").text("Formato invalido de contraseña").show();
		$("#clave").parent().parent().children("a").text("").show();
		return false;
		
	}else{//formato Correcto
		$("#iconoFeed2").remove();
		$("#clave").parent().parent().attr("class", "form-group has-success has-feedback")
		$("#clave").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-ok form-control-feedback"></span>');
		$("#clave").parent().parent().children("span").text("").hide();
		$("#clave").parent().parent().children("a").text("").hide();
		return true;
	}

}

function validarForm(){

	var correo = $('#email').val();
	var clave = $('#clave').val();

	if (validarCorreo()==true && validarClave()==true) {
		if (correo=="jmguerrero26@misena.edu.co" || correo=="JMGUERRERO26@MISENA.EDU.CO" && clave=="123456789" ) {
			window.location.href = 'sesionIniciada.html';
		}if (correo=="jbetancourt@misena.edu.co" || correo=="JBETANCOURT@MISENA.EDU.CO" && clave=="pitalito123" ) {
			window.location.href = '../tecnico/sesionIniciada.html';
		}else if (correo!="sespinosa26@misena.edu.co" || correo!="SESPINOSA26@MISENA.EDU.CO" && clave=="7894561230") {
			window.location.href='../Cliente/sesionIniciada.html';
			$("#iconoFeed1").remove();
			$("#email").parent().parent().attr("class", "form-group has-error has-feedback")
			$("#email").parent().append('<span id="iconoFeed1" class="glyphicon glyphicon-remove form-control-feedback"></span>');
			$("#email").parent().parent().children("span").text("El correo no esta registrado").show();
			return false;


		
			
		}else if (clave!="123456789" || clave!="pitalito123" || clave!="7894561230") {
			$("#iconoFeed2").remove();
			$("#clave").parent().parent().attr("class", "form-group has-error has-feedback")
			$("#clave").parent().append('<span id="iconoFeed2" class="glyphicon glyphicon-remove form-control-feedback"></span>');
			$("#clave").parent().parent().children("span").text("La contraseña es incorrecta").show();
			return false;
			
		}
	}
}







  $().ready(function(){
  	$("#infoFormat").click(function(){
  		swal("Formato de la contraseña", "La contraseña debe tener mínimo 8 y maximo 15 caracteres");
   	})
  })