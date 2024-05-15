<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<title>Solicitar Reparación</title>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css"
	rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<bodystyle="background: rgb(209, 214, 214); background: linear-gradient(0deg, rgba(209, 214, 214, 1) 7%, rgba(255, 255, 255, 1) 49%);">
	
	<%@ include file="../partes/navbar.jsp" %>
	
	<div class="container mt-5">
        <div class="card shadow-sm p-4">
            <h3 class="mb-4">Formulario de Solicitud de Reparación</h3>
            
            <form action ="StoreReparacionMainPage" method="POST">
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo:</label>
                    <input type="text" class="form-control" id="tipo" name="tipo" value="${reparacion.tipo}" required>
                </div>
                            
                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción:</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" rows="3">${reparacion.descripcion}</textarea>
                </div>
            
                <div class="mb-3 row">
                    <div class="col">
                        <label for="horas" class="form-label">Horas:</label>
                        <input type="text" class="form-control" id="horas" name="horas" value="${reparacion.horas}">
                    </div>
                    <div class="col">
                        <label for="precio" class="form-label">Precio:</label>
                        <div class="input-group">
                            <span class="input-group-text">&euro;</span>
                            <input type="text" class="form-control" id="precio" name="precio" value="${reparacion.precio}">
                        </div>
                    </div>
                </div>
                                                
                <div class="mb-3">
                    <label for="dni" class="form-label">DNI:</label>
                    <input type="text" class="form-control" id="dni" name="dni" value="${reparacion.cliente.dni}">
                </div>

                <button type="submit" class="btn btn-success">Enviar</button>
            </form>
        </div>
         <a href="javascript:history.back()" class="btn btn-success text-decoration-none mt-4">
	     	<i class="bi bi-arrow-left-circle text-white"></i>
	  	 </a>
    </div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
</body>
</html>