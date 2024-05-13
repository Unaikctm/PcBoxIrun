<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
	
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css"
		rel="stylesheet">
	
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.cdnfonts.com/css/feast-of-flesh-bb" rel="stylesheet">
</head>

<body>

	<%@ include file="/partes/navbar.jsp"%>

	<c:if test="${param.msg == 'failRegistro'}">
	    <div class="alert alert-danger alert-dismissible fade show" role="alert">
	        <strong>Error:</strong> Fallo al registrar, revisa que el telefono y codigo postal no contengan caracteres.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg == 'failRegistroDNI'}">
	    <div class="alert alert-danger alert-dismissible fade show" role="alert">
	        <strong>Error:</strong> Fallo al registrar, el dni introducido ya se encuentra registrado.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>

    <div class="container-fluid-izq">
        <div class="row">
            <!-- Columna con botÃ³n -->
            <div class="col-12 col-md-6">
                <div class="text-center u_catch">¡Descubre las mejores ofertas en PCs ahora mismo!</div>
                <div class="text-center">
                    <button type="button" class="btn-lg u_btn-contrast u_btn-rounded" data-bs-toggle="modal" data-bs-target="#insertModal">¡Explora las ofertas!</button>
                    	<!-- Modal de registro -->
               		<div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header bg-success text-white">
								<h5 class="modal-title" id="exampleModalLabel">¡Registrate para verlas!</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>

							<form action="Store_cliente_landing" method="POST">

								<div class="modal-body text-start">

									<div class="mb-3">
										<label for="nombre" class="form-label">Nombre:</label> 
										<input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}" required>
									</div>

									<div class="mb-3">
										<label for="apellido" class="form-label">Apellido:</label>
										<input type="text" class="form-control" id="apellido" name="apellido" value="${cliente.apellido}" required>
									</div>

									<div class="mb-3">
										<label for="dni" class="form-label">DNI:</label> 
										<input type="text" class="form-control" id="dni" name="dni" value="${cliente.dni}">
									</div>

									<div class="mb-3">
										<label for="direccion" class="form-label">Direccion:</label>
										<input type="text" class="form-control" id="direccion" name="direccion" value="${cliente.direccion}">
									</div>

									<div class="mb-3">
										<label for="codigopostal" class="form-label">Codigo postal:</label>
										<input type="text" class="form-control" id="codigopostal" name="codigopostal" value="${cliente.codigopostal}">
									</div>

									<div class="mb-3">
										<label for="email" class="form-label">Email:</label> 
										<input type="email" class="form-control" id="email" name="email" value="${cliente.email}">
									</div>

									<div class="mb-3">
										<label for="telefono" class="form-label">Telefono:</label>
										<input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
									<button type="submit" class="btn btn-success">Guardar Cambios</button>
								</div>
										</form>
									</div>
								</div>
							</div>
                </div>
               
               	
            </div>
            <!-- Columna con slider de imÃ¡genes -->
            <div class="col-12 col-md-6">
                <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="img/slide1.png" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="img/slide2.png" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="img/slide3.png" alt="Third slide">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/partes/footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

</html>
