<%-- 
    Document   : AgregarNutriologo
    Created on : 16/12/2020, 08:40:02 PM
    Author     : Daniel
--%>

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
        <title>Formulario para Agregar Nutriologo</title>
        
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
                        <a  href="cerrarSesion.jsp" class="nose" class="btn_nosotros">Cerrar Sesion</a>	
                    </div>
										
		</nav>
			
		<div class="textos">
				
                    <br>
                    <br>		  
		</div>
            </div>
	</header>
        
        <section class="form-registro">  
            <h4>Agregar Nutriologo</h4>
            <form action="ControladorNutriologo" method="post">
                <input type="text" class="controls" name="nombreNutriologo" id="nombreNutriologo" placeholder="Ingrese el nombre" required minlength="1" maxlength="44" onkeypress="return validarn(event)">
                <input type="text" class="controls" name="appatNutriologo" id="appatNutriologo" placeholder="Ingrese el apellido paterno" required minlength="1" maxlength="44" onkeypress="return validarn(event)">
                <input type="text" class="controls" name="apmatNutriologo" id="apmatNutriologo" placeholder="Ingrese el apellido materno" required minlength="1" maxlength="44" onkeypress="return validarn(event)">
                <input type="text" class="controls" name="sexoNutriologo" id="sexoNutriologo" placeholder="Ingrese el sexo" required minlength="1" maxlength="1" onkeypress="return validarn(event)">
                <input type="date" class="controls" name="fechaNutriologo" id="fechaNutriologo" required>
                <input type="text" class="controls" name="telefonoNutriologo" id="telefonoNutriologo" placeholder="Ingrese el telefono" required minlength="10" maxlength="10" onkeypress="return validarcp(event)">
                <input type="email" class="controls" name="correoNutriologo" id="correoNutriologo" placeholder="Ingrese su correo" required  minlength="6" maxlength="44">
                <input type="text" class="controls" name="userNutriologo" id="userNutriologo" placeholder="Ingrese su nombre de usuario" required minlength="6" maxlength="44">
                <input type="password" class="controls" name="passwordNutriologo" id="passwordNutriologo" placeholder="Ingrese su contraseña" required minlength="4" maxlength="25">
                
                <input type="submit" class="botones" name="accion" value="Registrar">  
                <a href="ControladorNutriologo?accion=listar" style="margin-left: 45%;">Regresar</a>
            </form>

        </section>
    </body>
</html>
