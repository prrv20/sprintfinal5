<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controlador.ListarCapacitacion" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Listado Capacitaciones</title>
  

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<body>
</head>
<body>
<%
    session=request.getSession(false);
    if(session.getAttribute("admin")==null)
    {
        response.sendRedirect("login_user.jsp");
    }

%>
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


  <div class="container">
        <h1 class="mt-4">Listado de Capacitaciones</h1>
        <table class="table table-striped mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Rut</th>
                    <th>Dia</th>
                    <th>Hora</th>
                    <th>Lugar</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <% List<ListarCapacitacion> capacitaciones = (List<ListarCapacitacion>) request.getAttribute("capacitaciones"); %>
                <% for (ListarCapacitacion capacitacion : capacitaciones) { %>
                    <tr>
                        <td><%= capacitacion.getId() %></td>
                        <td><%= capacitacion.getRut() %></td>
                        <td><%= capacitacion.getDia() %></td>
                        <td><%= capacitacion.getHora() %></td>
                        <td><%= capacitacion.getLugar() %></td>
                        <td><%= capacitacion.getCantidad() %></td>
                        <td>
                            <a href="Editar-Capacitacion?id=<%= capacitacion.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="Eliminar-Capacitacion?id=<%= capacitacion.getId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>


  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>   
	<script type="text/javascript"src="./assets/js/script.js"></script>
</body>
<% out.print("Session id:" + session.getId()); %>
</html>