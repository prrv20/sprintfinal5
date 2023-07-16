<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creacion de Usuarios</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary"style="background-color: #37729c;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="assets/logo.png" alt="Logo" width="" height="50"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboard.jsp">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Capacitaciones
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="crear_capacitacion.jsp">Crear Capacitacion</a></li>
            <li><a class="dropdown-item" href="ListarCapacitaciones">Listar Capacitaciones</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Usuarios
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="crear_usuarios.jsp">Crear Usuarios</a></li>
            <li><a class="dropdown-item" href="listar_usuarios.jsp">Listar Usuarios</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="contacto.jsp">Contacto</a>
        </li>
          <li class="nav-item">
          <button type="button" class="btn btn-outline-danger" onclick="window.location.href='cerrar_sesion.jsp';">Cerrar Sesion </button>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container col-sm-10 col-md-8">
		<br>
        <h2>Creacion de Usuarios</h2>
        <form action="">
            <div class="usuario">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Run</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="12345678-9">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre Completo">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Fecha Nacimiento</label>
                    <input type="date" class="form-control" id="exampleFormControlInput1" placeholder="Fecha Nacimiento">
                </div>
                
              </div>
              <label for="opciones">Tipo de Usuario:</label>
              <select id="opciones" onchange="mostrarCampos()"" class="form-select" aria-label="Default select example">
                <option selected>Seleccione el tipo de Usuario</option>
                <option value="opcion1">Cliente</option>
                <option value="opcion2">Profesional</option>
                <option value="opcion3">Administrativo</option>
              </select>
              
        
              <div class="cliente">
                <div id="campo1" class="campo mt-3" style="display: none">
                    <label for="campo1_input1">Telefono:</label>
                    <input type="text" id="campo1_input1" class="form-control"/>
                    <label class="mt-2" for="campo1_input2">Direccion:</label>
                    <input type="text" id="campo1_input2" class="form-control" />
                    <label for="campo2_input" class="mt-2">Comuna:</label>
                    <input type="text" id="campo2_input" class="form-control mb-2" />
                    <label for="campo2_input" class="mt-2"></label>Sistema de Salud:</label>
                    <select class="form-select mt-2" aria-label="Default select example">
                        <option selected>Selecciona Sistema de Salud</option>
                        <option value="1">FONASA</option>
                        <option value="2">ISAPRE</option>    
                    </select>
                    <label for="campo2_input" class="mt-2">AFP:</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Elige Una Opcion</option>
                        <option value="1">AFP CAPITAL</option>
                        <option value="2">AFP HABITAT</option>
                        <option value="3">AFP CUPRUM</option>
                        <option value="4">AFP MODELO</option>
                        <option value="5">AFP PLANVITAL</option>
                        <option value="6">AFP PROVIDA</option>
                      </select>
                </div>
                  
                  
              </div>
              
              <div class="profesinal mt-3">
                <div id="campo3" class="campo" style="display: none">
                    <label for="campo3_input1">Titulo:</label>
                    <input type="text" id="campo3_input1" class="form-control"/>
                    <label for="campo3_input2" class="mt-2">Fecha de Ingreso:</label>
                    <input type="text" id="campo3_input2" class="form-control" />
                  </div>
              </div>
              
              <div class="administrativo mt-3">
                <div id="campo6" class="campo" style="display: none">
                    <label for="campo6_input1">Area:</label>
                    <input type="text" id="campo6_input1" class="form-control" />
                    <label for="campo6_input2" class="mt-2">Experiencia Previa:</label>
                    <input type="text" id="campo6_input2" class="form-control"/>
                  </div>
              </div>
              <button type="submit" class="btn btn-success" id="boton" style="display: none">Registrar</button>
        </form>
      
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script type="text/javascript"src="./assets/js/script_user.js"></script>
</body>
</html>