<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pc Box</title>
    <link rel="stylesheet" href="css/hover.css";>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body style="background: rgb(209,214,214); background: linear-gradient(0deg, rgba(209,214,214,1) 7%, rgba(255,255,255,1) 49%);">

    <%@ include file="/partes/navbar.jsp" %>

	<!-- Mensajes de error -->

	<c:if test="${param.msg == 'failInsertar'}">
	    <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
	        <strong>Error:</strong> Fallo al insertar, revisa que el stock y el precio no contengan carácteres.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg=='okayInsertar'}">
	    <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
			<strong>Ok!</strong> Se ha insertado correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>
		
	<c:if test="${param.msg == 'failUpdate'}">
	    <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
	        <strong>Error:</strong> Fallo al actualizar, revisa que el stock y el precio no contengan carácteres.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg=='okayUpdate'}">
	    <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
			<strong>Ok!</strong> Se ha actualizado correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>

	<c:if test="${param.msg == 'failDelete'}">
	    <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
	        <strong>Error:</strong> Error, no puedes eliminar productos que son parte de pedidos realizados.
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<c:if test="${param.msg=='okayDelete'}">
	    <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
			<strong>Ok!</strong> Se ha eliminado correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>

    <div class="container-fluid">
        <div class="row">
            <%@ include file="/partes/sidebar.jsp" %>

            <div class="col-sm p-3">
                <div class="col py-3">
                	<h2>Productos</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">
                                    <button type="button" class="btn btn-success" title="Añadir Producto" data-bs-toggle="modal" data-bs-target="#insertModal">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2z"/>
                                        </svg>
                                    </button>

                                    <div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header bg-success text-white">
                                                    <h5 class="modal-title" id="exampleModalLabel">Insertar Producto</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <form action="Store_producto" method="POST">
                                                    <div class="modal-body">
                                                        <div class="mb-3">
                                                            <label for="nombre" class="form-label">Nombre:</label>
                                                            <input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}" required>
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="tipo" class="form-label">Tipo:</label>
                                                            <input type="text" class="form-control" id="tipo" name="tipo" value="${producto.tipo}">
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="marca" class="form-label"><b>Marca:</b></label>
                                                            <input type="text" class="form-control" id="marca" name="marca" value="${producto.marca}">
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="precio" class="form-label">Precio:</label>
                                                            <input maxlength="7" type="text" class="form-control" id="precio" name="precio" value="${producto.precio}">
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="stock" class="form-label">Stock:</label>
                                                            <input maxlength="5" type="text" class="form-control" id="stock" name="stock" value="${producto.stock}">
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
                                <th scope="col">Nombre</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Marca</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach items="${productos}" var="producto">
                                <tr>
                                    <th scope="row"></th>
                                    <td>${producto.id}</td>
                                    <td>${producto.nombre}</td>
                                    <td>${producto.tipo}</td>
                                    <td>${producto.marca}</td>

                                    <td>
                                        <a href="Show_producto?id=${producto.id}" class="btn btn-primary" title="Visualizar Producto">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z"/>
                                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
                                            </svg>
                                        </a>

                                        <button type="button" class="btn btn-warning" title="Editar Producto" data-bs-toggle="modal" data-bs-target="#${producto.id}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                                <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z"/>
                                            </svg>
                                        </button>

                                        <div class="modal fade" id="${producto.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header bg-success text-white">
                                                        <h5 class="modal-title" id="exampleModalLabel">Editar producto</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <form action="Update_producto" method="POST">
                                                        <div class="modal-body">
                                                            <input type="hidden" name="id" value="${producto.id}">
                                                            <div class="mb-3">
                                                                <label for="nombre" class="form-label">Nombre:</label>
                                                                <input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="tipo" class="form-label">Tipo:</label>
                                                                <input type="text" class="form-control" id="tipo" name="tipo" value="${producto.tipo}">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="marca" class="form-label"><b>Marca:</b></label>
                                                                <input type="text" class="form-control" id="marca" name="marca" value="${producto.marca}">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="precio" class="form-label">Precio:</label>
                                                                <input type="text" class="form-control" id="precio" name="precio" value="${producto.precio}">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="stock" class="form-label">Stock:</label>
                                                                <input type="text" class="form-control" id="stock" name="stock" value="${producto.stock}">
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

                                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmacionModal${producto.id}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </button>

                                        <div class="modal fade" id="confirmacionModal${producto.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Eliminar Producto</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">¿Estás seguro de que quieres eliminar este producto?</div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                        <a href="Destroy_producto?id=${producto.id}" class="btn btn-danger">Eliminar</a>
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
