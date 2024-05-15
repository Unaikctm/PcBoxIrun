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
    
    <%@ include file="/partes/navbar.jsp" %>
    
    <div class="container">
	    <h1 style="margin-top: 3%; margin-bottom: 3%;">Detalles de la Reparación #${reparacion.id}</h1>
	    <div class="card mb-3">
	        <div class="card-header">
	            <h2>Información de la Reparación:</h2>
	        </div>
	        <div class="card-body">
	            <p class="card-text">Fecha de la reparacion: ${factura.fecha}</p>
	            <p class="card-text">Tipo: ${reparacion.tipo}</p>
	            <p class="card-text">Descripción: ${reparacion.descripcion}</p>
	            <p class="card-text">Horas: ${reparacion.horas}</p>
	            <p class="card-text">Precio: ${reparacion.precio}&euro;</p>
	        </div>
	    </div>
	    <div class="card mb-3">
	        <div class="card-header">
	            <h2>Información de la Factura:</h2>
	        </div>
	        <div class="card-body">
	            <div class="row justify-content-end">
	                <div class="col-md-6 text-md-end">
	                    <p class="card-text"><strong>Total de la Factura + IVA incluido:</strong> ${factura.total}&euro;</p>
	                    <p class="card-text"><strong>Pagado:</strong> ${factura.pagado}</p>
	                    <!-- Pagar -->
						<button type="button" class="btn btn-success" title="Pagar Factura" data-bs-toggle="modal" data-bs-target="#${factura.id}">
					    	Pagar
						</button>
					
						<!-- Modal -->
						<div class="modal fade" id="${factura.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
											
					    	<div class="modal-dialog">
					        	<div class="modal-content">
					            	<div class="modal-header bg-success text-white">
					                	<h5 class="modal-title" id="exampleModalLabel">Pagar factura</h5>
					                	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					            	</div>
					            	<form action="Update_pago" method="POST">
										<div class="form-check">
					                        <input class="form-check-input" type="radio" name="pagado" id="pagado_si" value="Si">
					                        <label class="form-check-label" for="pagado_si">
					                            Pagado
					                        </label>
					                    </div>
					                    <div class="form-check">
					                        <input class="form-check-input" type="radio" name="pagado" id="pagado_no" value="No" required>
					                        <label class="form-check-label" for="pagado_no">
					                            Pendiente
					                        </label>
					                    </div>
					                    <input type="hidden" name="factura_id" value="${factura.id}">
					                    <input type="hidden" name="factura_tipo" value="${factura.tipo}">
					                    <div class="modal-footer">
					                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
					                        <button type="submit" class="btn btn-success">Guardar</button>
					                    </div>
									</form>
								</div>
							</div>
						</div>	
	                </div>
	            </div>
	        </div>
	    </div>
	    <a href="javascript:history.back()" class="btn btn-success text-decoration-none">
    		<i class="bi bi-arrow-left-circle text-white"></i>
  		</a>
	</div>

    <!-- Bootstrap JS and other scripts here -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>