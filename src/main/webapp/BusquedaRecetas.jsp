

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
    try{
        Conexion con = new Conexion();
        Statement smt;
        ResultSet rs;
        smt = con.getConnection().createStatement();
        
%>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/estilosbuscarrecetas.css">
        <link rel="stylesheet" href="css/estiloslistarecetas_2.css">
	<title>Búsqueda de Recetas</title>
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
                                <a href="#"  class="nose" class="btn_contacto">Servicios</a>
                                <a href="#"  class="nose" class="btn_nosostros">Nosotros</a>
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
			
		<br>
		<br>
		<h2>Encuentra recetas personalizadas</h2>
		<br>
		<br>
		<hr>
		<br>
		<br>

		
		<div class="contform">
			<form method="post" class="formulario">
				<div class="opcgrandes">
					<div>
						<label for="transtorno">Seleccione el transtorno alimenticio que tenga</label>
						<select name="transtenf" id="transtorno" class="selectslargos">
                                                    <option>Enfermedad/Transtorno</option>
                                                    <option>Anorexia</option>
                                                    <option>Bulimia</option>
                                                    <option>Sobrepeso</option>
                                                    <option>Transtorno alimentario compulsivo</option>
                                                    <option>Transtorno de rumiación</option>
                                                    <option>Transtorno por evitación de la ingesta de alimentos</option>
                                                    <option>Ninguno</option>
                                                </select>
					</div>
					
					<div>
						<label for="alergia">Nombre de la receta:</label>
                                                <input name="nombrerec" id="alergia" class="selectslargos" maxlength="100">
					</div>
                                        
				</div>
				<div class="opcchicas">
					<div>
                                                <label for="ing1">Calorias (kcal)</label>
                                                <input name="caloriasrec" id="ing1" class="selectscortos" maxlength="100">
					</div>
					<div>
						<label for="ing2">Tiempo (minutos)</label>
						<input name="tiemporec" id="ing2" class="selectscortos" maxlength="100">
					</div>
					<div>
						<label for="ing3">Precio (pesos)</label>
						<input name="preciorec" id="ing3" class="selectscortos" maxlength="100">
					</div>
				</div>
				<div class="opcchicas">
					<div>
						<label for="ing1">Ingrediente 1</label>
                                                <input name="ingr1" id="ing1" class="selectscortos" maxlength="100">
					</div>
					
					<div>
						<label for="ing2">Ingrediente 2</label>
						<input name="ingr2" id="ing2" class="selectscortos" maxlength="100">
					</div>
					
					<div>
						<label for="ing3">Ingrediente 3</label>
						<input name="ingr3" id="ing3" class="selectscortos" maxlength="100">
					</div>
				</div>
				
				<div class="opcchicas">
					<div>
						<label for="ing4">Ingrediente 4</label>
                                                <input name="ingr4" id="ing4" class="selectscortos" maxlength="100">
					</div>
					
					<div>
						<label for="ing5">Ingrediente 5</label>
                                                <input name="ingr5" id="ing5" class="selectscortos" maxlength="100">
					</div>
					
					<div>
						<label for="ing6">Ingrediente 6</label>
                                                <input name="ingr6" id="ing6" class="selectscortos" maxlength="100">
					</div>

				</div>
				
				
				
				<input type="submit" class="submit" value="Encontrar">
			</form>
        <%  
            ////////////////////////////// TRANSTORNO O ENFERMEDAD
            String transtorno = "";
            String trans = "Ninguno";
            trans = request.getParameter("transtenf");
            if (trans.equals("Enfermedad/Transtorno") || trans.equals("Ninguno")) {
                //System.out.println("Si funciona uwu");
                transtorno = "WHERE (enfermedad LIKE '%anorexia%' or enfermedad LIKE '%bulimia%' or enfermedad LIKE '%sobrepeso%' or enfermedad LIKE '%trastorno alimentario compulsivo%' or enfermedad LIKE '%transtorno de rumiación%' or enfermedad LIKE '%transtorno por evitación de la ingesta de alimentos%' or enfermedad LIKE '%trastorno por evitación de la ingesta de alimentos%' or enfermedad LIKE '%trastorno de rumiación%' or enfermedad LIKE '%transtorno alimentario compulsivo%')";    
            } else if(trans.equals("Anorexia")){
                transtorno = "WHERE (enfermedad LIKE '%anorexia%' or enfermedad2 LIKE '%anorexia%' or enfermedad3 LIKE '%anorexia%')";
            } else if(trans.equals("Bulimia")){
                transtorno = "WHERE (enfermedad LIKE '%bulimia%' or enfermedad2 LIKE '%bulimia%' or enfermedad3 LIKE '%bulimia%')";
            } else if(trans.equals("Sobrepeso")){
                transtorno = "WHERE (enfermedad LIKE '%sobrepeso%' or enfermedad2 LIKE '%sobrepeso%' or enfermedad3 LIKE '%sobrepeso%')";
            } else if(trans.equals("Transtorno alimentario compulsivo")){
                transtorno = "WHERE (enfermedad LIKE '%trastorno alimentario compulsivo%' or enfermedad2 LIKE '%trastorno alimentario compulsivo%' or enfermedad3 LIKE '%trastorno alimentario compulsivo%' or enfermedad LIKE '%transtorno alimentario compulsivo%' or enfermedad2 LIKE '%transtorno alimentario compulsivo%' or enfermedad3 LIKE '%transtorno alimentario compulsivo%')";
            } else if(trans.equals("Transtorno de rumiación")){
                transtorno = "WHERE (enfermedad LIKE '%transtorno de rumiación%' or enfermedad2 LIKE '%transtorno de rumiación%' or enfermedad3 LIKE '%transtorno de rumiación%' or enfermedad LIKE '%trastorno de rumiación%' or enfermedad2 LIKE '%trastorno de rumiación%' or enfermedad3 LIKE '%trastorno de rumiación%')";
            } else if(trans.equals("Transtorno por evitación de la ingesta de alimentos")){
                transtorno = "WHERE (enfermedad LIKE '%transtorno por evitación de la ingesta de alimentos%' or enfermedad2 LIKE '%transtorno por evitación de la ingesta de alimentos%' or enfermedad3 LIKE '%transtorno por evitación de la ingesta de alimentos%' or enfermedad LIKE '%trastorno por evitación de la ingesta de alimentos%' or enfermedad2 LIKE '%trastorno por evitación de la ingesta de alimentos%' or enfermedad3 LIKE '%trastorno por evitación de la ingesta de alimentos%')";
            } else if(trans.equals("Ninguno")){
                transtorno = "WHERE (enfermedad LIKE '%anorexia%' or enfermedad LIKE '%bulimia%' or enfermedad LIKE '%sobrepeso%' or enfermedad LIKE '%trastorno alimentario compulsivo%' or enfermedad LIKE '%transtorno de rumiación%' or enfermedad LIKE '%transtorno por evitación de la ingesta de alimentos%' or enfermedad LIKE '%trastorno por evitación de la ingesta de alimentos%' or enfermedad LIKE '%trastorno de rumiación%' or enfermedad LIKE '%transtorno alimentario compulsivo%')";    
            } else {
                transtorno = "";
            }
            System.out.println("Aqui: " + trans);
            
            //////////////////////////////////// NOMBRE
            String nombrerec = "";
            String namerec = request.getParameter("nombrerec");
            if (namerec.equals("") || namerec.equals(" ") || (namerec == null)) {
                nombrerec = "";
            } else {
                nombrerec = " AND (nombreReceta LIKE '%" + namerec + "%')";
            }
            
            
            /////////////////////////////////// TIEMPO
            
            String tiemporec = "";
            String timerec = request.getParameter("tiemporec");
            if (timerec.equals("") || timerec.equals(" ") || (timerec == null)) {
                tiemporec = "";
            } else {
                tiemporec = " AND (tiempoReceta LIKE '%" + timerec + "%')";
            }
            
            /////////////////////////////////// CALORIAS
            
            String caloriasrec = "";
            String caloriesrec = request.getParameter("caloriasrec");
            if (caloriesrec.equals("") || caloriesrec.equals(" ") || (caloriesrec == null)) {
                caloriasrec = "";
            } else {
                caloriasrec = " AND (caloriasReceta LIKE '%" + caloriesrec + "%')";
            }
            
            /////////////////////////////////// PRECIO
            
            String preciorec = "";
            String pricerec = request.getParameter("preciorec");
            if (pricerec.equals("") || pricerec.equals(" ") || (pricerec == null)) {
                preciorec = "";
            } else {
                preciorec = " AND (precioReceta LIKE '%" + pricerec + "%')";
            }
            
            /////////////////////////////////// INGREDIENTES
            //ING1
            String ingre1prec = "";
            String ingr1 = request.getParameter("ingr1");
            if (ingr1.equals("") || ingr1.equals(" ") || (ingr1 == null)) {
                ingre1prec = "";
            } else {
                ingre1prec = " AND (ingrediente1 LIKE '%" + ingr1 + "%' or ingrediente2 LIKE '%" + ingr1 + "%' or ingrediente3 LIKE '%" + ingr1 + "%' or ingrediente4 LIKE '%" + ingr1 + "%' or ingrediente5 LIKE '%" + ingr1 + "%' or ingrediente6 LIKE '%" + ingr1 + "%' or ingrediente7 LIKE '%" + ingr1 + "%' or ingrediente8 LIKE '%" + ingr1 + "%' or ingrediente9 LIKE '%" + ingr1 + "%' or ingrediente9 LIKE '%" + ingr1 + "%' or ingrediente10 LIKE '%" + ingr1 + "%')";
            }
            //ING2
            String ingre2prec = "";
            String ingr2 = request.getParameter("ingr2");
            if (ingr2.equals("") || ingr2.equals(" ") || (ingr2 == null)) {
                ingre2prec = "";
            } else {
                ingre2prec = " AND (ingrediente1 LIKE '%" + ingr2 + "%' or ingrediente2 LIKE '%" + ingr2 + "%' or ingrediente3 LIKE '%" + ingr2 + "%' or ingrediente4 LIKE '%" + ingr2 + "%' or ingrediente5 LIKE '%" + ingr2 + "%' or ingrediente6 LIKE '%" + ingr2 + "%' or ingrediente7 LIKE '%" + ingr2 + "%' or ingrediente8 LIKE '%" + ingr2 + "%' or ingrediente9 LIKE '%" + ingr2 + "%' or ingrediente9 LIKE '%" + ingr2 + "%' or ingrediente10 LIKE '%" + ingr2 + "%')";
            }
            //ING3
            String ingre3prec = "";
            String ingr3 = request.getParameter("ingr3");
            if (ingr3.equals("") || ingr3.equals(" ") || (ingr3 == null)) {
                ingre3prec = "";
            } else {
                ingre3prec = " AND (ingrediente1 LIKE '%" + ingr3 + "%' or ingrediente2 LIKE '%" + ingr3 + "%' or ingrediente3 LIKE '%" + ingr3 + "%' or ingrediente4 LIKE '%" + ingr3 + "%' or ingrediente5 LIKE '%" + ingr3 + "%' or ingrediente6 LIKE '%" + ingr3 + "%' or ingrediente7 LIKE '%" + ingr3 + "%' or ingrediente8 LIKE '%" + ingr3 + "%' or ingrediente9 LIKE '%" + ingr3 + "%' or ingrediente9 LIKE '%" + ingr3 + "%' or ingrediente10 LIKE '%" + ingr3 + "%')";
            }
            //ING4
            String ingre4prec = "";
            String ingr4 = request.getParameter("ingr4");
            if (ingr4.equals("") || ingr4.equals(" ") || (ingr4 == null)) {
                ingre4prec = "";
            } else {
                ingre4prec = " AND (ingrediente1 LIKE '%" + ingr4 + "%' or ingrediente2 LIKE '%" + ingr4 + "%' or ingrediente3 LIKE '%" + ingr4 + "%' or ingrediente4 LIKE '%" + ingr4 + "%' or ingrediente5 LIKE '%" + ingr4 + "%' or ingrediente6 LIKE '%" + ingr4 + "%' or ingrediente7 LIKE '%" + ingr4 + "%' or ingrediente8 LIKE '%" + ingr4 + "%' or ingrediente9 LIKE '%" + ingr4 + "%' or ingrediente9 LIKE '%" + ingr4 + "%' or ingrediente10 LIKE '%" + ingr4 + "%')";
            }
            //ING5
            String ingre5prec = "";
            String ingr5 = request.getParameter("ingr5");
            if (ingr5.equals("") || ingr5.equals(" ") || (ingr5 == null)) {
                ingre5prec = "";
            } else {
                ingre5prec = " AND (ingrediente1 LIKE '%" + ingr5 + "%' or ingrediente2 LIKE '%" + ingr5 + "%' or ingrediente3 LIKE '%" + ingr5 + "%' or ingrediente4 LIKE '%" + ingr5 + "%' or ingrediente5 LIKE '%" + ingr5 + "%' or ingrediente6 LIKE '%" + ingr5 + "%' or ingrediente7 LIKE '%" + ingr5 + "%' or ingrediente8 LIKE '%" + ingr5 + "%' or ingrediente9 LIKE '%" + ingr5 + "%' or ingrediente9 LIKE '%" + ingr5 + "%' or ingrediente10 LIKE '%" + ingr5 + "%')";
            }
            //ING6
            String ingre6prec = "";
            String ingr6 = request.getParameter("ingr6");
            if (ingr6.equals("") || ingr6.equals(" ") || (ingr6 == null)) {
                ingre6prec = "";
            } else {
                ingre6prec = " AND (ingrediente1 LIKE '%" + ingr6 + "%' or ingrediente2 LIKE '%" + ingr6 + "%' or ingrediente3 LIKE '%" + ingr6 + "%' or ingrediente4 LIKE '%" + ingr6 + "%' or ingrediente5 LIKE '%" + ingr6 + "%' or ingrediente6 LIKE '%" + ingr6 + "%' or ingrediente7 LIKE '%" + ingr6 + "%' or ingrediente8 LIKE '%" + ingr6 + "%' or ingrediente9 LIKE '%" + ingr6 + "%' or ingrediente9 LIKE '%" + ingr6 + "%' or ingrediente10 LIKE '%" + ingr6 + "%')";
            }
            
            
            String iniciop = "SELECT * FROM receta ";
            String finalp = iniciop + transtorno + nombrerec + tiemporec + 
                    caloriasrec + preciorec + ingre1prec + ingre2prec + ingre3prec + ingre4prec +
                    ingre5prec + ingre6prec;
            System.out.println("Final: " + finalp);
            rs = smt.executeQuery(finalp);
        %>
		</div>
			
			<br>
			<br>
			<br>		
		
	</section>
        <section class="mains">
		<br>
		<br>
		<h2>Estas son tus opciones</h2>
		<br>
		<br>
		<hr>
		<br>
		<br>
		
			<ul>
                            <%
                    while (rs.next()){
                %>
                                <li class="receta">
                                    <div class="contreceta">
                                            <div class="imgreceta"><img class="imgrecet" src="<%= rs.getString("imgReceta")%>" alt="<%= rs.getString("nombreReceta")%> "></div>
                                            <div class="descripcionreceta">
                                                    <div class="conttitulo">
                                                            <h3 class="titulo"><%= rs.getString("nombreReceta")%></h3>
                                                            <input type="hidden" name="idReceta" value="<%= rs.getInt("idReceta") %>">
                                                    </div>
                                                    <div class="contdescr">							
                                                        <p class="descr"><%= rs.getString("descripcion") %><br></p><br>
                                                        <p class="descr" style="text-align: left">Calorias: <%= rs.getString("caloriasReceta") %><br></p><br>
                                                        <p class="descr" style="text-align: left">Tiempo: <%= rs.getString("tiempoReceta") %><br></p><br>
                                                        <p class="descr" style="text-align: left">Precio aproximado: $<%= rs.getString("precioReceta") %> pesos<br></p><br>
                                                        
                                                    </div>
                                                    

                                            </div>
                                            <div class="contenlacereceta"><a href="ControladorReceta?accion=listrecetaPrincipal&idReceta=<%= rs.getInt("idReceta")%>" class="enlacereceta">Ir</a></div>
                                    </div>
                                </li>
                                <%}%>
				
			</ul>
		
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
        
    </body>
</html>

<%

        
   }catch(Exception e){
        System.out.println("Error: " + e);
        e.printStackTrace();
    }
%>
