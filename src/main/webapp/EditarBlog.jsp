<%-- 
    Document   : EditarBlog
    Created on : 7/01/2021, 01:48:52 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Blog"%>
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
        <title>Editar Blog</title>
        
        <style>
            *{
                margin:0;
                padding:0;
                box-sizing: border-box;
            }
            body{
                background-image: url(https://www.xtrafondos.com/descargar.php?id=3586&resolucion=3840x2160);
            }
            
            .form-registro{
                width: 400px;
                background: #24303c;
                padding: 30px;
                margin: auto;
                margin-top: 100px;
                border-radius: 4px;
                font-family: 'calibri';
                color:white;
                box-shadow: 7px 13px 37px #000;
            }
            
            .form-registro h4{
                font-size: 22px;
                margin-bottom: 20px;
            }
            
            .controls{
                width: 100%;
                background: #24303c;
                padding: 10px;
                border-radius: 4px;
                margin-bottom: 16px;
                border:1px solid #1f53c5;
                font-family: 'calibri';
                font-size: 18px;
                color: white;
            }
            
            .form-registro p {
                height: 40px;
                text-align: center;
                font-size: 18px;
                line-height: 40px;
            }
            
            .form-registro a{
                color:white;
                text-decoration: none;
            }
            
            .form-registro a:hover{
                color: white;
                text-decoration: underline;
            }
            
            .form-registro .botones{
                width:100%;
                background: #1f53c5;
                border:none;
                padding:12px;
                color:white;
                margin:16px 0;
                font-size:16px;
            }
            
        </style>
        
        <script type="text/javascript" src="js/validacionreg.js"></script>
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
                        <a href="cerrarSesion.jsp" class="nose" class="btn_nosotros">Cerrar Sesion</a>	
                    </div>
										
		</nav>
			
		<div class="textos">
				
                    <br>
                    <br>		  
		</div>
            </div>
	</header>
        
        <section class="form-registro">
            
            <%
            
                BlogDAO dao = new BlogDAO();
                int idBlog= Integer.parseInt((String)request.getAttribute("idBlog"));
                
                Blog blo = (Blog)dao.list(idBlog);
            
            %>
            
            <h4>Editar Receta</h4>
            <form action="ControladorBlog" method="post">
                
                
                <input type="text" class="controls" name="tituloBlog" id="tituloBlog" placeholder="Ingrese el titulo del Blog" value="<%= blo.getTituloBlog()%>" required minlength="1" maxlength="44">
                <input type="text" class="controls" name="imgBlog" id="imgBlog" placeholder="Ingrese la url de la imagen del Blog" value="<%= blo.getImgBlog()%>" required minlength="1" maxlength="254" >
                <textarea class="controls" name="cuerpoBlog" id="cuerpoBlog" placeholder="Ingrese el cuerpo del Blog" required rows="10"><%= blo.getCuerpoBlog()%></textarea>
                <input type="hidden" name="idBlog" id="idBlog" value="<%= blo.getIdBlog() %>">
                
                <input type="submit" class="botones" name="accion" value="Actualizar">
                <a href="ControladorBlog?accion=listar">Regresar</a>
            </form>
            
            
            
        </section>
        
    </body>
</html>
