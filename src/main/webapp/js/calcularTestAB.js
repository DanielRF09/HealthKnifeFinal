function checarSelecciones(){
    var pp1, pp2, pp3, pp4, pp5, pp6, pp7, pp8, pp9, pp10, pp11, pp12, pp13, pp14, pp15, pp16, pp17, pp18, pp19, pp20 = "";
    var res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13, res14, res15, res16, res17, res18, res19, res20 = 0;

    var radio_p1 = document.getElementsByName("pregunta_1");   
    for (var i = 0; i < radio_p1.length; i++) {
        if (radio_p1[i].checked == true) {
            pp1 = radio_p1[i].value;
            res1 = parseFloat(pp1);
        }
    }

    var radio_p2 = document.getElementsByName("pregunta_2");  
    for (var i = 0; i < radio_p2.length; i++) {
        if (radio_p2[i].checked == true) {
            pp2 = radio_p2[i].value;
            res2 = parseFloat(pp2);
        }
    }

    var radio_p3 = document.getElementsByName("pregunta_3");
    for (var i = 0; i < radio_p3.length; i++) {
        if (radio_p3[i].checked == true) {
            pp3 = radio_p3[i].value;
            res3 = parseFloat(pp3);
        }
    }

    var radio_p4 = document.getElementsByName("pregunta_4");   
    for (var i = 0; i < radio_p4.length; i++) {
        if (radio_p4[i].checked == true) {
            pp4 = radio_p4[i].value;
            res4 = parseFloat(pp4);
        }
    }

    var radio_p5 = document.getElementsByName("pregunta_5");  
    for (var i = 0; i < radio_p5.length; i++) {
        if (radio_p5[i].checked == true) {
            pp5 = radio_p5[i].value;
            res5 = parseFloat(pp5);
        }
    }

    var radio_p6 = document.getElementsByName("pregunta_6");  
    for (var i = 0; i < radio_p6.length; i++) {
        if (radio_p6[i].checked == true) {
            pp6 = radio_p6[i].value;
            res6 = parseFloat(pp6);
        }
    }

    var radio_p7 = document.getElementsByName("pregunta_7");   
    for (var i = 0; i < radio_p7.length; i++) {
        if (radio_p7[i].checked == true) {
            pp7 = radio_p7[i].value;
            res7 = parseFloat(pp7);
        }
    }

    var radio_p8 = document.getElementsByName("pregunta_8");
    for (var i = 0; i < radio_p8.length; i++) {
        if (radio_p8[i].checked == true) {
            pp8 = radio_p8[i].value;
            res8 = parseFloat(pp8);
        }
    }

    var radio_p9 = document.getElementsByName("pregunta_9"); 
    for (var i = 0; i < radio_p9.length; i++) {
        if (radio_p9[i].checked == true) {
            pp9 = radio_p9[i].value;
            res9 = parseFloat(pp9);
        }
    }

    var radio_p10 = document.getElementsByName("pregunta_10");
    for (var i = 0; i < radio_p10.length; i++) {
        if (radio_p10[i].checked == true) {
            pp10 = radio_p10[i].value;
            res10 = parseFloat(pp10);
        }
    }

    var radio_p11 = document.getElementsByName("pregunta_11");    
    for (var i = 0; i < radio_p11.length; i++) {
        if (radio_p11[i].checked == true) {
            pp11 = radio_p11[i].value;
            res11 = parseFloat(pp11);
        }
    }

    var radio_p12 = document.getElementsByName("pregunta_12");  
    for (var i = 0; i < radio_p12.length; i++) {
        if (radio_p12[i].checked == true) {
            pp12 = radio_p12[i].value;
            res12 = parseFloat(pp12);
        }
    }

    var radio_p13 = document.getElementsByName("pregunta_13");    
    for (var i = 0; i < radio_p13.length; i++) {
        if (radio_p13[i].checked == true) {
            pp13 = radio_p13[i].value;
            res13 = parseFloat(pp13);
        }
    }

    var radio_p14 = document.getElementsByName("pregunta_14");   
    for (var i = 0; i < radio_p14.length; i++) {
        if (radio_p14[i].checked == true) {
            pp14 = radio_p14[i].value;
            res14 = parseFloat(pp14);
        }
    }

    var radio_p15 = document.getElementsByName("pregunta_15");
    for (var i = 0; i < radio_p15.length; i++) {
        if (radio_p15[i].checked == true) {
            pp15 = radio_p15[i].value;
            res15 = parseFloat(pp15);
        }
    }

    var radio_p16 = document.getElementsByName("pregunta_16");  
    for (var i = 0; i < radio_p16.length; i++) {
        if (radio_p16[i].checked == true) {
            pp16 = radio_p16[i].value;
            res16 = parseFloat(pp16);
        }
    }

    var radio_p17 = document.getElementsByName("pregunta_17");   
    for (var i = 0; i < radio_p17.length; i++) {
        if (radio_p17[i].checked == true) {
            pp17 = radio_p17[i].value;
            res17 = parseFloat(pp17);
        }
    }

    var radio_p18 = document.getElementsByName("pregunta_18");  
    for (var i = 0; i < radio_p18.length; i++) {
        if (radio_p18[i].checked == true) {
            pp18 = radio_p18[i].value;
            res18 = parseFloat(pp18);
        }
    }

    var radio_p19 = document.getElementsByName("pregunta_19");
    for (var i = 0; i < radio_p19.length; i++) {
        if (radio_p19[i].checked == true) {
            pp19 = radio_p19[i].value;
            res19 = parseFloat(pp19);
        }
    }

    var radio_p20 = document.getElementsByName("pregunta_20");   
    for (var i = 0; i < radio_p20.length; i++) {
        if (radio_p20[i].checked == true) {
            pp20 = radio_p20[i].value;
            res20 = parseFloat(pp20);
        }
    }

    var puntos_resultados = res1+res2+res3+res4+res5+res6+res7+res8+res9+res10+res11+res12+res13+res14+res15+res16+res17+res18+res19+res20;
    console.log(puntos_resultados);

    if (puntos_resultados < 22) {
        document.getElementById('result').innerHTML = '<br><h2>Llevas una vida Saludable</h2><br>'+
        '<p>Tu comportamiento alimenticio indica que eres una persona saludable. La conducta alimenticia es el indicador para saber si una persona este padeciendo algun trastorno alimenticio como la anorexia o la bulimia.'+
        'Tambien la forma en la que nos vemos al espejo y observamos nuestro cuerpo suele ser un aspecto importante para saber si tenemos un problema alimenticio. Esto indica que eres una persona que se siente bien con su cuerpo y su forma de alimentarse.'+
        '</p><br><p>Te recomendamos que veas nuestras recetas para seguir llevando ese ritmo alimeticio.</p>'
        +'<br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a><br><br>            '+
        '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';
    } else if (puntos_resultados >= 22 && puntos_resultados < 36) {
        document.getElementById('result').innerHTML = '<br><h2>Baja probabilidad de tener un comportamiento por Anorexia</h2><br>'+
        '<p>La anorexia es un trastorno alimenticio que consiste en la restricción controlada de la ingesta de alimentos, con el fin de que la persona se sienta autorrealizada o identificada con su cuerpo.'+
            'El perfil psicologico de una persona anorexica se basa en el perfeccionismo, la rigidez, la introvesion y la autoexigencia. No es conciente de su enfermedad e inclusive niega padecer del trastorno.'+
            '</p><br><p>Puedes tener mayor información con la siguente tabla: </p><br><img src="img/TablaB.jpg" width="900" height="400"><br>'+
            '<br><p>Te recomendamos que visites a un especialista en psicologia para un mejor análisis.</p>'
        +'<br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>            '+
        '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';
    } else if (puntos_resultados >= 36 && puntos_resultados < 45) {
        document.getElementById('result').innerHTML = '<br><h2>Alta probabilidad de tener un comportamiento por Anorexia</h2><br>'+
        '<p>La anorexia es un trastorno alimenticio que consiste en la restricción controlada de la ingesta de alimentos, con el fin de que la persona se sienta autorrealizada o identificada con su cuerpo.'+
            'El perfil psicologico de una persona anorexica se basa en el perfeccionismo, la rigidez, la introvesion y la autoexigencia. No es conciente de su enfermedad e inclusive niega padecer del trastorno.'+
            '</p><br><p>Puedes tener mayor información con la siguente tabla: </p><br><img src="img/TablaB.jpg" width="900" height="400"><br>'+
            '<br><p>Te recomendamos que visites a un especialista en psicologia para un mejor análisis.</p>'
        +'<br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>            '+
        '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';
    } else if (puntos_resultados >= 45 && puntos_resultados < 60) {
        document.getElementById('result').innerHTML = '<br><h2>Baja probabilidad de tener un comportamiento por en Bulimia</h2><br>'+
        '<p>La bulimia es un trastorno aimenticio que provoca a la persona el deseo de comer a gran medida e imparable (o darse un atracón), y posteriormente acaba en vomitos, ejercicio o uso de laxantes. Los atracones son provocados por la emocionalidad y compulsividad de la persona.'+
            'El objetivo de este trastorno es lograr la delgadez del cuerpo para conseguir felicidad o sentirse emocionalmente bien con su cuerpo. Aun que el enfermo tiene la conciencia de tener el trastorno, no considera la necesidad de un tratamiento.'+
            '</p><br><p>Puedes tener mayor información con la siguente tabla: </p><br><img src="img/TablaA.jpg" width="900" height="400"><br>'+
            '<br><p>Te recomendamos que visites a un especialista en psicologia para un mejor análisis.</p>'
        +'<br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>            '+
        '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';
    } else if (puntos_resultados >= 60) {
        document.getElementById('result').innerHTML = '<br><h2>Alta probabilidad de tener un comportamiento por Bulimia</h2><br>'+
        '<p>La bulimia es un trastorno aimenticio que provoca a la persona el deseo de comer a gran medida e imparable (o darse un atracón), y posteriormente acaba en vomitos, ejercicio o uso de laxantes. Los atracones son provocados por la emocionalidad y compulsividad de la persona.'+
            'El objetivo de este trastorno es lograr la delgadez del cuerpo para conseguir felicidad o sentirse emocionalmente bien con su cuerpo. Aun que el enfermo tiene la conciencia de tener el trastorno, no considera la necesidad de un tratamiento.'+
            '</p><br><p>Puedes tener mayor información con la siguente tabla: </p><br><img src="img/TablaA.jpg" width="900" height="400"><br>'+
            '<br><p>Te recomendamos que visites a un especialista en psicologia para un mejor análisis.</p>'
        +'<br><a href="indexUsuarios.jsp"><input type="button" class="boton_test" value="Ir a Inicio"></a>            '+
        '<a href="https://healtknifechat.herokuapp.com/"><input type="button" class="boton_test" value="Ir a Chat"></a><br><br>';
    } else {
        alertify.alert('Preguntas sin contestar', 'Revise que TODAS LAS PREGUNTAS ESTEN CONTESTADAS', function(){ alertify.success('Elige una opción para cada pregunta'); });
        return false;
    }
    
    return puntos_resultados;
    
}

