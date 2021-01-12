<%-- 
    Document   : testSedentarismo
    Created on : 7/01/2021, 02:52:44 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Test de Sedentarismo</title>
        <link rel="stylesheet" href="css/estiloTest.css">
        <script type="text/javascript" src="js/calcularTestSed.js"></script>
    </head>
    <body oncopy="return false" onpaste="return false">
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
                        <a href="#" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
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
                <div class="textos"><br><br></div>
            </div>
        </header>
                        
        <section class="main">
        <div class="instrucciones">
            <br><br>
            <h2>Test de Comportamiento Sedentario</h2>
            <br>
            <p style="width: 80%; margin: auto;">
                Objetivo: El Sedentarismo es una de las causas que provocan que las personas tengan mayor probabilidad de que 
                tengan un desorden alimenticio. La prueba se encargará saber si eres o no una persona sedentaria para 
                saber si es propenso a que desarrolle sobrepeso u obesidad.
            </p><br>
            <form action="" method="post" name="formSed">
            <table name="sedentarismo">
                <tr>
                    <td colspan="2">Actividad física Intensa</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>
                            Piense en todas las actividades intensas que ha realizado los últimos 7 días. Son todas las 
                            actividades que requieren que usted implique un esfuerzo físico intenso y provoque que su 
                            respiración sea mucho más intensa de lo normal. Ejemplo: levantar pesas, cavar, aeróbicos o 
                            ciclismo.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        1. ¿En cuántos días realizo alguna de estas actividades físicas?
                    </td>
                    <td><input type="number" name="diasI" id="dias_Intensos" min="0" max="7" pattern="[0-9]{1}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> dias</label></td>
                </tr>
                <tr>
                    <td>
                        2. Habitualmente ¿Cuánto tiempo en total dedico a una actividad física intensa en cada uno de 
                        estos días? Indique el tiempo en minutos.
                    </td>
                    <td><input type="number" name="tiempoI" id="tiempo_Intensos" min="0" max="300" pattern="[0-9]{1,3}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> minutos</label></td>
                </tr>
                <tr>
                    <td colspan="2">Actividad física Moderadas</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>
                            Piense en las actividades de modernas que ha realizado los últimos 7 días. Son aquellas 
                            actividades que hacen que su respiración sea algo intensa de lo normal. Ejemplo: cargar pesos 
                            ligeros, andar en bicicleta a una velocidad regular o jugar tenis.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        3. ¿En cuántos días realizo alguna de estas actividades físicas?
                    </td>
                    <td><input type="number" name="diasM" id="dias_Moderadas" min="0" max="7" pattern="[0-9]{1}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> dias</label></td>
                </tr>
                <tr>
                    <td>
                        4. Habitualmente ¿Cuánto tiempo en total dedico a una actividad física moderada en uno de esos 
                        días? Indique el tiempo en minutos.
                    </td>
                    <td><input type="number" name="tiempoM" id="tiempo_Moderadas" min="0" max="300" pattern="[0-9]{1,3}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> minutos</label></td>
                </tr>
                <tr>
                    <td colspan="2">Actividad física: Caminar</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>
                            Ahora piense en el tiempo que usted dedico a caminar en los últimos 7 días, ya sea para ir 
                            al trabajo, dentro de la casa, para ir a cualquier lugar o alguna caminata que realizo por 
                            deporte, recreación, ejercicio u ocio (en tiempo libre).
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        5. ¿Cuántos días de la semana camino por lo menos 10 minutos seguidos?
                    </td>
                    <td><input type="number" name="diasC" id="dias_Caminar" min="0" max="7" pattern="[0-9]{1}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> dias</label></td>
                </tr>
                <tr>
                    <td>
                        6. Habitualmente, ¿Cuánto tiempo en total se dedicó a caminar en uno de esos días? Indique el tiempo en minutos.
                    </td>
                    <td><input type="number" name="tiempoC" id="tiempo_Caminar" min="0" max="300" pattern="[0-9]{1,3}" minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> minutos</label></td>
                </tr>
                <tr>
                    <td colspan="2">Indice de Masa Corporal</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>
                            Ahora calcularemos su Índice de Masa Corporal para saber el rango en el que se encuentra. 
                            Es necesario que usted tenga conocimiento de su estatura y de su peso.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>
                        8. Indique su estatura en centímetros.
                    </td>
                    <td><input type="number" name="estIMC" id="estaturaIMC" min="100" max="250" pattern="[0-9]{1,3}\d." minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> centimetros</label></td>
                </tr>
                <tr>
                    <td>
                        9. Indique su peso en kilogramos.
                    </td>
                    <td><input type="number" name="peIMC" id="pesoIMC" min="30" max="200" pattern="[0-9]{1,3}\d." minlength="1" maxlength="1" required oninput="validarEntrada(this)" onkeypress="return validarValores(event)" ondrop="drop(event)" ondragover="allowDrop(event)"><label> kilogramos</label></td>
                </tr>
            </table>
            <br><br>
            <input class="boton_enviar" type="button" value="Enviar" onclick="calcularSedentarismo()">
        </form>
    	</div>
	    <br>
	    <div id="result" class="resultado">
	        <div id="actividad" class="resA"></div>
	        <div id="indice" class="resI"></div>
	        <div id="final" class="resF"></div>
	    </div>
    	<br><br>
	</section>

	<footer class="footer">
        <section class="foot">
            <div class="terms">
                <a href="#">Terminos y condiciones</a>
                <br>
                <a href="#">Politica de privacidad</a>
            </div>
            <div class="redes">
                <div class="iconall">
                <a href="#"><img class="icons" src="img/facebook.png" alt=""></a>
                <a href="#"><img class="icons" src="img/instagram.png" alt=""></a>
                </div>
            </div>
        </section>
	</footer>
	<script src="js/jquery.min.js"></script>  
	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
	
    </body>
    <script type="text/javascript">
	    window.onload = alertify.alert('Test de Comportamiento Sedentario<br><br>Instrucciones','Introduce los datos que te piden en cada sección del cuestionario.<br><br>'+
	    'Es importante que tengas en cuenta algunos aspectos para contestar correctamente el test:<br><br>1. No introducir guiones (-) ni punto decimal (.). Los datos tienen que ser enteros.'+
	    '<br><br>2. El rango de dias es de 0 a 7.<br><br>2. El rango de tiempo es de 0 a 600 minutos.<br><br>4. El rango de estatura es de 60 a 200 cm.<br><br>5. El rango de peso es de 3 a 300 kg.'+
	    '<br><br>Cuando termines de contestar todo el test, da click en el botón "Enviar" para saber tus resultados.<br><br>Nota: El proposito de este test es tratar de predecir si el tiempo que dedicas para realizar '+
	    'algunas actividades físicas, asi como saber tu índice de masa corporal es semejante a una persona sedentaria y/o puedes ser propenso a padecer sobrepeso u obesidad.<br>Te recomendamos visitar a un '+
	    'especialista (psicologo o nutriologo) para obtener mayor información.');
	</script>
</html>
