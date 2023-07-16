const form = document.getElementById("formcapacitacion")
const button = document.getElementById("btn-registrar")
const rut = document.getElementById("rut")
const dia = document.getElementById("dia")
const hora = document.getElementById("hora")
const lugar = document.getElementById("lugar")
const cantidad = document.getElementById("cantidad")


const formIsValid={
	rut:false,
	dia:false,
	hora:false,
	lugar:false,
	cantidad:false,

}

form.addEventListener('submit', (e)=>{
    e.preventDefault();
    validateForm();
})

dia.addEventListener('change', (e)=>{
    if(e.target.value.trim().length>0)
    formIsValid.dia = true
})

hora.addEventListener('change', (e)=>{
    if(e.target.value.trim().length>0)
    formIsValid.hora = true
})

lugar.addEventListener('change', (e)=>{
    if(e.target.value.trim().length>0)
    formIsValid.lugar = true
})

cantidad.addEventListener('change', (e) => {
    if (cantidad.value > 0)
        formIsValid.cantidad = true;
});


rut.addEventListener('change', (e)=>{
    if(e.target.value.trim().length > 0)
        formIsValid.rut = true
        
        if (Fn.validaRut( $("#rut").val() )){	
	} else {
		alert("El Rut no es válido ")
	}
        })
        
const validateForm = () => {
    const formValues = Object.values(formIsValid)
    const valid = formValues.findIndex(value=> value==false)
    if(valid == -1) form.submit()
    else alert('Formulario Incompleto')
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

