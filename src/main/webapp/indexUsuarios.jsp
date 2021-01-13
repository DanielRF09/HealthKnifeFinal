<%-- 
    Document   : indexUsuarios
    Created on : 31/12/2020, 02:22:01 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloslogin.css">
        <link rel="stylesheet" href="css/responsivo.css">
        <title>Inicio</title>
    </head>
    <body>
        <%
            HttpSession sesionOk = request.getSession();
            Usuario us = null;
            if (sesionOk.getAttribute("usuario") == null) {
        %>
        <jsp:forward page="login.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
        <%
            } else {
                us = (Usuario) sesionOk.getAttribute("usuario");
                
            }
        %>
        
        <header>
            <div class="contenedor">

                <nav class="menu">
                    <div class="contlogo">
                        <a href="indexUsuarios.jsp" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
                    </div>
                    <div class="contbotones">
                        <a href="indexUsuarios.jsp" class="nose" class="btn_articulos" style="font-size:15px;">Inicio</a>
                        <a href="ControladorBlog?accion=listarUsuarios" class="nose" class="btn_nosotros" style="font-size:15px;">Blog</a>
                        <a href="BusquedaRecetasUsuario.jsp"  class="nose" class="btn_contacto" style="font-size:15px;">Buscar</a>
                        <a href="ControladorReceta?accion=listarindexUsuario"  class="nose" class="btn_contacto" style="font-size:15px;">Recetas</a>
                        <a href="testUsuario.jsp"  class="nose" class="btn_contacto" style="font-size:15px;">Test</a>
                        <a href="testSedentarismo.jsp"  class="nose" class="btn_contacto" style="font-size:15px;">Test Sedentarismo</a>
                        <a href="https://healtknifechat.herokuapp.com/"  class="nose" class="btn_contacto" style="font-size:15px;">Chat</a>
                        <a href="ControladorCRecetas?accion=recetasGuardadas&idUsuario=<%=us.getIdUsuario()%>" class="btn_carrito"></a>				
                        <a href="cerrarSesion.jsp"  class="nose" class="btn_nosostros" style="font-size:15px;">Cerrar Sesion</a>
                    </div>

                </nav>

                <div class="textos">
                    <h1 class="nombre">HealthKnife Bienvenido <%=us.getNombreUsuario()%>
                    </h1>
                    
                    <br>
                    <br>
                    <div class="container">
                        <div class="webflow-style-input">
                            <a href="BusquedaRecetasUsuario.jsp" class="boton">Encontrar Recetas</a>

                        </div>
                    </div>		  
                </div>
            </div>
        </header>
                    
                    
        <section class="main">
            <section class="acerca-de" id="acerca-de">
                <h3>¿Quienes somos?</h3>
                <br>
                <p>Nosotros somos una empresa dedicada a la ayuda de personas con problemas alimienticios</p>

            </section>
            <section class="fotos">
                <div class="contenedorf">
                    <div class="fotosf">
                        <div class="fotoscomida1"></div>
                        <div class="fotoscomida2"></div>
                        <div class="fotoscomida3"></div>
                    </div>
                    <div class="conttextof">
                        <h2>ENCUENTRA LO QUE NECESITAS</h2>
                        <p>En brace black encontraras recetas ideales para tu condición y así fortalecer tu cuerpo día a día </p>
                    </div>
                </div>
            </section>
            <section class="info">
                <div class="contenedorf2">
                    <div class="conttextof2">
                        <h2>SALUDABLES Y NUTRITIVAS</h2>
                        <p>En HealthKnife encontraras recetas revisadas por nutriologos expertos, los cu</p>
                    </div>

                    <div class="fotosf2">
                        <div class="fotoscomidaf2"></div>
                    </div>

                </div>
            </section>



        </section>

        <footer class="footer">
            <section class="foot">
                <div class="terms">
                    <a href="terminoscondiciones.jsp">Terminos y condiciones</a>
                    <br>
                    <a href="avisoprivacidad.jsp">Politica de privacidad</a>
                </div>
                <div class="redes">
                    <div class="iconall">
                        <a href="https://www.facebook.com/HealthKnife-106283358102505"><img class="icons" src="img/facebook.png" alt=""></a>
                        <a href="https://www.instagram.com/healthknife_i/"><img class="icons" src="img/instagram.png" alt=""></a>
                    </div>
                </div>
            </section>
        </footer>
        <script src="js/jquery.min.js"></script>

    </body>
</html>
