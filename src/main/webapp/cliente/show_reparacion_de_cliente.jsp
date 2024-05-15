<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show reparaciones de un cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body>
	
	<%@ include file="/partes/navbar.jsp" %>
	
    <div class="container">
	    <a href="javascript:history.back()" class="btn btn-success text-decoration-none mt-4">
	    	<i class="bi bi-arrow-left-circle text-white"></i>
	  	</a>
	    <h1 style="margin-top: 3%; margin-bottom: 3%;">Reparaciones de ${cliente.nombre} ${cliente.apellido}</h1>
	    <c:forEach var="reparacion" items="${reparaciones}">
	        <div class="card mb-3">
	            <div class="card-header d-flex justify-content-between">
	                <h2>Reparación ID: ${reparacion.id}</h2>
	                <!-- Eliminar -->
	                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmacionModal${reparacion.id}">
	                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
	                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
	                        <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
	                    </svg>
	                </button>
	            </div>
	            <div class="card-body">
	                <p class="card-text">Tipo: ${reparacion.tipo}</p>
	                <p class="card-text">Descripción: ${reparacion.descripcion}</p>
	                <p class="card-text">Horas: ${reparacion.horas}</p>
	                <p class="card-text">Precio: ${reparacion.precio}</p>
	            </div>
	            <div class="modal fade" id="confirmacionModal${reparacion.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <h5 class="modal-title" id="exampleModalLabel">Eliminar Reparación</h5>
	                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	                        </div>
	                        <div class="modal-body">¿Estás seguro de que quieres eliminar esta reparación?</div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	                            <a href="Destroy_reparacion?id=${reparacion.id}" class="btn btn-danger">Eliminar</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
	</div>

    <!-- Bootstrap JS and other scripts here -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>