<%-- 
    Document   : listaBlog
    Created on : 7/01/2021, 01:27:56 AM
    Author     : Daniel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Blog"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.BlogDAO"%>
<%@page import="Modelo.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estiloslistarecetas_1.css">
        <title>Lista de Contenidos - Blog</title>
        
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
            <h2>Lista de Contenidos</h2>
            <br>
            <br>
            <hr>
            <br>
            <br>
            
            <div>
                <a href="ControladorBlog?accion=agregar" class="btn btn-info">Agregar</a>
                
                
                
            </div>
            
            <br>
            <br>
            
            <table class="table table-hover table-striped table-dark">
                <thead>
                  <tr>
                    <th class="thead-blue" scope="col">ID</th>
                    <th class="thead-blue" scope="col">Nombre</th>
                    <th class="thead-blue" scope="col">Imagen</th>
                    <th class="thead-blue" scope="col">Cuerpo</th>
                    <th class="thead-blue" scope="col">Acción</th>
                    
                  </tr>
                </thead>
                
                <%
                    BlogDAO dao = new BlogDAO();
                    List<Blog>list = dao.listar();
                    Iterator<Blog>iter = list.iterator();
                    Blog blo = null;
                    while(iter.hasNext()){
                    
                        blo = iter.next();

                %>
                <tbody>
                    <tr>
                        
                        <th scope="row"><%= blo.getIdBlog()%></th>
                        <td><%= blo.getTituloBlog()%></td>
                        <td><img src="<%= blo.getImgBlog()%>" width="150px" height="150px"></td>
                        <td style="font-size: 12px; text-align: justify;"><%= blo.getCuerpoBlog()%></td>
                        
                        
                        <td>
                            <a href="ControladorBlog?accion=editar&idBlog=<%= blo.getIdBlog()%>">Editar</a>
                            
                            <form method="post" action="ControladorBlog?idBlog=<%= blo.getIdBlog()%>">
                                
                                <input type="submit" id="submit" name="accion" value="eliminar">
                                <input type="hidden" name="idBlog" id="idBlog" value="<%= blo.getIdBlog() %>">
                                
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
