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
		  <p > <h3 style="text-align: center;">T??rminos y Condiciones de la Aplicaci??n</h3> <br><br>

			<p style="font-size: 23px;"> ???HealtKnife???</p><br><br>
			
			El presente acuerdo expone los t??rminos y condiciones que rigen la relaci??n entre la empresa Asociaci??n de Ingenieros y Desarrolladores de Software Brace Black S.A. de C.V. bajo la denominaci??n de la ???Sociedad???, con las personas, denominados los ???Usuarios??? que descarguen y utilicen los ???Servicios??? que la Sociedad le proporciona a trav??s de la Aplicaci??n ???HealtKnife???, le permiten a trav??s del dispositivo autorizado de su propiedad o bajo su uso (el ???Dispositivo???), as?? como la informaci??n que se le env??e a trav??s del correo de su propiedad, para recibir promociones, ofertas o cualquier publicidad de comerciantes participantes a la Sociedad.
			
			Una vez que usted acepta los siguientes T??rminos o cuando acceda o utilice los Servicios de la Aplicaci??n en su Dispositivo, usted acuerda y acepta los siguientes puntos:
			
			<br><br>SERVICIOS DE LA APLICACI??N <br><br>
			
			1. Incorpora los T??rminos y Condiciones de uso de los Servicios Brace Black, establecidos en -direcci??n-. Ambos t??rminos son obligatorios entre usted y la Sociedad, y rigen su acceso y uso de los Servicios de la Aplicaci??n. <br>
			
			2. La Sociedad pone a disposici??n del Usuario, o de las personas que este designe (los ???Autorizados???), la presente Aplicaci??n para que la Sociedad pueda realizar de manera eficiente la prestaci??n de los Servicios.<br>
			
			3. Los datos ingresados por los Usuarios a trav??s de la Aplicaci??n y recolectados por la Sociedad ser??n almacenados bajo los est??ndares internacionales de seguridad, los cuales ayudar??n a la prestaci??n de los Servicios de la Aplicaci??n.<br>
			
			4. Para que la Sociedad preste los Servicios de la Aplicaci??n al Usuario, este tendr?? que ingresar los datos solicitados en la Aplicaci??n para asignarle una clave de usuario y una contrase??a para que el usuario ingres a su cuenta en el momento necesario.<br>
			
			5. Esta bajo su responsabilidad asegurarse que todos los usuarios que utilicen su Dispositivo tengan conocimiento de que cualquiera con acceso a los Servicios de la Aplicaci??n podr?? acceder a la informaci??n sobre su cuenta en la Aplicaci??n.<br>
			
			<br>USO DEL CONTENIDO <br><br>
			
			1. El Usuario es propietario de todo el contenido y la informaci??n que proporciona a la Sociedad a trav??s de los Servicios de la Aplicaci??n.<br>
			
			2. La Sociedad recopila todos los datos que el Usuario o los Autorizados proporcionen al usar los Servicios de la Aplicaci??n, as?? como la informaci??n de los Dispositivos en los que el Usuario o las Autorizados utilicen la Aplicaci??n.<br>
			
			3. La Sociedad no garantiza que la Aplicaci??n sea siempre segura, libre de errores y que funcione sin interrupciones, retrasos o imperfecciones. Las actualizaciones podr??n darse en cualquier tiempo dando aviso al propietario del Dispositivo, as?? como las novedades de la Aplicaci??n. El Usuario y el Autorizado deslindan a la Sociedad de cualquier falla, da??o o perjuicio que lo anterior pudiera ocasionarles y se abstendr??n 
			
			de presentar cualquier reclamaci??n, sea judicial o extrajudicial, derivado de dicho supuesto.<br>
			
			4. Solamente usted usara los Servicios de la Aplicaci??n cuando usted crea que es seguro hacerlo, en cumplimiento con la ley y estos t??rminos, y no usara los Servicios de la Aplicaci??n bajo fines de lucro o usos inapropiados que puedan provocar sanciones expresadas en las leyes jur??dicas mexicanas.<br>
			
			5. Usted no usara los Servicios de la Aplicaci??n para da??ar verbal, emocional o f??sicamente a persona alguna, o use de forma indebida la informaci??n que se expone en la Aplicaci??n. No usara de forma ilegal o con un prop??sito no autorizado, provocando as?? una infracci??n a las leyes de jur??dicas, e inclusive una sanci??n penal por violaci??n a la Constituci??n.<br>
			
			<br>PRIVACIDAD <br><br>
			
			1. Nosotros podremos solicitar, usar, y compartir informaci??n acerca de usted, incluyendo la ubicaci??n de su Dispositivo, de la manera en la que se describen las Pol??ticas de Privacidad y el Aviso de Privacidad de los Servicios de la Aplicaci??n, que se pueden encontrar en -direcci??n-.<br>
			
			2. Nosotros no somos responsables por los actos llevado a cabo por terceros que pueden acceder a los Servicios de la Aplicaci??n y a la informaci??n a trav??s de su Dispositivo. Esta bajo su responsabilidad utilizar todas las funciones de seguridad de su Dispositivo, sea contrase??a, bloqueo o encriptado, a fin de protegerse en contra de accesos no autorizados y uso de los Servicios de la Aplicaci??n y de su informaci??n.<br>
			
			<br>SEGURIDAD <br><br>
			
			1. La Sociedad, en la medida de lo posible, realizara los actos necesarios para que la Aplicaci??n proteja toda la informaci??n y bases de datos que haya proporcionado a la Sociedad.<br>
			
			2. Para una mayor protecci??n y seguridad, el Usuario podr?? realizar las siguientes acciones:<br> <br>
			<p style="padding-left:20px;">
			
			a. No ingresar a la Aplicaci??n virus ni c??digos maliciosos de ning??n tipo.<br>
			
			b. No realizar ninguna acci??n que pudiera inhabilitar, sobrecargar o afectar al funcionamiento correcto de la Aplicaci??n o a su aspecto.<br>
			
			c. No solicitar informaci??n tanto del acceso como el contenido de cuentas externas al Usuario.<br>
			
			d. No utilizar la Aplicaci??n para actos il??citos, malintencionados o discriminatorios, como est?? establecido en el articulo 5 del capitulo ???Uso del Contenido???.<br>
			
			e. No proporcionar datos e informaci??n falsa.<br>
			
			f. No crear cuentas para otras personas sin su autorizaci??n.<br>
			
			g. No crear cuentas sin permiso de la Sociedad, ya que de esta forma ser?? inhabilitada la cuenta del Usuario.<br>
			
			h. No publicar contenido ni realizar ninguna acci??n en la Aplicaci??n que infrinja o vulnere los derechos de terceros o que provoque vulnerabilidad cualquiera a una ley federal o a la Constituci??n (Art??culo 4 de Uso del Contenido).<br>
			
			i. La Sociedad podr?? retirar cualquier contenido en los Servicios de la Aplicaci??n, si la Sociedad considera que se infringe alguna ley o normatividad mexicana o internacional.<br>
			</p> <br>
			3. El uso de los Servicios de la Aplicaci??n por parte de usted podr?? involucrar servicios que sean puestos a su disposici??n a trav??s de terceros. Esto puede involucrar el compartir su ubicaci??n del Dispositivo y/o funciones que requieran su instalaci??n dependiendo de los servicios.<br>
			<p style="padding-left:20px;"> <br>
			a. Podr?? deshabilitar el compartir su ubicaci??n en la Configuraci??n de su Dispositivo.<br>
			
			b. Podr?? recibir promociones y ofertas de comerciantes participantes, a trav??s de los Servicios de la Aplicaci??n.<br>
			
			c. Estos servicios de terceros, promociones y ofertas, y cualquier otra transacci??n relacionada que usted contrate, ser??n entre usted y el tercero ??nicamente.<br>
			
			d. La Sociedad no le garantizamos el cumplimiento, la confiabilidad o la seguridad, y no somo responsables de ninguna perdida o da??o que pueda ser ocasionado, tales como una p??rdida de informaci??n personal a trav??s de servicios de Internet de terceros.<br>
		  </p> <br>
			<br>RELACION LABORAL EXTERNA A LA SOCIEDAD<br><br>
			
			1. Los presentes T??rminos y Condiciones de la Aplicaci??n regulan una relaci??n mercantil de prestaci??n de servicios entre la Sociedad y el Usuario, por lo que en ning??n momento la Sociedad ser?? considerada como patr??n respecto del personal que contrate el usuario para desarrollar su objeto social.<br>
			
			2. El Usuario manifiesta ser el ??nico responsable de cubrir todas las prestaciones que de confinidad con la legislaci??n mexicana deban de pagarse a su respectivo personal.<br>
			
			3. En caso de que la Sociedad llegue a ser demandada por el personal del usuario, el usuario se obliga a sacar en paz y a salvo a la Sociedad de dicha demanda y a rembolsar a la Sociedad de cualquier gasto en que hubiera incurrido, e inclusive dar una indemnizaci??n por infracci??n a las garant??as y otros derechos que el personal y directivos de la Sociedad pudiera ser afectados seg??n sea el caso.<br>
			
			<br>MODIFICACIONES Y ACTUALIZACIONES <br><br>
			
			1. En caso de que la Sociedad realice algunas modificaciones a los presentes T??rminos y Condiciones de la Aplicaci??n, notificara al usuario de estas en un periodo de 15 d??as naturales despu??s de haber realizado dichas modificaciones para que el Usuario se d?? por enterado de dichas modificaciones.<br>
			
			2. Si la Sociedad realiza cambios en las pol??ticas, normas u otras condiciones a las que hacen referencia estos T??rminos y Condiciones.<br>
			
			3. El Usuario y los Autorizados acuerdan que los presentes t??rminos regulan el uso de la Aplicaci??n, y por ning??n motivo sustituye cualquier contrato, convenio o acuerdo previamente firmado con la Sociedad.<br>
			
			<br>TERMINACION <br><br>
			
			1. En caso de cualquier conflicto entre estos T??rminos y los T??rminos y Condiciones de uso de los Servicios Brace Black, estos t??rminos regir??n cualquier acceso o uso de los Servicios de la Aplicaci??n.<br>
			
			2. Si el Usuario infringe los T??rminos y Condiciones de la Aplicaci??n, y los T??rminos y Condiciones de uso de los Servicios Brace Black, crea riesgos de cualquier tipo para la Sociedad o la expone a posibles responsabilidades jur??dicas, la Sociedad podr?? impedir el acceso al Usuario a la Aplicaci??n total o parcialmente. La Sociedad notificar?? por correo electr??nico o la pr??xima vez que el Usuario intente acceder a su cuenta.<br>
			
			3. El Usuario podr?? eliminar su cuenta o desactivar su Aplicaci??n en cualquier momento. Independientemente de lo anterior, la sociedad se reserva el derecho de ejercer cualquier acci??n legal aplicable.<br>
			
			<br>CONFLICTOS <br><br>
			
			1. El Usuario se obliga a sacar en paz y a salvo a la Sociedad y a todo su personal y directivos, as?? mismo, deber?? pagar cualquier gasto, p??rdida, da??os (incluidos los costos y honorarios judiciales) de cualquier demanda, causa de acci??n o conflicto que interponga un tercero, que pudiera surgir derivada de las acciones, contenido o informaci??n de la Aplicaci??n.<br>
			
			2. Asimismo, para el caso de interpretaci??n, cumplimiento o conflicto de los presentes T??rminos y Condiciones de la Aplicaci??n, y los T??rminos y Condiciones de uso de los Servicios Brace Black, el Usuario y la Sociedad se sujetan a las leyes aplicables de la Ciudad de M??xico, as?? como la normatividad a pegada a las leyes federales y a la Constituci??n, y a la jurisdicci??n de los tribunales de la Ciudad de M??xico, renunciando a cualquier fuero que pudiera corresponderles por raz??n de sus domicilios, presentes o futuros o por cualesquier otra causa.<br>
			
			<br>Si hay dudas, comentarios, sugerencias o quejas con los Servicios de la Aplicaci??n, cont??ctenos en cualquier momento a trav??s de correo electr??nico, correo postal, por los tel??fonos o a trav??s de nuestra p??gina oficial.<br>
			
			Asociaci??n de Ingenieros y Desarrolladores de Software Brace Black S.A. de C.V.</p>
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
