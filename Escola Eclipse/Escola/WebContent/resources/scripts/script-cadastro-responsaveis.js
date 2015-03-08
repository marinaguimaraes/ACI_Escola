$(document).ready(function () {
    $(".telefone").on('input propertychange paste', function () {
        mask(this, "(99)99999-9999");
    });
    $(".telefone").on('focus', function () {
        mask(this, "(99)9999-9999");
    });
});

String.prototype.replaceAll = function(str1, str2, ignore) 
{
	return this.replace(new RegExp(str1.replace(/([\/\,\!\\\^\$\{\}\[\]\(\)\.\*\+\?\|\<\>\-\&])/g,"\\$&"),(ignore?"gi":"g")),(typeof(str2)=="string")?str2.replace(/\$/g,"$$$$"):str2);
}

function validaResponsavel(formulario) { 
	var email = formulario.emailResp.value;
	var nome = formulario.nomeResp.value; 
	var telefone = formulario.telefoneResp.value; 
	var endereco = formulario.enderecoResp.value; 

	
	if (nome == "" || telefone == "" || endereco == "") {
		alert('Preencha todos os campos'); 
		return false; 
	}
   
	/*valida nome*/
    var re = /^[A-Za-z]+$/;
    if (!re.test(nome)) {
       alert('Nome inválido'); 
	   return false;
	}

	/*valida email*/
	if (!validacaoEmail(email)) {
		alert('E-mail inválido'); 
		return false;
	}
	alert('validou email');
	
	/*valida telefone*/
	

    telefone = telefone.replaceAll("(","");
    telefone =  telefone.replaceAll(")","");
    telefone = telefone.replaceAll("-","");
    
    alert(telefone.length);
    
	if (isNaN(parseFloat(telefone))) {
       alert('Telefone inválido'); 
	   return false;
	}
	
	if(telefone.length < 10){
		alert('Telefone inválido'); 
		return false;
	}
	
	alert('validou telefone');
	
	return true;
	
}

function validacaoEmail(email) { 
	usuario = email.substring(0, email.indexOf("@")); 
	dominio = email.substring(email.indexOf("@")+ 1, email.length); 
	if ((usuario.length >=1) && 
		  (dominio.length >=3) && 
		  (usuario.search("@")==-1) && 
		  (dominio.search("@")==-1) && 
		  (usuario.search(" ")==-1) && 
		  (dominio.search(" ")==-1) && 
		  (dominio.search(".")!=-1) && 
		  (dominio.indexOf(".") >=1) && 
		  (dominio.lastIndexOf(".") < dominio.length - 1)) {  
		return true;
	} 

	return false;
}
