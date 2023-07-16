<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Mensajes</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container col-lg-8 my-4">
		<h1>Resumen de Registro de Mensaje</h1>

		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Mensaje Recibido</h5>
				<p class="card-text">
					<strong>Nombre:</strong>
					<%=request.getParameter("nombre")%></p>
				<p class="card-text">
					<strong>Correo Electrónico:</strong>
					<%=request.getParameter("email")%></p>
				<p class="card-text">
					<strong>Mensaje:</strong>
					<%=request.getParameter("mensaje")%></p>
			</div>
		</div>
		<div class="mt-4">
			<a href="index.jsp">Ir a Inicio</a> 
      <a href="crear_capacitacion.jsp">Crear Capacitacion</a> 
      <a href="contacto.jsp">Contactanos</a>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
