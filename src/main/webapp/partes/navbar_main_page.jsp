<nav class="navbar navbar-expand-lg navbar-light bg-success py-2">

		<div class="container-fluid d-flex justify-content-center" style="margin-left:50px">
        <!-- Logo -->
        <a class="navbar-brand bg-light" href="Landing"> <img src="img/main_page/pcboxlogo.png" alt="Logo" height="90px"></a>
    </div>

    <div class="d-flex justify-content-start px-6" style="margin-left:30px">
			<button class="bg-warning">
				<a href="SolicitarReparacion" class="text-white text-decoration-none">Solicitar Reparación</a>
			</button>
		  <button style="margin-right:10px" class="bg-warning text-white" data-bs-toggle="modal" data-bs-target="#loginModal">
        Panel Admin
      </button>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 class="modal-title" id="loginModalLabel">Iniciar sesión</h5>
		                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		            </div>
		            <div class="modal-body">
		                <form action="Inicio_sesion" method="POST">
		                    <div class="mb-3">
		                        <label for="username" class="form-label">Usuario</label>
		                        <input type="text" class="form-control" id="username" name="username" required>
		                    </div>
		                    <div class="mb-3">
		                        <label for="password" class="form-label">Contraseña</label>
		                        <input type="password" class="form-control" id="password" name="password" required>
		                    </div>

				            <div class="modal-footer">
				                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
				                <button type="submit" class="btn btn-primary">Iniciar sesión</button>
				            </div>
		            	</form>
		            </div>
		        </div>
		    </div>
		</div>

	</nav>