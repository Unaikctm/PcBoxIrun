<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" style="zoom: 75%;">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PcBox</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background: rgb(209, 214, 214); background: linear-gradient(0deg, rgba(209, 214, 214, 1) 7%, rgba(255, 255, 255, 1) 49%);";>
    <nav class="navbar navbar-expand-lg navbar-light bg-success py-2">
        <div class="container-fluid d-flex justify-content-center">
            <!-- Logo -->
            <a class="navbar-brand bg-light" href="#">
                <img src="img/main_page/pcboxlogo.png" alt="Logo" height="90px">
            </a>
    
            <!-- Botón para colapsar en dispositivos pequeños -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>
    
    <div class="container mt-4">
        <div class="row d-flex justify-content-center">
            <div class="col-md-4" >
                <div class="card mb-4 shadow-lg">
                    <img src="img/main_page/cliente.png" height="320px" class="card-img-top" alt="clientes">
                    <br><hr>
                    <div class="card-body">
                        <h5 class="card-title text-center">Panel de Clientes</h5>
                        <p class="card-text text-center"> Aquí, puedes gestionar la información de tus clientes, así como editar, añadir o eliminar clientes.</p>
                        <a href="Index_cliente" class="btn btn-primary px-5 fs-5 d-flex justify-content-center bg-success">Ir al Panel</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 shadow-lg">
                    <img src="img/main_page/producto.png" height="320px" class="card-img-top" alt="productos">
                    <br><hr>
                    <div class="card-body">
                        <h5 class="card-title text-center">Panel de Productos</h5>
                        <p class="card-text text-center">Aquí, puedes administrar tu catálogo de productos. Agrega nuevos productos y actualiza información.</p>
                        <a href="Index_producto" class="btn btn-primary px-5 fs-5 d-flex justify-content-center bg-success">Ir al Panel</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 shadow-lg">
                    <img src="img/main_page/pedido.png" height="320px" class="card-img-top" alt="pedidos">
                    <br><hr>
                    <div class="card-body">
                        <h5 class="card-title text-center">Panel de Pedidos</h5>
                        <p class="card-text text-center">Aquí puedes gestionar todos los pedidos. Desde este panel se podrán controlar los pedidos </p>
                        <a href="Index_pedido" class="btn btn-primary px-5 fs-5 d-flex justify-content-center bg-success">Ir al Panel</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 shadow-lg">
                    <img src="img/main_page/reparacion.png" height="320px" class="card-img-top" alt="reparacion">
                    <br><hr>
                    <div class="card-body">
                        <h5 class="card-title text-center">Panel de Reparación</h5>
                        <p class="card-text text-center">En este panel se pueden consultar todas las reparaciones, así como gestionarlas.</p>
                        <a href="Index_reparacion" class="btn btn-primary px-5 fs-5 d-flex justify-content-center bg-success">Ir al Panel</a>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card mb-4 shadow-lg">
                    <img src="img/main_page/trofeo.png" height="320px" class="card-img-top" alt="histórico">
                    <br><hr>
                    <div class="card-body">
                        <h5 class="card-title text-center">Panel del Histórico</h5>
                        <p class="card-text text-center">Aqui se pueden consultar los productos más vendidos de cada mes.</p>
                        <a href="Index_historico" class="btn btn-primary px-5 fs-5 d-flex justify-content-center bg-success">Ir al Panel</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
