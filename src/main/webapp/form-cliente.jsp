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
<form method="post" action="servletCliente">
	<div class="container mb-5">
		<div class="form-group row pt-2">
			<label for="nome" class="col-4 col-form-label d-none d-sm-block">Nome</label> 
			<div class="col-12 col-sm-8">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-address-book-o"></i>
						</div>
					</div> 
					<input id="nome" name="nome" type="text" class="form-control" required="required" placeholder="Nome Completo">
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="telefone" class="col-4 col-form-label d-none d-sm-block">Telefone</label> 
			<div class="col-12 col-sm-8">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-whatsapp"></i>
						</div>
					</div> 
					<input id="telefone" name="telefone" type="text" class="form-control" required="required" placeholder="(61) 9 9999-9999">
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="cidade" class="col-4 col-form-label d-none d-sm-block">Cidade</label> 
			<div class="col-12 col-sm-8">
				<select id="cidade" name="cidade" class="custom-select" required="required">
					<option value="" disabled selected>Cidade</option>
					<option value="Águas Claras">    Águas Claras</option>
					<option value="Asa Norte">       Asa Norte</option>
					<option value="Asa Sul">         Asa Sul</option>
					<option value="Cruzeiro">        Cruzeiro</option>
					<option value="Guará">           Guará</option>
					<option value="Jardim Botânico"> Jardim Botânico</option>
					<option value="Lago norte">      Lago norte</option>
					<option value="Lago sul">        Lago sul</option>
					<option value="Noroeste">        Noroeste</option>
					<option value="Octogononal">     Octogononal</option>
					<option value="Park Sul">        Park Sul</option>
					<option value="Sudoeste">        Sudoeste</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
				<label for="endereco" class="col-4 col-form-label d-none d-sm-block">Endereço</label> 
				<div class="col-12 col-sm-8">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-map-marker"></i>
							</div>
						</div> 
						<input id="endereco" name="endereco" type="text" class="form-control" required="required" placeholder="Rua, Avenida, Número...">
					</div>
				</div>
			</div>
	</div>
	<button id="bt-continuar" name="submit" type="submit" class="btn btn-success confirmar" onclick="">
		Continuar 
	</button>
</form>

</body>
</html>