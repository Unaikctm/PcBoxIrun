<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body>
	
	<%@ include file="/partes/navbar.jsp" %>
		
	<div class="container">
    	<h1 class="mt-5 mb-4">Datos del Cliente:</h1>
	  	<div class="table-responsive">
		    <table class="table table-bordered ">
		      <thead class="thead-dark">
		      	<tr>
			          <th scope="row">DNI</th>
			          <td>${cliente.dni}</td>
		        </tr>
		        <tr>
			          <th scope="row">Nombre</th>
			          <td>${cliente.nombre}</td>
		        </tr>
		        <tr>
			          <th scope="row">Apellidos</th>
			          <td>${cliente.apellido}</td>
		        </tr>
		        <tr>
			          <th scope="row">Direccion</th>
			          <td>${cliente.direccion}</td>
		        </tr>
		        <tr>
			          <th scope="row">Codigo postal</th>
			          <td>${cliente.codigopostal}</td>
		        </tr>
		        <tr>
			          <th scope="row">Email</th>
			          <td>${cliente.email}</td>
		        </tr>
		        <tr>
			          <th scope="row">Telefono</th>
			          <td>${cliente.telefono}</td>
		        </tr>
		    </table>
		 </div>
		 <a href="javascript:history.back()" class="btn btn-success text-decoration-none">
	    		<i class="bi bi-arrow-left-circle text-white"></i>
	  	 </a>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>