<%@page import="modelo.ListaProduto"%>
<%@page import="modelo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Feira de Orgânicos</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script src="./js/funcoes.js"></script>
 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./css/estilo.css">

</head>
<body>
	<h2 class="bg-success p-4 mb-3 text-white text-center">Cardápio</h2>
	<div class="container">
	<%
		HttpSession sessao = request.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("ObjCliente");
		
		out.println("<br/>Nome: "+cliente.getNome());
		out.println("<br/>Telefone "+cliente.getTelefone());
		out.println("<br/>Endereço "+cliente.getEndereco());
		out.println("<br/>-------------------------------------------------");
		out.println("<br/>Lista de Produtos.");
		
		ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		
		for (ListaProduto item : lsProduto){
			out.println("<br/>"+item.getProduto().getNome()+" Quantidade: "+item.getQuantidade()+" Subtotal: R$"+item.getTotal());
		}
		
		
		
	%>
	</div>
</body>
</html>