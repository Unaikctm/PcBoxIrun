<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pc Box</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css"
	rel="stylesheet">

</head>
<body
	style="background: rgb(209, 214, 214); background: linear-gradient(0deg, rgba(209, 214, 214, 1) 7%, rgba(255, 255, 255, 1) 49%);">

	<%@ include file="/partes/navbar.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/partes/sidebar.jsp"%>

				<div class="col-md-11 col-sm p-3 min-vh-100">
					<div class="col col-sm py-3">
						<table class="table table-sm table-responsive">
							<thead>
								<tr>
									<th scope="col">
										<button type="button" class="btn btn-success" title="A�adir Cliente" data-bs-toggle="modal" data-bs-target="#insertModal">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-plus-lg" viewBox="0 0 16 16">
								  				<path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2z" />
											</svg>
										</button>
			
										<div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog modal-lg">
												<div class="modal-content">
													<div class="modal-header bg-success text-white">
														<h5 class="modal-title" id="exampleModalLabel">Insertar Cliente</h5>
														<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<form action="Store_cliente" method="POST">
														<div class="modal-body">
			
															<div class="mb-3">
																<label for="nombre" class="form-label">Nombre:</label> 
																<input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}" required>
															</div>
			
															<div class="mb-3">
																<label for="apellido" class="form-label">Apellido:</label>
																<input type="text" class="form-control" id="apellido" name="apellido" value="${cliente.apellido}" required>
															</div>
			
															<div class="mb-3">
																<label for="dni" class="form-label">DNI:</label> 
																<input type="text" class="form-control" id="dni" name="dni" value="${cliente.dni}">
															</div>
			
															<div class="mb-3">
																<label for="direccion" class="form-label">Direcci�n:</label>
																<input type="text" class="form-control" id="direccion" name="direccion" value="${cliente.direccion}">
															</div>
			
															<div class="mb-3">
																<label for="codigopostal" class="form-label">C�digo postal:</label>
																<input type="text" class="form-control" id="codigopostal" name="codigopostal" value="${cliente.codigopostal}">
															</div>
			
															<div class="mb-3">
																<label for="email" class="form-label">Email:</label> 
																<input type="email" class="form-control" id="email" name="email" value="${cliente.email}">
															</div>
			
															<div class="mb-3">
																<label for="telefono" class="form-label">Tel�fono:</label>
																<input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">
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
									<th scope="col">DNI</th>
									<th scope="col">Nombre</th>
									<th scope="col">Apellidos</th>
									<th scope="col">Acciones</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach items="${clientes}" var="cliente">
									<tr>
										<th scope="row"></th>
										<td>${cliente.dni}</td>
										<td>${cliente.nombre}</td>
										<td>${cliente.apellido}</td>
			
										<td>
											<a href="Show_cliente?dni=${cliente.dni}" class="btn btn-primary" title="Visualizar Cliente"> 
												<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
													<path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z" />
													<path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0" />
												</svg>
											</a> 
										
										<!-- Bot�n para abrir el modal -->
											<button type="button" class="btn btn-warning" title="Editar Cliente" data-bs-toggle="modal" data-bs-target="#updateModal${cliente.dni }">
												<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
			        								<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" />
			    								</svg>
											</button> 
											
											<!-- Modal -->
											<div class="modal fade" id="updateModal${cliente.dni }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header bg-success text-white">
															<h5 class="modal-title" id="exampleModalLabel">Editar cliente</h5>
															<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<form action="Update_cliente" method="POST">
															<div class="modal-body">
																<input type="hidden" name="dni" value="${cliente.dni}">
																<div class="mb-3">
																	<label for="nombre" class="form-label">Nombre:</label> 
																	<input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}">
																</div>
			
																<div class="mb-3">
																	<label for="apellido" class="form-label">Apellido:</label>
																	<input type="text" class="form-control" id="apellido" name="apellido" value="${cliente.apellido}">
																</div>
			
																<div class="mb-3">
																	<label for="direccion" class="form-label">Direccion:</label>
																	<input type="text" class="form-control" id="direccion" name="direccion" value="${cliente.direccion}">
																</div>
			
																<div class="mb-3">
																	<label for="codigopostal" class="form-label">C�digo postal:</label>
																	<input type="text" class="form-control" id="codigopostal" name="codigopostal" value="${cliente.codigopostal}">
																</div>
			
																<div class="mb-3">
																	<label for="email" class="form-label">Email:</label>
																	<input type="text" class="form-control" id="email" name="email" value="${cliente.email}">
																</div>
			
																<div class="mb-3">
																	<label for="telefono" class="form-label">Tel�fono:</label>
																	<input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">
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
											
											<!-- Mostrar sus reparaciones -->
											<a href="Show_reparacion_de_cliente?dni=${cliente.dni}" class="btn btn-success float-end me-2" title="Visualizar Pedidos de un cliente"> 
												Mostrar reparaciones
											</a> 
											
											<!-- Mostrar sus pedidos -->
											<a href="Show_pedido_de_cliente?dni=${cliente.dni}" class="btn btn-success float-end me-2" title="Visualizar Pedidos de un cliente"> 
												Mostrar pedidos	
											</a> 
			
											<!-- Eliminar -->
											<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmacionModal${cliente.dni}">
												<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
					  								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
					  								<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
												</svg>
											</button>
			
											<div class="modal fade" id="confirmacionModal${cliente.dni}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Eliminar Cliente</h5>
															<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">�Est�s seguro de que quieres eliminar este cliente?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
															<a href="Destroy_cliente?dni=${cliente.dni}" class="btn btn-danger">Eliminar</a>
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
