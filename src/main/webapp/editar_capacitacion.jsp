<%@page import="controlador.EditarCapacitacion"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<title>Registro de Empleado</title>
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<%
    session=request.getSession(false);
    if(session.getAttribute("admin")==null)
    {
        response.sendRedirect("login_user.jsp");
    }

%>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Menu</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="usuario.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="crear_capacitacion.jsp">Crear Capacitacion</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListarCapacitaciones">Listar Capacitaciones</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="CrearUsuario">Crear Usuario</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListarUsuarios">Listar Usuarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="contacto.jsp">Contacto</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="cerrar_sesion.jsp">Cerrar Sesion</a>
        </li>
      </ul>
      <span class="navbar-text">
        Sistema Asesoria Prevencion De Riesgo V1.0
      </span>
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
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
