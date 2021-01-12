<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Receta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RecetaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/estiloslistarecetas.css">
	
	<title>Recetas</title>
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
        
        <section class="main">
		<br>
		<br>
		<h2>Estas son las Recetas Disponibles</h2>
		<br>
		<br>
		<hr>
		<br>
		<br>
		
			<ul>
                            <%
                                RecetaDAO dao = new RecetaDAO();
                                List<Receta>list_index = dao.listarindexPrincipal();
                                Iterator<Receta>iter = list_index.iterator();
                                Receta rec = null;
                                while(iter.hasNext()){

                                    rec = iter.next();

                            %>
                            
				<li class="receta">
                                    <div class="contreceta">
                                            <div class="imgreceta"><img class="imgrecet" src="<%= rec.getImgReceta()%>" alt="<%= rec.getNombreReceta()%> "></div>
                                            <div class="descripcionreceta">
                                                    <div class="conttitulo">
                                                            <h3 class="titulo"><%= rec.getNombreReceta()%></h3>
                                                            <input type="hidden" name="idReceta" value="<%= rec.getIdReceta() %>">
                                                    </div>
                                                    <div class="contdescr">							
                                                            <p class="descr"><%= rec.getDescripcion() %> </p>
                                                    </div>

                                            </div>
                                            <div class="contenlacereceta"><a href="ControladorReceta?accion=listrecetaPrincipal&idReceta=<%= rec.getIdReceta()%>" class="enlacereceta">Ir</a></div>
                                    </div>
                                </li>
                                
                                <%}%>
				
			</ul>
		
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
