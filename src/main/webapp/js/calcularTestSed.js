function validarEntrada(object) {
    if (object.value.length > object.max.length){
        object.value = object.value.slice(0, object.max.length);
    }
}

function validarValores(e) {
	var teclado = (document.all)?e.keyCode:e.which;
	if (teclado == 8) return true;
	var patron = /^[0-9\d]*$/;
	var tec = String.fromCharCode(teclado);
	return patron.test(tec);
}


function calcularSedentarismo() {
    var dias_Int = document.getElementById('dias_Intensos').value;
    var tiempo_Int = document.getElementById('tiempo_Intensos').value;
    var dias_Mode = document.getElementById('dias_Moderadas').value;
    var tiempo_Mode = document.getElementById('tiempo_Moderadas').value;
    var dias_Caminar = document.getElementById('dias_Caminar').value;
    var tiempo_Caminar = document.getElementById('tiempo_Caminar').value;
    var estatura = document.getElementById('estaturaIMC').value;
    var peso = document.getElementById('pesoIMC').value;

    if (dias_Int, dias_Caminar, dias_Mode, tiempo_Caminar, tiempo_Int, tiempo_Mode, estatura, peso == 0) {
        alertify.alert('Disculpa', 'Contesta todo los campos para saber tu resultado', function(){ alertify.success('Introduce todos tus datos correctamente'); });
        return false;
    } else{
        if ((dias_Int > 7) || (dias_Mode > 7) || (dias_Caminar > 7)) {
            alertify.alert('Disculpa', 'Datos que colocaste en alguno de los Campos "dias" es invalido. Debes ser de 0 a 7 dias.', function(){ alertify.success('Introduce tus datos correctamente'); });
            return false;
        } else if ((tiempo_Int > 600) || (tiempo_Mode > 600) || (tiempo_Caminar > 600)) {
            alertify.alert('Disculpa', 'Datos que colocaste en alguno de los Campos "tiempo" es invalido. Debe ser de 0 a 600 minutos.', function(){ alertify.success('Introduce tus datos correctamente'); });
            return false;
        } else if (estatura > 200 || (estatura < 60)) {
            alertify.alert('Disculpa', 'El rango de estatura de un ser humano es de 60 a 200 cm. Indiques la estatura dentro de este rango.', function(){ alertify.success('Introduce tus datos correctamente'); });
            return false;
        } else if (peso > 300 || (peso < 3)) {
            alertify.alert('Disculpa', 'El rango de peso de un ser humano tomado en este test es de 3 a 300 kilos. Indica el peso dentro de este rango.', function(){ alertify.success('Introduce tus datos correctamente'); });
            return false;
        }
    }
    //Valores en Mets para cada actividad
    var Caminar = 3.3;
    var ActMode = 4;
    var ActInte = 8;

    var MetsCaminar = Caminar * tiempo_Caminar * dias_Caminar;
    var MetsModerada = ActMode * tiempo_Mode * dias_Mode;
    var MetsIntensa = ActInte * tiempo_Int * dias_Int;

    var Total = MetsCaminar + MetsIntensa + MetsModerada;

    var catego1, catego2, catego3 = "";

    /*
    console.log(MetsCaminar);
    console.log(MetsModerada);
    console.log(MetsIntensa);
    console.log(Total);
    
    if ((MetsIntensa == null) || (MetsIntensa == null) || (MetsModerada == null) || (Total == null)) {
        alert("Asegurate de que los CAMPOS de las Secciones de Actividades esten LLENOS");
        return false;
        //document.getElementById("actividad").innerHTML = "";
        //document.getElementById("result").innerHTML = "";
        
    } */
    
    if ((MetsCaminar <= 0) || (MetsIntensa <= 0) || (MetsModerada <= 0)) {
        alertify.alert('Disculpa', 'Asegurate de que los CAMPOS de las Secciones de Actividades esten LLENOS o que los datos que colocaste sean coherentes', function(){ alertify.success('Introduce todos tus datos correctamente'); });
        return false;
    } else {
        if ((MetsIntensa >= 480 && MetsIntensa < 1500) || (MetsModerada >= 600)) {
                catego2 = "Nivel de Actividad Fisica: Moderado";
                document.getElementById("actividad").innerHTML = "<br><h2>Resultados</h2><br><h3>"+catego2+"</h3><br><p>Total de Actividad Fisica: "+Total+" METS-minuto por semana</p><br>";
        } if (MetsIntensa >= 1500 || Total >= 3000) {
            catego3 = "Nivel de Actividad Fisica: Alto";
            document.getElementById("actividad").innerHTML = "<br><h2>Resultados</h2><br><h3>"+catego3+"</h3><br><p>Total de Actividad Fisica: "+Total+" METS-minuto por semana</p><br>";
        } if (Total < 600 && Total > 0) {
            catego1 = "Nivel de Actividad Fisica: Bajo";
            document.getElementById("actividad").innerHTML = "<br><h2>Resultados</h2><br><h3>"+catego1+"</h3><br><p>Total de Actividad Fisica: "+Total+" METS-minuto por semana</p><br>";
        } 
    }
    

    var imc = 0;
    var resultIMC = "";
    var tipoIMC = 0;
    var estaturaMetros = estatura / 100;

    imc =  peso / (estaturaMetros * estaturaMetros);
    var imcRedondear = imc.toFixed(2);

    if (imcRedondear <= 0) {
        alertify.alert('Disculpa', 'IMC Invalido. Los datos que colocaste en los campos son incoherentes', function(){ alertify.success('Introduce tu IMC Correcto'); });
        return false;
    } else if (imcRedondear < 16) {
        resultIMC = "Delgadez Extrema";
        tipoIMC = 1;
    } else if (imcRedondear >= 16 && imcRedondear < 17) {
        resultIMC = "Delgadez Moderada";
        tipoIMC = 2;
    } else if (imcRedondear >= 17 && imcRedondear < 18.5) {
        resultIMC = "Delgadez Ligera";
        tipoIMC = 3;
    } else if (imcRedondear >= 18.5 && imcRedondear < 25) {
        resultIMC = "Normal";
        tipoIMC = 4;
    } else if (imcRedondear >= 25 && imcRedondear < 30) {
        resultIMC = "Sobrepeso";
        tipoIMC = 5;
    } else if (imcRedondear >= 30 && imcRedondear < 35) {
        resultIMC = "Obesidad Ligera o Tipo 1";
        tipoIMC = 6;
    } else if (imcRedondear >= 35 && imcRedondear < 40) {
        resultIMC = "Obesidad Moderada o Tipo 2";
        tipoIMC = 7;
    } else if (imcRedondear >= 40) {
        resultIMC = "Obesidad Severa o Tipo 3";
        tipoIMC = 8;
    } else if (imcRedondear > 75) {
        alertify.alert('Disculpa', 'IMC Invalido. Los datos que colocaste en los campos son incoherentes', function(){ alertify.success('Introduce tu peso y estatura correctamente'); });
        return false;
    } else if (isNaN(imcRedondear)) {
        alertify.alert('Disculpa', 'Asegurate de que TODOS los CAMPOS esten LLENOS', function(){ alertify.success('Introduce todos los datos'); });
        return false;
    }

    document.getElementById("indice").innerHTML = "<br><h3>Indice de Masa Corporal: "+imcRedondear+"</h3><br><h3>Rango: "+resultIMC+"</h3><br>";

    switch (tipoIMC) {
        case 1:
            document.getElementById("final").innerHTML = '<h3>Alta Probabilidad de padecer un Transtorno Alimenticio</h3><br>'+
            '<p>El tener un Indice de Masa Corporal muy por debajo del nivel normal puede ser una consecuencia de padecer Anorexia. '+
            'Te invitamos a que realices nuestro test Anorexia vs Bulimia para que sepas si es problable de que puedas tener alguno de los dos tratornos.</p>'+
            '<br><br><a href="testUsuario.jsp"><input type="button" class="boton_test" value="Ir al Test"></a><br><br>';
            break;
        case 2:
            document.getElementById("final").innerHTML = '<h3>Probabilidad de padecer un Transtorno Alimenticio</h3><br>'+
            '<p>El tener un Indice de Masa Corporal debajo del nivel normal puede ser una consecuencia de padecer una posible Anorexia. '+
            'Te invitamos a que realices nuestro test Anorexia vs Bulimia para que sepas si es problable de que puedas tener alguno de los dos tratornos.</p>'+
            '<br><br><a href="testUsuario.jsp"><input type="button" class="boton_test" value="Ir al Test"></a><br><br>';
            break;
        case 3:
            document.getElementById("final").innerHTML = '<h3>Baja Probabilidad de padecer un Transtorno Alimenticio</h3><br>'+
            '<p>El tener un Indice de Masa Corporal debajo o cerca del limite minimo del nivel normal puede ser un indicio de tener un posible trastorno alimenticio. '+
            'Si quieres saber si puedes padecer o estar cerca de padecer algun trastorno, te invitamos a que realices nuestro test Anorexia vs Bulimia.</p>'+
            '<br><br><a href="testUsuario.jsp"><input type="button" class="boton_test" value="Ir al Test"></a><br><br>';
            break;
        case 4:
            if (catego1 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Muy bien! Estas en el nivel normal de IMC</h3><br>'+
                '<p>Estas dentro del rango normal del Indice de Masa Corporal, e indica que tu cuerpo es saludable. Sin embargo, tu nivel de actividad fisica es bajo, por lo que puedes , '+
                'tener un comportamiento de algun trastorno alimenticio. Si quieres estar mas seguro, puedes realizar nuestro test Anorexia vs Bulimia.</p>'+
                '<br><br><a href="testUsuario.jsp"><input type="button" class="boton_test" value="Ir al Test"></a><br><br>';
            } if (catego2 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Muy bien! Estas en el nivel normal de IMC</h3><br>'+
                '<p>Estas dentro del rango normal del Indice de Masa Corporal, e indica que tu cuerpo es saludable. Aunque tu nivel de actividad fisica moderado, tendras que seguir realizar con mayor frecuencia estas actividades. '+
                'Si quieres saber si tienes un comportamiento hacia un trastorno alimenticio, puedes realizar nuestro test Anorexia vs Bulimia.</p>'+
                '<br><br><a href="testUsuario.jsp"><input type="button" class="boton_test" value="Ir al Test"></a><br><br>';               
            } if (catego3 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Felicidades! Gozas de una buena salud</h3><br>'+
                '<p>Estas dentro del rango normal del Indice de Masa Corporal, e indica que tu cuerpo es saludable. Tu nivel de actividad fisica es Alto, significa que llevas buenos habitos de salud y buen regimen alimenticio. '+
                'Aqui puedes encontrar recetas saludables que puedan contribuir a seguir con una buena alimenticion.</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir al Inicio"></a><br><br>';      
            }
            break;    
        case 5:
            if (catego1 = true) {
                document.getElementById("final").innerHTML = '<h3>Estas arriba del limite maximo del rango de normalidad</h3><br>'+
                '<p>Tienes un Indice de Masa Corporal ligeramente encima del limite maximo del nivel normal, indicando que tu cuerpo pueda padecer sobrepeso. Y al tener un nivel de actividad fisica bajo, indica que eres una persona un poco sedentaria. '+
                'Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a><br><br>';      
            } if (catego2 = true) {
                document.getElementById("final").innerHTML = '<h3>Estas arriba del limite maximo del rango de normalidad</h3><br>'+
                '<p>Tienes un Indice de Masa Corporal ligeramente encima del limite maximo del nivel normal, indicando que tu cuerpo pueda padecer sobrepeso. Tienes un nivel de actividad fisica moderado, esto indica que eres una persona que realiza ejercicio fisico, pero tal vez tu habito de alimentacion no te ayuda a estar en el rango normal. '+
                'Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a><br><br>';    
            } if (catego3 = true) {
                document.getElementById("final").innerHTML = '<h3>Estas arriba del limite maximo del rango de normalidad</h3><br>'+
                '<p>Tienes un Indice de Masa Corporal ligeramente encima del limite maximo del nivel normal, indicando que tu cuerpo pueda padecer sobrepeso. Tun nivel de actividad fisica alto, por lo que estas en una etapa en donde quieres tener una vida saludable. Sigue asi y pronto llegaras a tu meta. '+
                'Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a><br><br>';       
            }
            break;
        case 6:
            if (catego1 = true) {
                document.getElementById("final").innerHTML = '<h3>Cuidado. Estas es un rango de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 1, indicando que no llevas un vida saludable. Tambien tu nivel de actividad fisica es bajo, por lo que indica que eres una persona sedentaria '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un plan nutricional que te ayude a llevar una vida saludable. Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';       
            } if (catego2 = true) {
                document.getElementById("final").innerHTML = '<h3>Cuidado. Estas es un rango de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 1, indicando que no llevas un vida saludable. Aunque tu nivel de actividad fisica es moderado, posiblemente no llevas una alimentacion adecuada. '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un plan nutricional que te ayude a llevar una vida saludable. Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';      
            } if (catego3 = true) {
                document.getElementById("final").innerHTML = '<h3>Cuidado. Estas es un rango de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 1, indicando que no llevas un vida saludable. Sin embargo, el test arroja que tu actividad fisica es alta, tal vez este llevando un regimen de salud para poder bajar de peso, y llevar una buena alimentacion te ayudara a lograr tu objetivo. '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un plan nutricional que te ayude a llevar una vida saludable. Te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a tener una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';       
            }
            break;
        case 7:
            if (catego1 = true) {
                document.getElementById("final").innerHTML = '<h3>Precuacion. Tu IMC indica un estado de obesidad moderada</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 2 o moderada. Te encuentras en un rango alto de IMC, y arriba del rango saludable. Tu nivel de actividad fisica es bajo, lo que significa que eres una persona sedentaria, y puede ser que padezcas o seas propenso a padecer una enfermedad cronica a corto y mediana plazo. '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un plan nutricional que te ayude a llevar una vida saludable. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';      
            } if (catego2 = true) {
                document.getElementById("final").innerHTML = '<h3>Precuacion. Tu IMC indica un estado de obesidad moderada</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 2 o moderada. Te encuentras en un rango alto de IMC, y arriba del rango saludable. Tu nivel de actividad fisica es moderado, lo que significa que eres una persona poco sedentaria, y tal vez sea necesario aumentar tu tiempo de dedicacion al ejercicio, te ayuda a prevenir que padezcas una enfermedad cronica a mediano plazo. '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un mejor plan nutricional que te ayude a llevar una vida saludable. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';     
            } if (catego3 = true) {
                document.getElementById("final").innerHTML = '<h3>Precuacion. Tu IMC indica un estado de obesidad moderada</h3><br>'+
                '<p>Tu Indice de Masa Corporal esta en el rango de obesidad tipo 2 o moderada. Te encuentras en un rango alto de IMC, y arriba del rango saludable. Aunque tu nivel de actividad fisica es alto, tu forma de alimentacion tal vez no sea la adecuada o este empezando un regimen de habitos saludables. '+
                'Te recomendamos que visites a un nutriologo que te ayude a establecer un mejor plan nutricional que te ayude a contribuir a llegar a este objetivo. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';      
            }
            break;
        case 8:
            if (catego1 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Alerta!. Te enuentras en el rango mas alto de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal indica que estas en un rango de obesidad tipo 3 o severa. Eres una persona muy sedentaria porque el test arroja que tu nivel de actividad fisica es bajo, por lo que puedes padecer de una enfermedad cronica a corto plazo o tengas serios problemas de salud. '+
                'Es urgente que vayas con un nutriologo para construir un plan nutricional que te ayude a llegar una buena alimentacion y una vida saludable. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';      
            } if (catego2 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Alerta!. Te enuentras en el rango mas alto de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal indica que estas en un rango de obesidad tipo 3 o severa. Eres una persona sedentaria, ya que el test arroja que tu nivel de actividad fisica es moderado, posiblemente le dediques algo tiempo al ejercicio pero no lo suficiente; esto te va a llevar por lo que puedes padecer de una enfermedad cronica a corto plazo o tengas serios problemas de salud. '+
                'Es urgente que vayas con un nutriologo para construir un plan nutricional y hablar con un entrenador personal que ten ayude a realizar una rutina deportiva, para que te ayude a llegar una buena alimentacion y una vida saludable. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';        
            } if (catego3 = true) {
                document.getElementById("final").innerHTML = '<h3>¡Alerta!. Te enuentras en el rango mas alto de obesidad</h3><br>'+
                '<p>Tu Indice de Masa Corporal indica que estas en un rango de obesidad tipo 3 o severa. Aunque tu nivel de actividad fisica es alto, es posible tu rutina y/o tu regimen alimenticio no sea el adecuado. Necesitas informarte mejor o hacer un poco mas de esfuerzo en tus actividades. '+
                'Necesitarias ir con un nutriologo para construir un plan nutricional que te ayude a llegar una buena alimentacion y una vida saludable. Al mismo tiempo, te invitamos a que revises algunas de nuestras recetas que puedan ayudarte a llevar una buena alimentacion</p>'+
                '<br><br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>'+
                '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';        
            }
            break;
        default:
            alertify.alert('Disculpa', 'Error en los datos ingresados. Asegurate que TODOS los campos estes LLENOS', function(){ alertify.success('Introduce todos tus datos correctamente'); });
            return false;
    }

}

function allowDrop(ev) {
  ev.preventDefault();
}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  ev.target.appendChild(document.getElementById(data));
}

