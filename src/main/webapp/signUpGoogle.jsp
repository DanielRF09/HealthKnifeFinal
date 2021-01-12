<%-- 
    Document   : signUpGoogle
    Created on : 1/01/2021, 10:16:34 PM
    Author     : Gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloslogin1.css">

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="912292485334-lrj6jau36uac79hr1pd3e4g2pai1kq8a.apps.googleusercontent.com">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <title>Login</title>
    </head>
    
    
    <header>
            <div class="contenedor">
			
                <nav class="menu">
                        <div class="contlogo">
                                <a href="ControladorReceta?accion=listarindexPrincipal" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
                        </div>
                        <div class="contbotones">
                                <a href="ControladorReceta?accion=listarindexPrincipal" class="nose" class="btn_articulos">Inicio</a>
                                <a href="ControladorReceta?accion=listarindexPrincipal" class="nose" class="btn_nosotros">Recetas</a>
                                <a href="#"  class="nose" class="btn_contacto">Servicios</a>
                                <a href="#"  class="nose" class="btn_nosostros">Nosotros</a>
                                <a  href="login.jsp" class="btn_login"></a>					
                        </div>
										
                </nav>
			
                <div class="textos">
				
                    <br>
                    <br>		  
                </div>
            </div>
	</header>
    <body>
        <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
        <!--<div id="unico" value="holad"></div>-->
        <% boolean ang = Boolean.parseBoolean(request.getParameter("dato"));

            System.out.println("ang = " + ang);%>
        <%
            HttpSession sesionOk = request.getSession();
            System.out.println((Boolean) sesionOk.getAttribute("usuario"));
            if ((Boolean) sesionOk.getAttribute("usuario") == false) {
        %>
        <jsp:forward page="login.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
        <%
            } else {

            }
        %>

        <script>
//            window.onload = onSignIn;
            window.onload = quedar;
            var unu = 0;

            function meQuedo() {
                var text = document.getElementById("email").value;
                console.log("askjfhdlakjhasdk")
                console.log("=" + text + "=");
                if (text == "") {
//                    location.href = "http://localhost:8080/Paulina/index_.jsp";
                }
            }
            function cerrarGoogle() {
                console.log("Hola puto mundo");
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
            }
            function xd() {
                console.log("ALO");
//                document.getElementById("myP").hidden = true;
                var v1 = 30;
                document.registro.email.value = v1;
//                console.log(xy);

            }
            function onSignIn(googleUser) {
                console.log("Automatico");
//                 window.location.href='success.jsp';
                var profile = googleUser.getBasicProfile();
                var id = profile.getId();
                var imagurl = profile.getImageUrl();
                var name = profile.getGivenName();
                var familyName = profile.getFamilyName();
                var email = profile.getEmail();
                var apellidos = String(familyName).split(" ", 3);
                console.log("apellidos =" + apellidos + "=");
                console.log('ID: ' + id);
                console.log('Full Name: ' + profile.getName());
                console.log('Given Name: ' + name);
                console.log('Family Name: ' + familyName);
                console.log('Image URL: ' + imagurl);
                console.log('Email: ' + email);
//                alert("Ingresa tu nombre de usuario");

                var tamano = name.length;
                console.log(tamano);

                document.registro.userName.value = "";
                document.registro.nombre.value = name;
                document.getElementById("nombre").readOnly = true;
                document.registro.appat.value = apellidos[0];
                document.getElementById("appat").readOnly = true;

                if (apellidos[1] == undefined) {
                    console.log("AYUDAAAA");
                    apellidos[1] = "indefinido";
                    console.log("apellidos =" + apellidos[1] + "=");
                    document.registro.apmat.value = "indefinido";
                } else {
                    document.registro.apmat.value = apellidos[1];
                }

                document.getElementById("apmat").readOnly = true;
                document.registro.email.value = email;
                document.getElementById("email").readOnly = true;
                document.registro.password.value = "Google";
                document.registro.userName.value = "";
                document.getElementById("ocultar").hidden = true;




//                document.getElementById("registro").style.visibility = "hidden";
//                document.getElementById("login").style.visibility = "hidden";
//                document.getElementById("registro2").style.visibility = "hidden";
//                document.getElementById("submit").style.visibility = "visible";


//                document.getElementById("myImg").src = imagurl;
//                document.getElementById("name").innerHTML = name;
//                document.getElementById("correo").innerHTML = email;
                document.getElementById("myP").style.visibility = "hidden";
//                document.getElementById("status").innerHTML = 'Welcome ' + name + '!<a href=success.jsp?email = ' + email + ' & name = ' + name + ' > Continue with Google login </a>'
                quedar();
            }
            function quedar() {
                console.log("Exito")
                onSignIn();
                var x = $("#email").val();
                console.log("assaass=" + x);
                console.log(x);
                if (x == "") {
                    console.log("adios");
                } else {
                    console.log("HOLA");
                }
            }
        </script>            

        <section class="main" >
            <div class="contenedorform" id="main">
                <form action="Verificar" class="reg" name="registro" id="registro">


                    <div class="stitulo" id="stitulo">
                        <div class="imgProfile">

                        </div>
                        <div class="imgProfile">
                            <h2>Registrarse</h2>

                        </div>
                    </div>
                    <div class="inputs">
                        <label for="inplog3">Nombre de usuario</label>
                        <input required="" type="text" class="inplog3" name="userName" placeholder="Ingresa un nombre de usuario unico">
                        <label for="#">Sexo</label>
                        <br>
                        <div class="grupodebotones">
                            <div class="rbot">
                                <input checked="" required="" type="radio" name="gender" value="H"><label for="Hombre">Hombre</label>
                            </div>
                            <div class="rbot">
                                <input required="" type="radio" name="gender" value="M"><label for="Mujer">Mujer</label>
                            </div>
                        </div>
                        <div class="scentrado">
                            <input type="submit" class="submit" name="submit" id="submit" value="Continuar con Google">
                        </div>
                        <div id="ocultar">
                            <div class="alinear">
                                <div class="noseya">
                                    <label for="inplog4">Nombre</label>
                                    <input required="" type="text" class="inplog4" name="nombre" id="nombre"  readonly="false" placeholder="Ingresa tu nombre">
                                </div>
                                <div class="noseya">
                                    <label for="inplog5">Apellido Paterno</label>
                                    <input required="" type="text" class="inplog5" name="appat" id="appat" readonly="false" placeholder="Ingresa tu Apellido Paterno">
                                </div>
                                <div class="noseya">
                                    <label for="inplog6">Apellido Materno</label>
                                    <input required="" type="text" class="inplog6" name="apmat" id="apmat" readonly="false" placeholder="Ingresa tu Apellido Materno (Opcional)">
                                </div>
                            </div>

                            <label for="inplog7">E-mail</label>
                            <input required="" type="email" class="inplog7" name="email" id="email" readonly="false" placeholder="Ingresa un correo electronico">
                            <label for="inplog8">Contraseña</label>
                            <input required="" type="password" class="inplog8" name="password" placeholder="Ingresa una contraseña">
                            <input type="hidden" value="4" name="tipo">
                            <div class="scentrado">
                                <!--<input type="submit" class="submit" name="submit">-->
                            </div>
                        </div>
                    </div>
                    <a href="login.jsp" class="submit">Salir</a>

                </form>
            </div>
        </section>

    </body>
</html>
