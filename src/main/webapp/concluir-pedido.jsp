<%@page import="modelo.ListaProduto"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.Pedido"%>
<%@page import="java.text.DecimalFormat"%>


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
	<div class="salada">
		<h2 class="p-4 mb-3 text-white text-center">Cardápio</h2>
	</div>
	<div class="container mb-4">
		<%

			DecimalFormat df = new DecimalFormat("#,###.00");
			HttpSession sessao = request.getSession();
			Cliente cliente = (Cliente) sessao.getAttribute("objCliente");
			out.println("Cliente: "+cliente.getNome());
			ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		%>


	<br/>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Produto</th>
					<th>Quantidade</th>
					<th>Subtotal</th>
				<tr>
			</thead>
			<%
				Pedido pedido = new Pedido();
				for (ListaProduto item : lsProduto){
					out.println("<tr>");
					out.println("<td>"+item.getProduto().getNome()+"</td>");
					out.println("<td>"+item.getQuantidade()+"</td>");
					out.println("<td> R$ "+df.format(item.getTotal())+"</td>");
					out.println("</tr>");
					pedido.setTotalPedido(pedido.getTotalPedido()+item.getTotal());
				}
				out.println("<tr class=\"bg-info text-white\">");
				out.println("<td colspan='2'>Total do pedido</td>");
				out.println("<td class=\"font-weight-bold\"> R$ "+df.format(pedido.getTotalPedido())+"</td>");
				out.println("</tr>");	
				
				sessao.setAttribute("objPedido", pedido);
			%>
		</table>
		Dados de entrega:
		<%
			out.println("<br/> Endereco: "+cliente.getEndereco()+"<br/><br/><br/><br/><br/>");
		%>
	</div>
	<form action="ServletPedido" method="post">
		<button id="bt-concluir-ped" name="submit" type="submit" class="btn btn-success confirmar" onclick="">
			Confirmar 
		</button>
	</form>
</body>
</html>