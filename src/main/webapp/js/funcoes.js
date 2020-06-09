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
	console.log(obj);
	vlTotal();
}

function vlTotal(){
	vlFinal = 0;
	for(i in lsItens){
		obj = lsItens[i];
		vlFinal += obj.total;
	}
	document.getElementById('vl-span').innerHTML = "R$"+vlFinal.toFixed(2);
	if(vlFinal>0){
		document.getElementById('bt-confirmar').removeAttribute("disabled");
	}else{
		document.getElementById('bt-confirmar').setAttribute("disabled","disabled");
	}
}