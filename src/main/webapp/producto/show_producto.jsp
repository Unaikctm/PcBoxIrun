<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body>
	
	<%@ include file="/partes/navbar.jsp" %>
	
    <div class="container">
	    <a href="javascript:history.back()" class="btn btn-success text-decoration-none mt-4">
	    		<i class="bi bi-arrow-left-circle text-white"></i>
	  	</a>
		<h1 class="mt-5 mb-4">Lista de Productos</h1>
	  	<div class="table-responsive">
		    <table class="table table-bordered ">
		      <thead class="thead-dark">
		         <tr>
		          <th scope="row">ID</th>
		          <td>${producto.id}</td>
		        </tr>
		        <tr>
		          <th scope="row">Nombre</th>
		          <td>${producto.nombre}</td>
		        </tr>
		        <tr>
		          <th scope="row">Tipo</th>
		          <td>${producto.tipo}</td>
		        </tr>
		        <tr>
		          <th scope="row">Marca</th>
		          <td>${producto.marca}</td>
		        </tr>
		        <tr>
		          <th scope="row">Precio</th>
		          <td>${producto.precio}</td>
		        </tr>
		        <tr>
		          <th scope="row">Stock</th>
		          <td>${producto.stock}</td>
		        </tr>
		
		      </tbody>
		    </table>
  		</div>
	</div>
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>