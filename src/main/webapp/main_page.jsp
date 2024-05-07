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
			<a class="navbar-brand bg-light" href="Landing"> <img src="img/main_page/pcboxlogo.png" alt="Logo" height="90px"></a>
			
			<!-- Botón para colapsar en dispositivos pequeños -->
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>
	
	<div class="container-fluid mt-4">
        <div class="row">
            <!-- productos -->
             <c:if test="${articulos.size()==0}">
             	<div class="col-md-12">
            </c:if>
             <c:if test="${articulos.size()!=0}">
            	<div class="col-md-9">
            </c:if>
                <div class="row">
                    <c:forEach items="${productos}" var="producto">
                        <div class="col-md-3 mb-4">
                            <div class="card h-100">
                                <img src="img/img_producto/${producto.nombre.replaceAll(" ","_")}.png" class="card-img-top" alt="productos">
                                <h5 class="card-title text-center mt-4">${producto.nombre}</h5> 
                                <div class="card-body">
                                    <p class="card-text text-center">${producto.tipo}</p>
                                    <p class="card-text text-center fw-bold fs-4 text-warning">${producto.precio} &euro;</p>
                                </div>
                                <div class="card-footer">
                                    <form action="Store_Carrito" method="post">
                                        <div class="form-group d-flex justify-content-evenly">
                                            <input type="number" class="form-control-sm" name="cantidad" min="1" max="10" value="1">
                                            <input type="hidden" name="productId" value="${producto.id}">
                                            <button type="submit" class="btn btn-primary px-4 fs-5 bg-success">
                                                <i class="bi bi-cart4"></i>
                                            </button>
                                        </div>  
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <!-- carrito -->
            <c:if test="${articulos.size()!=0}">
			<div class="col-md-3">
    			<div class="d-flex justify-content-between mb-4">
        			<h5 class="mb-4">Carrito</h5>
        			 <!-- Finalizar Compra -->
        			<!-- Botón para abrir el modal -->
					<button type="button" title="Finalizar Compra" data-bs-toggle="modal" data-bs-target="#insertarPedido" class="btn btn-success">
					    <i class="bi bi-cart-check"></i> Finalizar compra
					</button>
					
					<!-- Modal para mostrar los datos del carrito -->
					<div class="modal fade" id="insertarPedido" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					    <div class="modal-dialog modal-lg">
					        <div class="modal-content">
					            <div class="modal-header bg-success text-white">
					                <h5 class="modal-title" id="exampleModalLabel">Detalles del Carrito</h5>
					                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					            </div>
					            <form action="Main_page" method="POST">
						            <div class="modal-body">
						            	<input type="hidden" name="articulos" value="${articulos}">
						                <!-- Aquí se mostrarán los detalles del carrito -->
						                <c:forEach items="${articulos}" var="articulo">
						                    <div class="d-flex align-items-center mb-3">
						                        <img src="img/img_producto/${articulo.producto.nombre.replaceAll(" ","_")}.png" alt="producto" style="max-width: 50px;" class="me-3">
						                        <div>
						                            <h6 class="mb-1">${articulo.producto.nombre}</h6>
						                            <p>${articulo.cantidad} x <b>${articulo.precio} &euro;</b></p>
						                        </div>
						                    </div>
						                </c:forEach>
						                <!-- Precio total -->
						                <div>
						                    <p class="fw-bold fs-5 text-center mt-3">Precio Total: ${precioTotal} &euro;</p>
						                </div>
						                <div>
						                    <label for="dni" class="form-label">DNI:</label><br>
						                    <input type="text" class="form-control" id="dni" name="dni" required></input>
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
        			
        			 <!-- Borrar carrito -->
        			<a href="Destroy_carrito" class="btn btn-danger me-2"> 
            		<i class="bi bi-trash"></i> Eliminar Carrito
        			</a>
    			</div>
    			
        			<div class="list-group">
            			<c:forEach items="${articulos}" var="articulo">
                			<a href="Destroy_articulo?ID_Producto=${articulo.producto.id}" class="list-group-item list-group-item-action">
                    		<div class="d-flex justify-content-between">
		                        <img src="img/img_producto/${articulo.producto.nombre.replaceAll(" ","_")}.png" alt="producto" style="max-width: 50px;">
		                        <h6 class="mb-1">${articulo.producto.nombre}</h6>
		                        <small>${articulo.cantidad} x ${articulo.precio} &euro;</small>   
                    		</div>
                			</a>
            			</c:forEach>
            			<div>
            				<p class="fw-bold fs-5 text-center mt-3">Precio Total: ${precioTotal} &euro;</p>
            			</div>
        				</div>
					</div>
					 
				</c:if>
            </div>
        </div>
        
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
</body>
</html>