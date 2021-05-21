<%-- 
    Document   : DetalleRecetaPrincipal
    Created on : 27/12/2020, 02:39:29 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Receta"%>
<%@page import="ModeloDAO.RecetaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            
    RecetaDAO dao = new RecetaDAO();
    int idReceta= Integer.parseInt((String)request.getAttribute("idReceta"));
                
    Receta rec = (Receta)dao.listrecetaPrincipal(idReceta);
            
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/estilosrecetaplantilla.css">
	
	<title>Receta: <%= rec.getNombreReceta()%></title>
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
                                <a href="Nosotros.jsp" class="nose" class="btn_nosotros">Nosotros</a>
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
                                        <li><%= rec.getCaloriasReceta() %> calorias</li>
					
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
