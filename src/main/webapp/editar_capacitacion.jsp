<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="controlador.EditarCapacitacion"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<title>Registro de capacitaciones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<%
    session=request.getSession(false);
    if(session.getAttribute("admin")==null)
    {
        response.sendRedirect("login_user.jsp");
    }

%>
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
            <li><a class="dropdown-item" href="crear_usuarios.jsp">Crear Usuario</a></li>
            <li><a class="dropdown-item" href="ListarUsuarios">Listar Usuarios</a></li>
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

	<div class="container col-lg-8 mt-4">
		<h1>Editar Capacitaciones</h1>
		<% EditarCapacitacion capacitacion = (EditarCapacitacion) request.getAttribute("capacitacion"); %>
		<form action="Actualizar-Capacitacion" method="post">
			<input type="hidden" name="id" value="<%= capacitacion.getId() %>">
			<div class="form-group">
				<label for="nombre">Rut Cliente:</label> 
				<input type="text" class="form-control" id="rut" name="rut" required value="<%= capacitacion.getRut() %>">
			</div>
			
			<div class="form-group">
				<label for="exampleDataList" class="form-label">Dia de la Capacitacion</label> 
				<input class="form-control" list="datalistOptions" id="dia" name="dia" placeholder="Seleccione el dia" value="<%= capacitacion.getDia() %>">
				<datalist id="datalistOptions">
					<option value="Lunes">
					<option value="Martes">
					<option value="Miercoles">
					<option value="Jueves">
					<option value="Viernes">
					<option value="Sabado">
					<option value="Domingo">
				</datalist>
			</div>
			<div class="form-group">
				<label for="correo">Hora:</label> 
				<input type="text" class="form-control" id="hora" name="hora" required value="<%= capacitacion.getHora() %>">
			</div>
			<div class="form-group">
				<label for="nombre">Lugar:</label> 
				<input type="text" class="form-control" id="lugar" name="lugar" required value="<%= capacitacion.getLugar() %>">
			</div>
			<div class="form-group">
				<label for="nombre">Cantidad de Asistentes:</label> 
				<input type="text" class="form-control" id="cantidad" name="cantidad" required value="<%= capacitacion.getCantidad() %>">
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>

	</div>
	 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
