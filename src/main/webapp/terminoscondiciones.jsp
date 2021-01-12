<%-- 
    Document   : indexUsuarios
    Created on : 31/12/2020, 02:22:01 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloslogin.css">
        <link rel="stylesheet" href="css/responsivo.css">
        <title>Inicio</title>
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
                        <a href="indexUsuarios.jsp" class="nose" class="btn_articulos">Inicio</a>
                        <a href="ControladorBlog?accion=listarUsuarios" class="nose" class="btn_nosotros">Blog</a>
                        <a href="BusquedaRecetasUsuario.jsp"  class="nose" class="btn_contacto">Buscar</a>
                        <a href="ControladorReceta?accion=listarindexUsuario"  class="nose" class="btn_contacto">Recetas</a>
                        <a href="testUsuario.jsp"  class="nose" class="btn_contacto">Test</a>
                        <a href="testSedentarismo.jsp"  class="nose" class="btn_contacto" style="font-size:15px;">Test Sedentarismo</a>
                        <a href="https://healtknifechat.herokuapp.com/"  class="nose" class="btn_contacto">Chat</a>
                        <a href="ControladorCRecetas?accion=recetasGuardadas&idUsuario=<%=us.getIdUsuario()%>" class="btn_carrito"></a>				
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
			

		<div class="Parrafo" style="width:70%; font-weight: 1; margin-left:auto; margin-right:auto; color:white; text-align: justify;">
		  <p > <h3 style="text-align: center;">Términos y Condiciones de la Aplicación</h3> <br><br>

			<p style="font-size: 23px;"> “HealtKnife”</p><br><br>
			
			El presente acuerdo expone los términos y condiciones que rigen la relación entre la empresa Asociación de Ingenieros y Desarrolladores de Software Brace Black S.A. de C.V. bajo la denominación de la “Sociedad”, con las personas, denominados los “Usuarios” que descarguen y utilicen los “Servicios” que la Sociedad le proporciona a través de la Aplicación “HealtKnife”, le permiten a través del dispositivo autorizado de su propiedad o bajo su uso (el “Dispositivo”), así como la información que se le envíe a través del correo de su propiedad, para recibir promociones, ofertas o cualquier publicidad de comerciantes participantes a la Sociedad.
			
			Una vez que usted acepta los siguientes Términos o cuando acceda o utilice los Servicios de la Aplicación en su Dispositivo, usted acuerda y acepta los siguientes puntos:
			
			<br><br>SERVICIOS DE LA APLICACIÓN <br><br>
			
			1. Incorpora los Términos y Condiciones de uso de los Servicios Brace Black, establecidos en -dirección-. Ambos términos son obligatorios entre usted y la Sociedad, y rigen su acceso y uso de los Servicios de la Aplicación. <br>
			
			2. La Sociedad pone a disposición del Usuario, o de las personas que este designe (los “Autorizados”), la presente Aplicación para que la Sociedad pueda realizar de manera eficiente la prestación de los Servicios.<br>
			
			3. Los datos ingresados por los Usuarios a través de la Aplicación y recolectados por la Sociedad serán almacenados bajo los estándares internacionales de seguridad, los cuales ayudarán a la prestación de los Servicios de la Aplicación.<br>
			
			4. Para que la Sociedad preste los Servicios de la Aplicación al Usuario, este tendrá que ingresar los datos solicitados en la Aplicación para asignarle una clave de usuario y una contraseña para que el usuario ingres a su cuenta en el momento necesario.<br>
			
			5. Esta bajo su responsabilidad asegurarse que todos los usuarios que utilicen su Dispositivo tengan conocimiento de que cualquiera con acceso a los Servicios de la Aplicación podrá acceder a la información sobre su cuenta en la Aplicación.<br>
			
			<br>USO DEL CONTENIDO <br><br>
			
			1. El Usuario es propietario de todo el contenido y la información que proporciona a la Sociedad a través de los Servicios de la Aplicación.<br>
			
			2. La Sociedad recopila todos los datos que el Usuario o los Autorizados proporcionen al usar los Servicios de la Aplicación, así como la información de los Dispositivos en los que el Usuario o las Autorizados utilicen la Aplicación.<br>
			
			3. La Sociedad no garantiza que la Aplicación sea siempre segura, libre de errores y que funcione sin interrupciones, retrasos o imperfecciones. Las actualizaciones podrán darse en cualquier tiempo dando aviso al propietario del Dispositivo, así como las novedades de la Aplicación. El Usuario y el Autorizado deslindan a la Sociedad de cualquier falla, daño o perjuicio que lo anterior pudiera ocasionarles y se abstendrán 
			
			de presentar cualquier reclamación, sea judicial o extrajudicial, derivado de dicho supuesto.<br>
			
			4. Solamente usted usara los Servicios de la Aplicación cuando usted crea que es seguro hacerlo, en cumplimiento con la ley y estos términos, y no usara los Servicios de la Aplicación bajo fines de lucro o usos inapropiados que puedan provocar sanciones expresadas en las leyes jurídicas mexicanas.<br>
			
			5. Usted no usara los Servicios de la Aplicación para dañar verbal, emocional o físicamente a persona alguna, o use de forma indebida la información que se expone en la Aplicación. No usara de forma ilegal o con un propósito no autorizado, provocando así una infracción a las leyes de jurídicas, e inclusive una sanción penal por violación a la Constitución.<br>
			
			<br>PRIVACIDAD <br><br>
			
			1. Nosotros podremos solicitar, usar, y compartir información acerca de usted, incluyendo la ubicación de su Dispositivo, de la manera en la que se describen las Políticas de Privacidad y el Aviso de Privacidad de los Servicios de la Aplicación, que se pueden encontrar en -dirección-.<br>
			
			2. Nosotros no somos responsables por los actos llevado a cabo por terceros que pueden acceder a los Servicios de la Aplicación y a la información a través de su Dispositivo. Esta bajo su responsabilidad utilizar todas las funciones de seguridad de su Dispositivo, sea contraseña, bloqueo o encriptado, a fin de protegerse en contra de accesos no autorizados y uso de los Servicios de la Aplicación y de su información.<br>
			
			<br>SEGURIDAD <br><br>
			
			1. La Sociedad, en la medida de lo posible, realizara los actos necesarios para que la Aplicación proteja toda la información y bases de datos que haya proporcionado a la Sociedad.<br>
			
			2. Para una mayor protección y seguridad, el Usuario podrá realizar las siguientes acciones:<br> <br>
			<p style="padding-left:20px;">
			
			a. No ingresar a la Aplicación virus ni códigos maliciosos de ningún tipo.<br>
			
			b. No realizar ninguna acción que pudiera inhabilitar, sobrecargar o afectar al funcionamiento correcto de la Aplicación o a su aspecto.<br>
			
			c. No solicitar información tanto del acceso como el contenido de cuentas externas al Usuario.<br>
			
			d. No utilizar la Aplicación para actos ilícitos, malintencionados o discriminatorios, como está establecido en el articulo 5 del capitulo “Uso del Contenido”.<br>
			
			e. No proporcionar datos e información falsa.<br>
			
			f. No crear cuentas para otras personas sin su autorización.<br>
			
			g. No crear cuentas sin permiso de la Sociedad, ya que de esta forma será inhabilitada la cuenta del Usuario.<br>
			
			h. No publicar contenido ni realizar ninguna acción en la Aplicación que infrinja o vulnere los derechos de terceros o que provoque vulnerabilidad cualquiera a una ley federal o a la Constitución (Artículo 4 de Uso del Contenido).<br>
			
			i. La Sociedad podrá retirar cualquier contenido en los Servicios de la Aplicación, si la Sociedad considera que se infringe alguna ley o normatividad mexicana o internacional.<br>
			</p> <br>
			3. El uso de los Servicios de la Aplicación por parte de usted podrá involucrar servicios que sean puestos a su disposición a través de terceros. Esto puede involucrar el compartir su ubicación del Dispositivo y/o funciones que requieran su instalación dependiendo de los servicios.<br>
			<p style="padding-left:20px;"> <br>
			a. Podrá deshabilitar el compartir su ubicación en la Configuración de su Dispositivo.<br>
			
			b. Podrá recibir promociones y ofertas de comerciantes participantes, a través de los Servicios de la Aplicación.<br>
			
			c. Estos servicios de terceros, promociones y ofertas, y cualquier otra transacción relacionada que usted contrate, serán entre usted y el tercero únicamente.<br>
			
			d. La Sociedad no le garantizamos el cumplimiento, la confiabilidad o la seguridad, y no somo responsables de ninguna perdida o daño que pueda ser ocasionado, tales como una pérdida de información personal a través de servicios de Internet de terceros.<br>
		  </p> <br>
			<br>RELACION LABORAL EXTERNA A LA SOCIEDAD<br><br>
			
			1. Los presentes Términos y Condiciones de la Aplicación regulan una relación mercantil de prestación de servicios entre la Sociedad y el Usuario, por lo que en ningún momento la Sociedad será considerada como patrón respecto del personal que contrate el usuario para desarrollar su objeto social.<br>
			
			2. El Usuario manifiesta ser el único responsable de cubrir todas las prestaciones que de confinidad con la legislación mexicana deban de pagarse a su respectivo personal.<br>
			
			3. En caso de que la Sociedad llegue a ser demandada por el personal del usuario, el usuario se obliga a sacar en paz y a salvo a la Sociedad de dicha demanda y a rembolsar a la Sociedad de cualquier gasto en que hubiera incurrido, e inclusive dar una indemnización por infracción a las garantías y otros derechos que el personal y directivos de la Sociedad pudiera ser afectados según sea el caso.<br>
			
			<br>MODIFICACIONES Y ACTUALIZACIONES <br><br>
			
			1. En caso de que la Sociedad realice algunas modificaciones a los presentes Términos y Condiciones de la Aplicación, notificara al usuario de estas en un periodo de 15 días naturales después de haber realizado dichas modificaciones para que el Usuario se dé por enterado de dichas modificaciones.<br>
			
			2. Si la Sociedad realiza cambios en las políticas, normas u otras condiciones a las que hacen referencia estos Términos y Condiciones.<br>
			
			3. El Usuario y los Autorizados acuerdan que los presentes términos regulan el uso de la Aplicación, y por ningún motivo sustituye cualquier contrato, convenio o acuerdo previamente firmado con la Sociedad.<br>
			
			<br>TERMINACION <br><br>
			
			1. En caso de cualquier conflicto entre estos Términos y los Términos y Condiciones de uso de los Servicios Brace Black, estos términos regirán cualquier acceso o uso de los Servicios de la Aplicación.<br>
			
			2. Si el Usuario infringe los Términos y Condiciones de la Aplicación, y los Términos y Condiciones de uso de los Servicios Brace Black, crea riesgos de cualquier tipo para la Sociedad o la expone a posibles responsabilidades jurídicas, la Sociedad podrá impedir el acceso al Usuario a la Aplicación total o parcialmente. La Sociedad notificará por correo electrónico o la próxima vez que el Usuario intente acceder a su cuenta.<br>
			
			3. El Usuario podrá eliminar su cuenta o desactivar su Aplicación en cualquier momento. Independientemente de lo anterior, la sociedad se reserva el derecho de ejercer cualquier acción legal aplicable.<br>
			
			<br>CONFLICTOS <br><br>
			
			1. El Usuario se obliga a sacar en paz y a salvo a la Sociedad y a todo su personal y directivos, así mismo, deberá pagar cualquier gasto, pérdida, daños (incluidos los costos y honorarios judiciales) de cualquier demanda, causa de acción o conflicto que interponga un tercero, que pudiera surgir derivada de las acciones, contenido o información de la Aplicación.<br>
			
			2. Asimismo, para el caso de interpretación, cumplimiento o conflicto de los presentes Términos y Condiciones de la Aplicación, y los Términos y Condiciones de uso de los Servicios Brace Black, el Usuario y la Sociedad se sujetan a las leyes aplicables de la Ciudad de México, así como la normatividad a pegada a las leyes federales y a la Constitución, y a la jurisdicción de los tribunales de la Ciudad de México, renunciando a cualquier fuero que pudiera corresponderles por razón de sus domicilios, presentes o futuros o por cualesquier otra causa.<br>
			
			<br>Si hay dudas, comentarios, sugerencias o quejas con los Servicios de la Aplicación, contáctenos en cualquier momento a través de correo electrónico, correo postal, por los teléfonos o a través de nuestra página oficial.<br>
			
			Asociación de Ingenieros y Desarrolladores de Software Brace Black S.A. de C.V.</p>
		  <br>
		  <br>
		  <br>
		  
		</div>
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

    </body>
</html>
