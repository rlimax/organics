var lsItens = [];

function atualizar(id, vl){
	var quantidade = document.getElementById(id).value;
	var id = id.replace("prd-","");
	var total = vl*quantidade;
	var obj = {	"id":id,
			"quantidade":quantidade,
			"valor":vl,
			"total":total
	}
	if(quantidade>0){
		lsItens[id] = obj;		
	}else if(lsItens[id].id == id){
		lsItens[id] = null;
	}
	//console.log(lsItens);
	vlTotal();
}

function vlTotal(){
	vlFinal = 0;
	for(i in lsItens){
		if(lsItens[i]!=null){
			obj = lsItens[i];
			vlFinal += obj.total;
		}
	}
	document.getElementById('vl-span').innerHTML = "R$"+String(vlFinal.toFixed(2)).replace(".",",");
	if(vlFinal>0){
		document.getElementById('bt-confirmar').removeAttribute("disabled");
	}else{
		document.getElementById('bt-confirmar').setAttribute("disabled","disabled");
	}

}

function enviar(){
	var xmlhttp = new XMLHttpRequest();

	xmlhttp.overrideMimeType("text/html");
	xmlhttp.onreadystatechange = function(){
		if((this.readyState== 4)&&(this.status==200)){
			location.replace(this.responseText);
		}
	}
	
	var url = "listaItem";
	xmlhttp.open("POST",url);
	xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xmlhttp.send(JSON.stringify(lsItens));
	//console.log(xmlhttp);
}

function selecao(){
	i = document.querySelectorAll(".cc");
	//console.log(i);
	for(x=0; x<i.length; x++){
		//console.log(i[x].id);
		if(document.getElementById(i[x].id).value>0){
			document.getElementById(i[x].id.replace("prd","lin")).style.backgroundColor="rgba(0,255,0,.1)";
		}else{
			document.getElementById(i[x].id.replace("prd","lin")).style.backgroundColor="white";
		}
		//console.log(lsItens[x]);
	}
}