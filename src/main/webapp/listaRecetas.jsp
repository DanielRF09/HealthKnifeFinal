<%-- 
    Document   : listaRecetas
    Created on : 15/12/2020, 07:07:41 PM
    Author     : Daniel
--%>

<%@page import="Modelo.Administrador"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Receta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RecetaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estiloslistarecetas_1.css">
        <title>Lista de Recetas</title>
        
        <style type="text/css">
            .thead-blue{
                background-color: #071626;
                color: white;
            }
            
            .btn{
                
                float: left;
                margin-left: 2%;
                height: 30px;
                width: 5%;
                font-size: 15px;
                
            }
            
            #submit {
                color: #007bff;
                text-decoration: none;
                background-color: transparent;
                border:0;
            }
            
            #submit:hover{
                
                color: -webkit-link;
                cursor: pointer;
                text-decoration: underline;
                
            }
            li{
                margin-right:10px;
                
            }

            
        </style>
    </head>
    <body>
        <%
            HttpSession sesionOk = request.getSession();
            Administrador ad = null;
            if (sesionOk.getAttribute("usuario") == null) {
        %>
        <jsp:forward page="login.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
        <%
            } else {
                ad = (Administrador) sesionOk.getAttribute("usuario");
                
            }
        %>
        
        <header>
            <div class="contenedor">
                
                <nav class="menu">
                    <div class="contlogo">
			<a href="ControladorReceta?accion=listarindexAdministrador" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
                    </div>
                    <div class="contbotones">
			<a href="ControladorReceta?accion=listarindexAdministrador" class="nose" class="btn_articulos">Inicio</a>
			<a href="Controlador?accion=listar" class="nose" class="btn_nosotros">Usuarios</a>
                        <a href="ControladorNutriologo?accion=listar" class="nose" class="btn_nosotros">Nutriologos</a>
                        <a href="ControladorAdministrador?accion=listar" class="nose" class="btn_nosotros">Administradores</a>
                        <a href="ControladorReceta?accion=listar" class="nose" class="btn_nosotros">Recetas</a>
                        <a href="ControladorBlog?accion=listar" class="nose" class="btn_nosotros">Blog</a>
                        <a href="https://healtknifechat.herokuapp.com/" class="nose" class="btn_nosotros">Chat</a>
                        <a  href="cerrarSesion.jsp" class="nose" class="btn_nosotros">Cerrar Sesion</a>	
                    </div>
										
		</nav>
			
		<div class="textos">
				
                    <br>
                    <br>		  
		</div>
            </div>
	</header>
        
        <section class='main'>
            <br>
            <br>
            <h2>Lista de Recetas</h2>
            <br>
            <br>
            <hr>
            <br>
            <br>
            
            <div>
                <a href="ControladorReceta?accion=agregar" class="btn btn-info">Agregar</a>
                
                
                
            </div>
            
            <br>
            <br>
            
            <table class="table table-hover table-striped table-dark">
                <thead>
                  <tr>
                    <th class="thead-blue" scope="col">ID</th>
                    <th class="thead-blue" scope="col">Nombre</th>
                    <th class="thead-blue" scope="col">Imagen</th>
                    <th class="thead-blue" scope="col">Descripcion</th>
                    <th class="thead-blue" scope="col">Calorias</th>
                    <th class="thead-blue" scope="col">Tiempo Preparación</th>
                    <th class="thead-blue" scope="col">Precio</th>
                    <th class="thead-blue" scope="col">Ingredientes</th>
                    <th class="thead-blue" scope="col">Procedimiento</th>
                    <th class="thead-blue" scope="col">Enfermedades</th>
                    <th class="thead-blue" scope="col">idCategoria</th>
                    <th class="thead-blue" scope="col">Acción</th>
                    
                  </tr>
                </thead>
                
                <%
                    RecetaDAO dao = new RecetaDAO();
                    List<Receta>list = dao.listar();
                    Iterator<Receta>iter = list.iterator();
                    Receta rec = null;
                    while(iter.hasNext()){
                    
                        rec = iter.next();

                %>
                <tbody>
                    <tr>
                        
                        <th scope="row"><%= rec.getIdReceta()%></th>
                        <td><%= rec.getNombreReceta()%></td>
                        <td><img src="<%= rec.getImgReceta()%>" width="150px" height="150px"></td>
                        <td width="75px" style="font-size: 10px; text-align: justify;"><%= rec.getDescripcion() %></td>
                        <td style="font-size: 10px;"><%= rec.getCaloriasReceta()%></td>
                        <td style="font-size: 10px;"><%= rec.getTiempoReceta()%></td>
                        <td style="font-size: 10px;"><%= rec.getPrecioReceta() %></td>
                        <td style="font-size: 10px; text-align: justify;">
                        
                            <ol>
                                <li><%= rec.getIngrediente1() %></li>
                                <li><%= rec.getIngrediente2() %></li>
                                <li><%= rec.getIngrediente3() %></li>
                                <li><%= rec.getIngrediente4() %></li>
                                <li><%= rec.getIngrediente5() %></li>
                                <li><%= rec.getIngrediente6() %></li>
                                <li><%= rec.getIngrediente7() %></li>
                                <li><%= rec.getIngrediente8() %></li>
                                <li><%= rec.getIngrediente9() %></li>
                                <li><%= rec.getIngrediente10() %></li>
                            
                            </ol>

                        </td>
                        <td style="font-size: 10px; text-align: justify;">
                        
                            <ol>
                                <li><%= rec.getProceso1() %></li>
                                <li><%= rec.getProceso2() %></li>
                                <li><%= rec.getProceso3() %></li>
                                <li><%= rec.getProceso4() %></li>
                                <li><%= rec.getProceso5() %></li>
                                <li><%= rec.getProceso6() %></li>
                                <li><%= rec.getProceso7() %></li>
                                <li><%= rec.getProceso8() %></li>
     
                            </ol>
                        
                        </td>
                        
                        <td style="font-size: 10px; text-align: justify;">
                        
                            <ol>
                                <li><%= rec.getEnfermedad() %></li>
                                <li><%= rec.getEnfermedad2() %></li>
                                <li><%= rec.getEnfermedad3() %></li>
     
                            </ol>
                        
                        </td>
                        
                        <td style="font-size: 10px;"><%= rec.getNombreCategoria() %></td>
                        
                        <td>
                            <a href="ControladorReceta?accion=editar&idReceta=<%= rec.getIdReceta()%>">Editar</a>
                            
                            <form method="post" action="ControladorReceta?idReceta=<%= rec.getIdReceta()%>">
                                
                                <input type="submit" id="submit" name="accion" value="eliminar">
                                <input type="hidden" name="idReceta" id="idReceta" value="<%= rec.getIdReceta() %>">
                                
                            </form>
                        </td>
                        
                    </tr>
                    <%}%>
                  
                </tbody>
            </table>
     
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

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
