<%-- 
    Document   : listaAdministrador
    Created on : 25/12/2020, 11:30:20 PM
    Author     : Daniel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Administrador"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.AdministradorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estiloslistarecetas_1.css">
        <title>Lista de Administradores</title>
        
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
            <h2>Lista de Administradores</h2>
            <br>
            <br>
            <hr>
            <br>
            <br>
            
            <div>
                <a href="ControladorAdministrador?accion=agregar" class="btn btn-info">Agregar</a>
 
            </div>
            
            <br>
            <br>
            
            <table class="table table-hover table-striped table-dark">
                <thead>
                  <tr>
                    <th class="thead-blue" scope="col">ID</th>
                    <th class="thead-blue" scope="col">Nombre</th>
                    <th class="thead-blue" scope="col">Ap. Paterno</th>
                    <th class="thead-blue" scope="col">Ap. Materno</th>
                    <th class="thead-blue" scope="col">Fecha</th>
                    <th class="thead-blue" scope="col">Télefono</th>
                    <th class="thead-blue" scope="col">Tipo Usuario</th>
                    <th class="thead-blue" scope="col">Acción</th>
                    
                  </tr>
            </thead>
                
                <%
                    AdministradorDAO dao = new AdministradorDAO();
                    List<Administrador>list = dao.listar();
                    Iterator<Administrador>iter = list.iterator();
                    Administrador adm = null;
                    while(iter.hasNext()){
                    
                        adm = iter.next();

                %>
                <tbody>
                    <tr>
                        
                        <th scope="row"><%= adm.getIdAdministrador()%></th>
                        <td><%= adm.getNombreAdmin()%></td>
                        <td><%= adm.getAppatAdmin()%></td>
                        <td><%= adm.getApmatAdmin()%></td>
                        <td><%= adm.getFechaAdmin()%></td>
                        <td><%= adm.getTelefonoAdmin()%></td>
                        <td><%= adm.getIdTipoUsuario()%></td>
                        
   
                        <td>
                            <form method="post" action="ControladorAdministrador?accion=editar&idAdministrador=<%= adm.getIdAdministrador()%>">
                                
                                <input type="submit" id="submit" name="accion" value="Editar">
                                <input type="hidden" name="idAdministrador" id="idAdministrador" value="<%= adm.getIdAdministrador() %>">
                                
                            </form>
                            <!-- <a href="ControladorAdministrador?accion=editar&idAdministrador=">Editar</a> -->
                            <form method="post" action="ControladorAdministrador?idAdministrador=<%= adm.getIdAdministrador()%>">
                                
                                <input type="submit" id="submit" name="accion" value="eliminar">
                                <input type="hidden" name="idAdministrador" id="idAdministrador" value="<%= adm.getIdAdministrador() %>">
                                
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

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    
    </body>
</html>
