<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factura del Pedido</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
    
    <%@ include file="partes/navbar.jsp" %>
    
    <div class="container">
        <h1>Factura del Pedido #${pedido.id}</h1>
        <div class="card mb-3">
            <div class="card-header">
                <h2>Información del Pedido:</h2>
            </div>
            <div class="card-body">
                <p class="card-text">Fecha del Pedido: ${pedido.fecha}</p>
                <p class="card-text">Total del Pedido: ${pedido.total}</p>
            </div>
        </div>
        <div class="card mb-3">
            <div class="card-header">
                <h2>Información de la Factura:</h2>
            </div>
            <div class="card-body">
                <p class="card-text">ID de la Factura: ${factura.id}</p>
                <p class="card-text">Tipo de Factura: ${factura.tipo}</p>
                <p class="card-text">Fecha de Emisión: ${factura.fecha}</p>
                <p class="card-text">Total de la Factura + IVA includo: ${factura.total}</p>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and other scripts here -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>