<%-- 
    Document   : BlogNutriologos
    Created on : 7/01/2021, 02:31:14 AM
    Author     : Daniel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Blog"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.BlogDAO"%>
<%@page import="Modelo.Nutriologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/responsivo.css">
        <link rel="stylesheet" href="css/estilosblog.css">
        <title>Blog</title>
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
                    		  
		</div>
            </div>
	</header>
                    
       <section class="main">
		<br>
		<br>
		<h2>Estos son los ultimos contenidos</h2>
		<br>
		<br>
		<hr>
		<br>
		<br>
		
			<ul>
                            <%
                                
                                BlogDAO dao = new BlogDAO();
                                List<Blog>list_index = dao.listarUsuarios();
                                Iterator<Blog>iter = list_index.iterator();
                                Blog blo = null;
                                while(iter.hasNext()){

                                    blo = iter.next();
                                    
                            %>
                            
								<li class="receta">
									<div class="contreceta">
				                                            <div class="imgreceta"><a href="#"><img class="imgrecet" src="<%= blo.getImgBlog() %>" alt=""></a></div>
										<div class="descripcionreceta">
											<div class="conttitulo">
												<h3 class="titulo"><%= blo.getTituloBlog() %></h3>
												<a href="ControladorBlog?accion=editar_nut&idBlog=<%= blo.getIdBlog()%>" class="enlacereceta">Editar</a>
											</div>
											
											<div class="contdescr">							
												<p class="descr" style="text-align: justify; text-size:12px;"><%= blo.getCuerpoBlog() %> </p>
												
											</div>
											
										
										</div>
										
									</div>
								</li>
                                
                            <%}%>
				
				
			</ul>
			
		
	</section>
	

	<footer class="footer">
	<br>
		<br>
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
