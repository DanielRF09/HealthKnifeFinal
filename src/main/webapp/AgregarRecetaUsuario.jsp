<%-- 
    Document   : AgregarRecetaUsuario
    Created on : 28/12/2020, 11:02:41 PM
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
		<link rel="stylesheet" href="css/estilospaginaerrores.css">
        <title>Receta Agregada</title>
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
        

        
        <section class="main">
			<br>
			<br>
			<h2>EXCELENTE</h2>

		<div class="Parrafo" style="width:300px; margin-left:auto; margin-right:auto; color:white;">
		  <p style="font-size: 20px;">La receta se guardo con éxito</p> 
		  <br>
		  <br>
		   <a href="indexUsuarios.jsp">Regresar al inicio</a>
		  <br>
		  <br>
		  <br>
		  
		</div>
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
    </body>
</html>
