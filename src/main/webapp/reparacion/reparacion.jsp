<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pc Box</title>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body style="background: rgb(209,214,214); background: linear-gradient(0deg, rgba(209,214,214,1) 7%, rgba(255,255,255,1) 49%);">
	
	<%@ include file="/partes/navbar.jsp" %>
	
	<!-- Mensajes de error -->
	
	<c:if test="${param.msg == 'failInsertar'}">
	    <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
	        <strong>Error:</strong> Fallo al insertar, revisa que las horas y el precio por hora no contengan carácteres.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg == 'failUpdate'}">
	    <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
	        <strong>Error:</strong> Fallo al actualizar, revisa que las horas y el precio por hora no contengan carácteres.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg=='okayInsertar'}">
	    <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
			<strong>Ok!</strong> Se ha insertado correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>
	
	<c:if test="${param.msg=='okayUpdate'}">
	    <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
			<strong>Ok!</strong> Se ha actualizado correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/partes/sidebar.jsp" %>
   
    		<div class="col-sm p-3">
            	<div class="col py-3">
            		<h2>Reparaciones</h2>
               		<table class="table">
        				<thead>
          					<tr>
            					<th scope="col">
					            	<button type="button" class="btn btn-success" title="AÃ±adir Reparacion" data-bs-toggle="modal" data-bs-target="#insertModal">
						  				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-plus-lg" viewBox="0 0 16 16">
										  	<path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2z"/>
										</svg>
									</button>
					
									<div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				    					<div class="modal-dialog modal-lg">
				        					<div class="modal-content">
				            					<div class="modal-header bg-success text-white">
				                					<h5 class="modal-title" id="exampleModalLabel">Insertar Reparacion</h5>
				                					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            					</div>
				           						<form action="Store_reparacion" method="POST">
					                				<div class="modal-body">
					                    				<div class="mb-3">
					                        				<label for="tipo" class="form-label">Tipo:</label>
					                        				<input type="text" class="form-control" id="tipo" name="tipo" value="${reparacion.tipo}" required>
					                    				</div>
	                    
					                    				<div class="mb-3">
									                        <label for="descripcion" class="form-label">Descripcion:</label>
									                        <input type="text" class="form-control" id="descripcion" name="descripcion" value="${reparacion.descripcion}">
									                    </div>
					                    
									                    <div class="mb-3">
									                        <label for="horas" class="form-label">Horas:</label>
									                        <input maxlength="2" type="text" class="form-control" id="horas" name="horas" value="${reparacion.horas}">
									                    </div>
									                    
									                    <div class="mb-3">
									                        <label for="precio" class="form-label">Precio:</label>
									                        <input maxlength="7" type="text" class="form-control" id="precio" name="precio" value="${reparacion.precio}">
									                    </div>
									                    
														<div class="mb-3">
														    <label for="dni" class="form-label">Cliente:</label>
														    <select class="form-select" id="dni" name="dni">
														        <c:forEach var="dni" items="${listaDNI}">
														            <option value="${dni}">${dni}</option>
														        </c:forEach>
														    </select>
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

								</th>
					            <th scope="col">ID</th>
					            <th scope="col">DNI Cliente</th>
					            <th scope="col">Tipo</th>
					            <th scope="col">Descripcion</th>
					            <th scope="col">Horas</th>
					            <th scope="col">Precio</th>
					            <th scope="col">Acciones</th>
	          				</tr>
        				</thead>
				        <tbody class="table-group-divider">
				        	<c:forEach items="${reparaciones}" var="reparacion">
					          <tr>
					            <th scope="row"></th>
					            <td>${reparacion.id}</td>
					            <td>
					             <a href="Show_cliente?dni=${reparacion.cliente.dni}">${reparacion.cliente.dni}</a>
					            </td>
					            <td>${reparacion.tipo}</td>
					            <td>${reparacion.descripcion}</td>
					            <td>${reparacion.horas}</td>
					            <td>${reparacion.precio}&euro;</td>
					            
					            <td>
					            	
									<!-- Mostrar sus pedidos -->
									<a href="Show_factura_de_reparacion?id=${reparacion.id}" class="btn btn-primary" title="Visualizar factura de la reparacion"> 
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-receipt-cutoff" viewBox="0 0 16 16">
											<path d="M3 4.5a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5M11.5 4a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1z"/>
											<path d="M2.354.646a.5.5 0 0 0-.801.13l-.5 1A.5.5 0 0 0 1 2v13H.5a.5.5 0 0 0 0 1h15a.5.5 0 0 0 0-1H15V2a.5.5 0 0 0-.053-.224l-.5-1a.5.5 0 0 0-.8-.13L13 1.293l-.646-.647a.5.5 0 0 0-.708 0L11 1.293l-.646-.647a.5.5 0 0 0-.708 0L9 1.293 8.354.646a.5.5 0 0 0-.708 0L7 1.293 6.354.646a.5.5 0 0 0-.708 0L5 1.293 4.354.646a.5.5 0 0 0-.708 0L3 1.293zm-.217 1.198.51.51a.5.5 0 0 0 .707 0L4 1.707l.646.647a.5.5 0 0 0 .708 0L6 1.707l.646.647a.5.5 0 0 0 .708 0L8 1.707l.646.647a.5.5 0 0 0 .708 0L10 1.707l.646.647a.5.5 0 0 0 .708 0L12 1.707l.646.647a.5.5 0 0 0 .708 0l.509-.51.137.274V15H2V2.118z"/>
										</svg>
									</a> 
									
									<!-- Botón para abrir el modal -->
									<button type="button" class="btn btn-warning" title="Editar Reparacion" data-bs-toggle="modal" data-bs-target="#${reparacion.id}">
				    					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
				        					<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z"/>
				    					</svg>
									</button>
				
									<!-- Modal -->
									<div class="modal fade" id="${reparacion.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										
				    					<div class="modal-dialog">
				        					<div class="modal-content">
				            					<div class="modal-header bg-success text-white">
				                					<h5 class="modal-title" id="exampleModalLabel">Editar reparacion</h5>
				                					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				            					</div>
				            					<form action="Update_reparacion" method="POST">
												    <div class="modal-body">
												    	<input type="hidden" name="id" value="${reparacion.id}">
												    	
												        <div class="mb-3">
					                        				<label for="tipo" class="form-label">Tipo:</label>
					                        				<input type="text" class="form-control" id="tipo" name="tipo" value="${reparacion.tipo}" required>
					                    				</div>
					                    
					                    				<div class="mb-3">
									                        <label for="descripcion" class="form-label">Descripcion:</label>
									                        <input type="text" class="form-control" id="descripcion" name="descripcion" value="${reparacion.descripcion}">
									                    </div>
									                    
									                    <div class="mb-3">
									                        <label for="horas" class="form-label">Horas:</label>
									                        <input maxlength="2" type="text" class="form-control" id="horas" name="horas" value="${reparacion.horas}">
									                    </div>
									                    
									                    <div class="mb-3">
									                        <label for="precio" class="form-label">Precio:</label>
									                        <input maxlength="7" type="text" class="form-control" id="precio" name="precio" value="${reparacion.precio}">
									                    </div>
					                    			
												    </div>
												    <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
												        <button type="submit" class="btn btn-success">Guardar cambios</button>
												    </div>
												</form>
				        					</div>
				   		 				</div>
									</div>
							
									<!-- Eliminar -->
									<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmacionModal${reparacion.id}">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
						  					<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
						  					<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
										</svg>
									</button>

									<div class="modal fade" id="confirmacionModal${reparacion.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Eliminar Reparación</h5>
													<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">¿Estás seguro de que quieres eliminar este reparación?</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
													<a href="Destroy_reparacion?id=${reparacion.id}" class="btn btn-danger">Eliminar</a>
												</div>
											</div>
										</div>
									</div>
					            </td>
							</tr>
						</c:forEach>
					</tbody>
				  </table>
				</div>
			</div>
		</div>
	</div>

	
   
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
