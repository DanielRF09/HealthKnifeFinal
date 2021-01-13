<%-- 
    Document   : DetalleRecetaGuardada
    Created on : 29/12/2020, 03:40:59 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.CRecetas"%>
<%@page import="ModeloDAO.CRecetasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            
    CRecetasDAO dao = new CRecetasDAO();
    int idReceta= Integer.parseInt((String)request.getAttribute("idReceta"));
                
    CRecetas cre = (CRecetas)dao.listrecetaGuardada(idReceta);
    
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
	
	<title>Receta: <%= cre.getReceta()%></title>
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
                    <img class="imgreeceta" src="<%= cre.getImgReceta()%>" alt="">
                    <input type="hidden" name="idReceta" id="idReceta" value="<%= cre.getIdReceta() %> ">
                </div>
            <div class="contdesc">
                    <div class="noset">
                        <h3 class="title"><%= cre.getReceta()%></h3>
                    </div>
                    <div >
                        <p class="fontdescripcion"><%= cre.getDescripcion()%></p>
                    </div>
				
            </div>
            </div>
			
		
	</section>
        
        
        <div class="caracteris">
		<div class="contenedordeproces">
			<div class="listingredientes">
				<h2>Ingredientes</h2>
				<ul>
					<li class="contlista"><h2>Ingrediente 1</h2> 
						<ul><li><p><%= cre.getIngrediente1()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Ingrediente 2</h3> 
						<ul><li><p><%= cre.getIngrediente2()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Ingrediente 3</h3> 
						<ul><li><p><%= cre.getIngrediente3()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Ingrediente 4</h3> 
						<ul><li><p><%= cre.getIngrediente4()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 5</h3> 
						<ul><li><p><%= cre.getIngrediente5()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 6</h3> 
						<ul><li><p><%= cre.getIngrediente6()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 7</h3> 
						<ul><li><p><%= cre.getIngrediente7()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 8</h3> 
						<ul><li><p><%= cre.getIngrediente8()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 9</h3> 
						<ul><li><p><%= cre.getIngrediente9()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Ingrediente 10</h3> 
						<ul><li><p><%= cre.getIngrediente10()%></p></li></ul>
					</li>
                                        
					
				</ul>
				<hr>
			</div>
			<div class="listpreparacion">
				<h2>Preparación</h2>
				<ul>
					<li class="contlista"><h3>Paso 1</h3> 
						<ul><li><p><%= cre.getProceso1()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 2</h3> 
						<ul><li><p><%= cre.getProceso2()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 3</h3> 
						<ul><li><p><%= cre.getProceso3()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 4</h3> 
						<ul><li><p><%= cre.getProceso4()%></p></li></ul>
					</li>
                                        <li class="contlista"><h3>Paso 5</h3> 
						<ul><li><p><%= cre.getProceso5()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 6</h3> 
						<ul><li><p><%= cre.getProceso6()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 7</h3> 
						<ul><li><p><%= cre.getProceso7()%></p></li></ul>
					</li>
					<li class="contlista"><h3>Paso 8</h3> 
						<ul><li><p><%= cre.getProceso8()%></p></li></ul>
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
                                        <li>Calorias: <%= cre.getCaloriasReceta() %> calorias</li>
					
				</ul>
			</div>
			<div class="vitaminas">
				<h4>Datos Extras</h4>
				<ul class="contenedorbvr">
					<li><%= cre.getTiempoReceta() %></li>
					<li><%= cre.getPrecioReceta() %> pesos</li>
				</ul>
			</div>
			<div class="recomendado">
				<h4>Recomendado para personas con:</h4>
				<ul class="contenedorbvr">
					<li><%= cre.getEnfermedad() %></li>
					<li><%= cre.getEnfermedad2() %></li>
                                        <li><%= cre.getEnfermedad3() %></li>
					
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
