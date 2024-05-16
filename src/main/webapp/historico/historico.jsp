<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Producto más vendido del mes</title>
<link rel="stylesheet" href="css/sidebar.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">

<style>
    .accordion-button {
        background-color: #d4edda; /* Verde claro para el botón del acordeón */
        color: #155724; /* Color del texto en el botón */
    }
    .accordion-button:not(.collapsed) {
        background-color: #c3e6cb; /* Verde claro cuando el acordeón está abierto */
        color: #155724;
    }
    .accordion-button:focus {
    	box-shadow: 0 0 0 0.25rem rgba(40, 167, 69, 0.5); /* Sombra verde claro */
	}
    .accordion-item {
        border: 1px solid #c3e6cb; /* Borde verde claro */
    }
    .accordion-body {
        background-color: #f8f9fa; /* Fondo claro para el cuerpo del acordeón */
        color: #155724; /* Color del texto en el cuerpo */
    }
    table thead {
        background-color: #e9f5e9; /* Fondo verde claro para la cabecera de la tabla */
        color: #155724; /* Color del texto en la cabecera de la tabla */
    }
    table tbody tr {
        background-color: #ffffff; /* Fondo blanco para las filas de la tabla */
        color: #155724; /* Color del texto en las filas de la tabla */
    }
    table tbody tr:hover {
        background-color: #e9f5e9; /* Fondo verde claro al pasar el ratón sobre una fila */
    }
</style>

</head>
<body>
    
    
    <%@ include file="/partes/navbar.jsp" %>
    
    <div class="container-fluid">
        <div class="row">
            <%@ include file="/partes/sidebar.jsp"%>
            
            <div class="col-md-11 mt-4">
            	<h1 class="mb-3">Producto más vendido del mes</h1>
	            <div class="accordion" id="accordionExample">
	                <c:forEach items="${historicos}" var="historico">
	                    <div class="accordion-item">
	                        <h2 class="accordion-header">
	                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${historico.mes}" aria-expanded="true" aria-controls="collapse${historico.mes}">
	                              ${historico.mes}
	                            </button>
                        	</h2>
	                        <div id="collapse${historico.mes}" class="accordion-collapse collapse" aria-labelledby="heading${historico.mes}" data-bs-parent="#accordionExample">
	                            <div class="accordion-body">
	                                <table class="table">
	                                    <thead>
	                                        <tr>
	                                            <th>Marca</th>
	                                            <th>Producto</th>
	                                            <th>Cantidad</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <tr>
	                                            <td>${historico.producto.marca}</td>
	                                            <td>
	                                            	<a href="Show_producto?id=${historico.producto.id}">${historico.producto.nombre}</a>
	                                            </td>
	                                            <td>${historico.cantidad}</td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
	            </div>
	        </div>
	    </div>        
	</div>


    <!-- Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
