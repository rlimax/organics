lsItens = [];
//Atualizar valor botão
function atualizar(id, vl){
	quantidade = document.getElementById(id).value;
	id = id.replace("prd-","");
	total = vl*quantidade;
	obj = {	"id":id,
			"quantidade":quantidade,
			"valor":vl,
			"total":total
	}
	lsItens[id] = obj;
	//console.log(obj);
	vlTotal();
}

function vlTotal(){
	vlFinal = 0;
	for(i in lsItens){
		obj = lsItens[i];
		vlFinal += obj.total;
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
	var url = "listaItem";
	xmlhttp.open("POST",url);
	xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xmlhttp.send(JSON.stringify(lsItens));
}








