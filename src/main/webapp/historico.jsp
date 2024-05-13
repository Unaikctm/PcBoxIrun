<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Producto más vendido del mes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <body>
    
    <%@ include file="/partes/navbar.jsp" %>
    <%@ include file="/partes/sidebar.jsp"%>
    
    <div class="container fluid">
    	<div class="row">
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
                                            <td>${historico.producto.nombre}</td>
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

    <!-- Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
