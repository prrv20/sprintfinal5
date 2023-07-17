function mostrarCampos() {
    var seleccion = document.getElementById("opciones").value;
    var campos = document.getElementsByClassName("campo");

    // Oculta todos los campos
    for (var i = 0; i < campos.length; i++) {
      campos[i].style.display = "none";
    }
// Muestra los campos según la opción seleccionada
    if (seleccion === "Cliente") {
      document.getElementById("campo1").style.display = "block";
      document.getElementById("boton").style.display = "block";
   
    } else if (seleccion === "Profesional") {
      document.getElementById("campo3").style.display = "block";
      document.getElementById("boton").style.display = "block";
     
     
    } else if (seleccion === "Administrativo") {
      document.getElementById("campo6").style.display = "block";
      document.getElementById("boton").style.display = "block";
   
    }
    
  }