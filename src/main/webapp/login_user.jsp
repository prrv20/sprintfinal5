<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulario de inicio de sesion</title>

  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" integrity="sha512-t4GWSVZO1eC8BM339Xd7Uphw5s17a86tIZIj8qRxhnKub6WoyhnrxeCIMeAqBPgdZGlCcG2PrZjMc+Wr78+5Xg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  	<link rel="stylesheet" href="./assets/css/style_login.css">
</head>
<body>
   <div class="login-page">
      <div class="container">
         <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-8 mx-auto">
               <div class="card login">
                  <h1>Iniciar Sesion</h1>
                  <form action="Login" method="post" class="form-group">
                     <input type="text" class="form-control" placeholder="Usuario" name="username" required>
                     <input type="password" class="form-control" placeholder="Contraseña" name="password" required>
                     <input type="submit" class="btn btn-primary" value="Ingresar">
                     <br>
                     <% out.print("Session id:" + session.getId()); %>
                  </form>
               </div>
            </div>
         </div>
      </div>
 </div>
	<script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.10/vue.min.js'></script>
</body>
</html>