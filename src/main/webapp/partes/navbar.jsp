	<nav class="navbar navbar-expand-lg navbar-success bg-success">
    <div class="container">
    
        <!-- Logo -->
        <a class="navbar-brand" href="#">
            <img src="img/images.png" alt="Logo" width="80">
        </a>

        <!-- Botón para colapsar en dispositivos pequeños -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Elementos de navegación -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Enlace</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Desplegable
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Acción</a></li>
                        <li><a class="dropdown-item" href="#">Otra acción</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Algo más aquí</a></li>
                    </ul>
                </li>
            </ul>

            <!-- Formulario de búsqueda -->
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar">
                <button class="btn btn-outline-success" type="submit">Buscar</button>
            </form>
        </div>
    </div>
</nav>