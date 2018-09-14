var url = "http://localhost:8080/address"
var xhr = new XMLHttpRequest();
function cadastrar(){
	var json = createJson();
	if(validateField(json) === true){
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.onreadystatechange = function () {
		    if (xhr.readyState === 4 && xhr.status === 200) {
		        var response = JSON.parse(xhr.responseText);
		        alert("Cadastrado com Sucesso!");
		        limpar();
		    }
		};
		xhr.send(JSON.stringify(json));
	}	
}

function validateField(json){
	var isInt = /^[0-9]+$/;
	var alerta = "Existe(m) campo(s) obrigatório(s) a ser(em) preenchido(s)";
	if(json["rua"] === ""){
		alert(alerta);
		return false;
	}else if(json["rua"] === ""){
		alert(alerta);
		return false;
	}else if(json["numero"] == ""){
		alert(alerta);
		return false;
	}else if(json["cep"] == ""){
	    alert(alerta);
	    return false;
	}else if(json["cidade"] == ""){
		alert(alerta);
		return false;
	}else if(json["estado"] == ""){
		alert(alerta);
		return false;
	}else if(json["rua"] == ""){
		alert(alerta);
		return false;
	}else if(!json["numero"].match(isInt)){
		alert("Campo número deve ser um inteiro");
		return false;
	}else{
		return true;
	}
}

function consultar(){
	var response = "";
	
	xhr.open("GET", url+id(), true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        if (xhr.responseText===""){
	        	alert("Cadastro Inexistente!!!!");
	        	limpar();
	        }else{
	        	response = JSON.parse(xhr.responseText);
	        	setElementsText(response);
	        }
	    }
	};
	xhr.send('');
}

function createJson(){
	var rua = document.getElementById('rua').value;
	var numero = document.getElementById('numero').value;
	var cep = document.getElementById('cep').value;
	var cidade = document.getElementById('cidade').value;
	var estado = document.getElementById('estado').value;
	var bairro = document.getElementById('bairro').value;
	var complemento = document.getElementById('complemento').value;
	var jsonAddress = {
		"rua": rua,
		"numero": numero,
		"cep": cep,
		"cidade": cidade,
		"estado": estado,
		"bairro": bairro,
		"complemento": complemento
	};
	return jsonAddress
}

function setElementsText(response){
	document.getElementById('rua').value = response.rua;
	var numero = document.getElementById('numero').value = response.numero;
	var cep = document.getElementById('cep').value = response.cep;
	var cidade = document.getElementById('cidade').value = response.cidade;
	var estado = document.getElementById('estado').value = response.estado;
	var bairro = document.getElementById('bairro').value = response.bairro;
	var complemento = document.getElementById('complemento').value = response.complemento;
}

function limpar(){
	document.getElementById('id').value = "";
	document.getElementById('rua').value = "";
	document.getElementById('numero').value = "";
	document.getElementById('cep').value = "";
	document.getElementById('cidade').value = "";
	document.getElementById('estado').value = "";
	document.getElementById('bairro').value = "";
	document.getElementById('complemento').value = "";
}

function alterar(){
	var json = createJson();
	json["id"] = document.getElementById('id').value;
	var response = ""
	xhr.open("PUT", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        alert("Cadastro Alterado com Sucesso!");
	        limpar();
	    }
	};
	xhr.send(JSON.stringify(json));
}

function excluir(){
	xhr.open("DELETE", url+id(), true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
		console.log(xhr.status)
	    if (xhr.readyState === 4 && xhr.status === 200) {
	    	var response = JSON.parse(xhr.responseText);
	    	alert("Cadastro Excluido com Sucesso!");
	    	limpar();
	    }
	};
	xhr.send();
}

function id(){
	return "/"+document.getElementById('id').value;
}