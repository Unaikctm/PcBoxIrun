<nav class="navbar navbar-expand-lg navbar-light bg-success py-2">

	<div class="container-fluid d-flex justify-content-center" style="margin-left:50px">
        <!-- Logo -->
        <a class="navbar-brand bg-light" href="Landing"> <img src="img/main_page/pcboxlogo.png" alt="Logo" height="90px"></a>
    </div>

    <div class="d-flex justify-content-start px-6" style="margin-left:30px">
			<a href="SolicitarReparacion" class="text-decoration-none" style="display: inline-block; padding: 10px 20px; font-size: 16px; font-weight: bold; text-align: center; border: 2px solid transparent; border-radius: 4px; cursor: pointer; background-color: #ffc107; color: #fff; text-decoration: none; margin-right: 10px;" onmouseover="this.style.borderColor='#000';" onmouseout="this.style.borderColor='transparent';">
			  Solicitar Reparación
			</a>
			<button style="display: inline-block; padding: 10px 20px; font-size: 16px; font-weight: bold; text-align: center; border: 2px solid transparent; border-radius: 4px; cursor: pointer; background-color: #ffc107; color: #fff; text-decoration: none; margin-right: 10px;" data-bs-toggle="modal" data-bs-target="#loginModal" onmouseover="this.style.borderColor='#000';" onmouseout="this.style.borderColor='transparent';">
			  Panel Admin
			</button>
	</div>
		
	<!-- Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
		          <div class="modal-header">
		               <h5 class="modal-title" id="loginModalLabel">Iniciar sesion</h5>
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
				               <button type="submit" class="btn btn-primary">Iniciar sesion</button>
				           </div>
		           		</form>
		           </div>
		      </div>
		 </div>
	</div>

</nav>
