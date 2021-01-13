<%-- 
    Document   : indexNutriologo
    Created on : 31/12/2020, 06:55:41 PM
    Author     : Daniel
--%>

<%@page import="Modelo.Nutriologo"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Receta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RecetaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloslistarecetas.css">
        <title>Página de Nutriologo</title>
    </head>
    </head>
    <body>
        
        <%
            HttpSession sesionOk = request.getSession();
            Nutriologo nu = null;
            if (sesionOk.getAttribute("usuario") == null) {
        %>
        <jsp:forward page="login.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
        <%
            } else {
                nu = (Nutriologo) sesionOk.getAttribute("usuario");
                
            }
        %>
        
        <header>
            <div class="contenedor">
			
					<nav class="menu">
                        <div class="contlogo">
                            <a href="indexNutriologo.jsp" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
                        </div>
                        <div class="contbotones">
                            <a href="indexNutriologo.jsp" class="nose" class="btn_articulos">Inicio</a>
                            <a href="BusquedaRecetasNutriologo.jsp"  class="nose" class="btn_contacto">Buscar Receta</a>
                            <a href="ControladorReceta?accion=listarindexNutriologo"  class="nose" class="btn_contacto">Recetas</a>
                            <a href="ControladorBlog?accion=listarNutriologos" class="nose" class="btn_nosotros">Blog</a>
                            <a href="https://healtknifechat.herokuapp.com/" class="nose" class="btn_nosotros">Chat</a>
                            
                            				
                            <a href="cerrarSesion.jsp"  class="nose" class="btn_nosostros">Cerrar Sesion</a>
                        </div>

                    </nav>
			
		<div class="textos">
                    <br>
                    <br>
                    <h1 class="nombre">HealthKnife Bienvenido <%= nu.getNombreNutriologo() %>
                    </h1>
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
                    List<Receta>list_index = dao.listarindexNutriologo();
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
				<div class="contenlacereceta">
					<a href="ControladorReceta?accion=listrecetaNutriologo&idReceta=<%= rec.getIdReceta()%>" class="enlacereceta">Ir</a>
					<a href="ControladorReceta?accion=editar_nut&idReceta=<%= rec.getIdReceta()%>" class="enlacereceta">Editar</a>
				</div>

			</div>
		</li>
                
                <%}%>
		
            </ul>
		
	</section>

	<footer class="footer">
		<section class="foot">
                <div class="terms">
                    <a href="terminoscondicionessinUser.jsp">Terminos y condiciones</a>
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
