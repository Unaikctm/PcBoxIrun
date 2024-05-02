<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>PcBox</title>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css"
	rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body style="background: rgb(209, 214, 214); background: linear-gradient(0deg, rgba(209, 214, 214, 1) 7%, rgba(255, 255, 255, 1) 49%);">
	
	<nav class="navbar navbar-expand-lg navbar-light bg-success py-2">
		<div class="container-fluid d-flex justify-content-center">
			<!-- Logo -->
			<a class="navbar-brand bg-light" href="#"> <img src="img/main_page/pcboxlogo.png" alt="Logo" height="90px"></a>
			
			<!-- Botón para colapsar en dispositivos pequeños -->
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>
	
	<div class="container-fluid mt-4">
		<div class="row">
			<c:forEach items="${productos}" var="producto">
				<div class="col-md-2">
					<div class="card mb-4 shadow-lg" style="height:95%;">
						<img src="img/img_producto/${producto.nombre.replaceAll(" ","_")}.png" class="card-img-top" alt="clientes"> 
						<hr>
						<div class="card-body">
							<h5 class="card-title text-center">${producto.nombre}</h5>
						</div>
						<div class="mb-4">
							<p class="card-text text-center fs-5">${producto.tipo}</p>
						</div>
						<div class="mb-4 d-flex justify-content-evenly align-items ">
						
							<form>
								<div class="form-group">
						            <input type="number" class="form-control" id="cantidad" name="cantidad" min="1" max="10" value="1">
        						</div>
	        				</form>
	        				
							<a href="" class="btn btn-primary px-4 fs-5 bg-success">
								<i class="bi bi-cart4"></i>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
</body>
</html>
