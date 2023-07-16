function mostrarCampos() {
    var seleccion = document.getElementById("opciones").value;
    var campos = document.getElementsByClassName("campo");

    // Oculta todos los campos
    for (var i = 0; i < campos.length; i++) {
      campos[i].style.display = "none";
    }
// Muestra los campos según la opción seleccionada
    if (seleccion === "opcion1") {
      document.getElementById("campo1").style.display = "block";
      document.getElementById("boton").style.display = "block";
   
    } else if (seleccion === "opcion2") {
      document.getElementById("campo3").style.display = "block";
      document.getElementById("boton").style.display = "block";
     
     
    } else if (seleccion === "opcion3") {
      document.getElementById("campo6").style.display = "block";
      document.getElementById("boton").style.display = "block";
   
    }
    
  }