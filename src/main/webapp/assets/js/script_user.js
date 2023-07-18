const rut = document.getElementById("rut")

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
    
    var Fn = {
	// Valida el rut con su cadena completa "XXXXXXXX-X"
	validaRut : function (rutCompleto) {
		rutCompleto = rutCompleto.replace("‐","-");
		if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test( rutCompleto ))
			return false;
		var tmp 	= rutCompleto.split('-');
		var digv	= tmp[1]; 
		var rut 	= tmp[0];
		if ( digv == 'K' ) digv = 'k' ;
		
		return (Fn.dv(rut) == digv );
	},
	dv : function(T){
		var M=0,S=1;
		for(;T;T=Math.floor(T/10))
			S=(S+T%10*(9-M++%6))%11;
		return S?S-1:'k';
	}
	
	
}

$(document).ready(function () {
        $('#txtrut').Rut({
            rutDelimiter: ".",
            enableValidation: true,
            onValidationSuccess: function(){
                console.log("Success!");
            },
            onValidationFailure: function(){
                console.log("Failure");
            }
        });
    });

    
  }