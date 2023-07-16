<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulario de inicio de sesion</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h3 class="text-center">Iniciar sesion</h3>
          </div>
          <div class="card-body">
            <form action="Login" method=post>
              <div class="form-group">
                <label for="email">Usuario</label>
                <input type="text" class="form-control" name="usName" placeholder="Ingresa tu usuario">
              </div>
              <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" class="form-control" name="usPass" placeholder="Ingresa tu contraseña">
              </div>
              <button type="submit" class="btn btn-primary btn-block">Iniciar sesion</button>
              </br>
              <% out.print("Session id:" + session.getId()); %>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>