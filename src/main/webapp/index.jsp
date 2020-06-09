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
 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./css/estilo.css">

</head>
<body>
<h2 class="bg-success p-4 text-white text-center">Cardápio</h2>
<div class="container">
<form>
	<div class="form-group row">
		<label for="prd-1" class="col-6 col-form-label text-right">Alface crespa - pé</label>
		<div class="col-6">
			<div class="input-group">
				<div class="input-group-append" onclick="this.parentNode.querySelector('input[type=number]').stepDown();">
					<div class="input-group-text">
						<i class="fa fa-angle-down"></i>
					</div>
				</div>
				<input id="prd-1" name="prd-1" type="number" class="form-control text-center" min="0" value="0">
				<div class="input-group-prepend" onclick="this.parentNode.querySelector('input[type=number]').stepUp();">
					<div class="input-group-text">
						<i class="fa fa-angle-up"></i>
					</div>
				</div> 
			</div>
		</div>
	</div>
	<div class="row border-bottom pb-2">
		<div class="col-6 valor text-right">
			R$ 15,00
		</div>
		<div class="col-6 valor">
		</div>
	</div> 
</form>
</div>
<button name="submit" type="submit" class="btn btn-success confirmar">Confirmar R$ 0.00</button>
</body>
</html>