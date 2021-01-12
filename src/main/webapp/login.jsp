<%-- 
    Document   : login
    Created on : 31/12/2020, 01:25:13 AM
    Author     : Daniel
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
        
        <script>
            window.onload = byeGoogle;
//            window.onload = cerrarGoogle;
            function byeGoogle() {
                document.getElementById("google").hidden = true;
            }
            function cerrarGoogle() {
                console.log("Hola mundo");
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
            }
//            window.onload() = byeGoogle;
        </script>

        <title>Login</title>
    </head>
    <body>
        <header>
            <div class="contenedor">
			
                <nav class="menu">
                        <div class="contlogo">
                                <a href="ControladorReceta?accion=listarindexPrincipal" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
                        </div>
                        <div class="contbotones">
                                <a href="index.jsp" class="nose" class="btn_articulos">Inicio</a>
                                <a href="BusquedaRecetas.jsp"  class="nose" class="btn_contacto">Buscar Receta</a>
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
        
        
        <script type="text/javascript">

            function onSignIn(googleUser) {
//                 window.location.href='success.jsp';
                var profile = googleUser.getBasicProfile();
                var imagurl = profile.getImageUrl();
                var name = profile.getGivenName();
                var email = profile.getEmail();
                document.getElementById("google").hidden = false;
                document.getElementById("registro").hidden = true;
                document.getElementById("registro2").hidden = true;// "iniciar sesion con google" en el primer formulario


                document.google.emailGoogle.value = email;
                document.google.tipo.value = "3";


                document.getElementById("myImg").src = imagurl;
                document.getElementById("name").innerHTML = name;
                document.getElementById("correo").innerHTML = email;
                document.getElementById("myP").style.visibility = "hidden";
//                document.getElementById("status").innerHTML = 'Welcome ' + name + '!<a href=success.jsp?email = ' + email + ' & name = ' + name + ' > Continue with Google login </a>'
            }
        </script>   


        <script>

        </script>
        
        
        <section class="main" >
            <div class="contenedorform" id="main">
                <div class="login" id="login">
                    <form action="Verificar" id="registro12">
                        <h2>Iniciar Sesión</h2>
                        <div class="inputs" >
                            <label for="inplog">E mail</label>
                            <input required="" type="text" class="inplog1" name="email" maxlength="100">
                            <label for="inplog2">Contraseña</label>
                            <input required="" minlength="4" maxlength="25" type="password" class="inplog2" name="password">
                            <div class="scentrado">
                                <input type="hidden" value="1" name="tipo">
                                <input type="submit" onclick="cerrarGoogle()" class="submit" name="submit">
                            </div>
                        </div>
                    </form>
                    <br><br><br><br>

                    <h2 id="registro2">Iniciar sesion con google</h2>
                    <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                </div>




                <div class="registrarse" id="registrarse">
                    <div class="status" id="status">
                    </div>

                    <div class="google" id="google" hi>
                        <h2>Bienvenido</h2>
                        <img id="myImg" class="" src="">
                        <br><br><br>
                        <h3 id="name"></h3>
                        <br>
                        <h3 id="correo"></h3>
                        <br>

                        <form name="google" action="Verificar">
                            <div class="inputs">
                                <input required="" type="hidden" class="inplog7" name="emailGoogle" id="emailG" readonly="false" placeholder="Ingresa un correo electronico">
                                <input type="hidden" value="3" name="tipo">
                            </div>
                            <input type="submit" class="submit" name="google1" id="elprimo" value="Continuar con Google">
                        </form>
                        <br>
                        <button class="submit" onclick="cerrarGoogle()">Cancelar</button>

                    </div>

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
                            <input  value="" required="" type="text" class="inplog3" name="userName" id="userName" placeholder="Ingresa tu UserName">
                            <div class="alinear">
                                <div class="noseya">
                                    <label for="inplog4">Nombre</label>
                                    <input required="" type="text" class="inplog4" name="nombre" id="nombre" placeholder="Ingresa tu nombre">
                                </div>
                                <div class="noseya">
                                    <label for="inplog5">Apellido Paterno</label>
                                    <input required="" type="text" class="inplog5" name="appat" id="appat" placeholder="Ingresa tu Apellido Paterno">
                                </div>
                                <div class="noseya">
                                    <label for="inplog6">Apellido Materno</label>
                                    <input required="" type="text" class="inplog6" name="apmat" id="apmat" placeholder="Ingresa tu Apellido Materno (Opcional)">
                                </div>
                            </div>
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
                            <label for="inplog7">E-mail</label>
                            <input required="" type="email" class="inplog7" name="email" id="email" placeholder="Ingresa un correo electronico">
                            <label for="inplog8">Contraseña</label>
                            <input required="" minlength="8" maxlength="16" type="password" class="inplog8" name="password" id="password" placeholder="Ingresa una contraseña">
                            <input type="hidden" value="2" name="tipo">
                            <div class="scentrado">
                                <input type="submit" class="submit" name="submit">
                            </div>
                            <br>
                            <p>Después de Registrarte Inicia Sesión, porfavor</p>
                        </div>


                    </form>
                </div>
            </div>
        </section>
        <footer class="footer">
            <section>
                <p>.</p>
            </section>
        </footer>
        
        <script src="js/jquery.min.js"></script>
        
        <script>
        
        /*function alertyrecarga(){
        	
        	var user= document.getElementById("userName").value;
        	var nombre = document.getElementById("nombre").value;
        	var appat = document.getElementById("appat").value;
        	var apmat = document.getElementById("apmat").value;
        	var correo = document.getElementById("email").value;
        	var password = document.getElementById("password").value;
        	
        	if (user == "" || nombre == "" || appat == "" || apmat == "" || correo == "" || password == "") {
        	      alert("Debes compeltar TODOS campos"); 
        	} else {
        		alert('Ya te registraste, ahora inicia sesión porfavor');
        		
        	
        	}
        }*/
        
        </script>
    </body>
</html>
