<%-- 
    Document   : BlogUsuarios
    Created on : 7/01/2021, 02:05:37 AM
    Author     : Daniel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Blog"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.BlogDAO"%>
<%@page import="Modelo.Usuario"%>
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
		<section class="foot">
			<div class="terms">
				<a href="terminoscondiciones.jsp">Términos y condiciones</a>
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
