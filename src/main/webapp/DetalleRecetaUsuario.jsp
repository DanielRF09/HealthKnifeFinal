<%-- 
    Document   : DetalleRecetaUsuario
    Created on : 27/12/2020, 02:20:58 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="Modelo.Receta"%>
<%@page import="ModeloDAO.RecetaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
            
    RecetaDAO dao = new RecetaDAO();
    int idReceta= Integer.parseInt((String)request.getAttribute("idReceta"));
                
    Receta rec = (Receta)dao.listrecetaUsuario(idReceta);
    
    //UsuarioDAO daousu = new UsuarioDAO();
    //int idUsuario = Integer.parseInt((String)request.getAttribute("idUsuario"));
    
    //Usuario usu = (Usuario)daousu.list(idUsuario);
            
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/estilosrecetaplantilla.css">

	
	<title>Receta: <%= rec.getNombreReceta()%></title>
        
        <style>
            
            #submit {
                color: black;
                text-decoration: none;
                font-size:18px;
                background-color: white;
                text-decoration: none;
                border:0;
                height:28px;
                width:140px;
                
            }
            
            
            #submit:hover{
                
                color: -webkit-link;
                cursor: pointer;
                text-decoration: underline;
                
            }
        </style>
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

            <div class="info">
                <div class="contimg">
                    <img class="imgreeceta" src="<%= rec.getImgReceta()%>" alt="">
                    <input type="hidden" name="idReceta" id="idReceta" value="<%= rec.getIdReceta() %> ">
                </div>
            <div class="contdesc">
                    <div class="noset">
                        <h3 class="title"><%= rec.getNombreReceta()%></h3>
                    </div>
                    <div >
                        <p class="fontdescripcion"><%= rec.getDescripcion()%></p>
                        
                        <form method="post" action="ControladorCRecetas">
                            
                            <input type="hidden" name="idReceta" id="idReceta" value="<%= rec.getIdReceta()%>">
                            <input type="hidden" name="idUsuario" id="idUsuario" value="<%=us.getIdUsuario()%>">
                            
                            
                            <input type="submit" id="submit" name="accion" value="Agregar">
                            
                            
                            
                        </form>
                        
                    </div> 
				
            </div>
            </div>
			
		
	</section>
        
        
         <div class="caracteris">
		<div class="contenedordeproces">
			<div class="listingredientes">
				<h2>Ingredientes</h2>
				<ul>
					<li class="contlista">
						<ul><li><p><%= rec.getIngredientes()%></p></li></ul>
					</li>
					
                                        
					
				</ul>
				<hr>
			</div>
			<div class="listpreparacion">
				<h2>Preparación</h2>
				<ul>
					<li class="contlista">
						<ul><li><p><%= rec.getProcesos()%></p></li></ul>
					</li>
					
				</ul>
			</div>
		</div>
		

	</div>
                                        
	<div class="datos">
		<div class="contdatos">
			<div class="beneficios">
				<h4>Calorias</h4>
				<ul class="contenedorbvr">
                                        <li>Calorias: <%= rec.getCaloriasReceta() %> calorias</li>
					
				</ul>
			</div>
			<div class="vitaminas">
				<h4>Datos Extras</h4>
				<ul class="contenedorbvr">
					<li><%= rec.getTiempoReceta() %></li>
					<li><%= rec.getPrecioReceta() %> pesos</li>
				</ul>
			</div>
			<div class="recomendado">
				<h4>Recomendado para personas con:</h4>
				<ul class="contenedorbvr">
					<li><%= rec.getEnfermedades() %></li>
					
				</ul>
			</div>
		</div>
	</div>

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
