<%-- 
    Document   : testUsuario
    Created on : 7/01/2021, 02:53:09 AM
    Author     : Daniel
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estiloTest.css">
        <script type="text/javascript" src="js/calcularTestAB.js"></script>
        <title>Test Usuario</title>
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
                        <a href="#" class="logi" ><img src="img/logo.png" class="logo" alt=""></a>
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
                <div class="textos"><br><br></div>
            </div>
        </header>
                    
        <section class="main">
        <br><br>
        <h2>Test Bulimia vs Anorexia</h2><br>
        <div class="instruccion">
            <p>Instrucciones: Contesta a las siguientes preguntas según cómo te sientas identificado(a).</p>
            <br>
            <form name="formularioAB" id="formAB" method="post" action="">
                <table>
                    <tr>
                        <td class="argumento">
                            <p>1. Como dulces y harinas sin preocuparme.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_1" id="p1_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_1" id="p1_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_1" id="p1_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_1" id="p1_S" value="4">Siempre</label></td>      
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>2. Creo que mi estómago es demasiado grande.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_2" id="p2_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_2" id="p2_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_2" id="p2_CS" value="1">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_2" id="p2_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>3. Suelo comer cuando estoy disgustado(a).</p>
                        </td class="argumento">
                        <td><label><input type="radio" name="pregunta_3" id="p3_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_3" id="p3_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_3" id="p3_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_3" id="p3_S" value="3">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>4. Suelo comer hasta llenarme de comida.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_4" id="p4_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_4" id="p4_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_4" id="p4_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_4" id="p4_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>5. Pienso en ponerse a dieta.</p>
                        </td class="argumento">
                        <td><label><input type="radio" name="pregunta_5" id="p5_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_5" id="p5_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_5" id="p5_CS" value="1">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_5" id="p5_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>6. Pienso que mis muslos son demasiado gruesos.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_6" id="p6_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_6" id="p6_cN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_6" id="p6_cs" value="1">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_6" id="p6_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>7. Me siento culpable cuando como en exceso.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_7" id="p7_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_7" id="p7_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_7" id="p7_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_7" id="p7_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>8. Creo que mi estómago tiene el tamaño adecuado.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_8" id="p8_N" value="2">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_8" id="p8_CN" value="1">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_8" id="p8_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_8" id="p8_S" value="0">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>9. Me aterroriza la idea de engordar.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_9" id="p9_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_9" id="p9_CN" value="1">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_9" id="p9_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_9" id="p9_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>10. Me siento satisfecho(a) con mi figura.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_10" id="p10_N" value="4">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_10" id="p10_CN" value="2">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_10" id="p10_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_10" id="p10_S" value="0">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>11. Exagero o me importa demasiado mi peso.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_11" id="p11_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_11" id="p11_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_11" id="p11_CS" value="1">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_11" id="p11_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>12. He comido en exceso sintiendo que no podría parar de comer.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_12" id="p12_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_12" id="p12_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_12" id="p12_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_12" id="p12_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>13. Me gusta la forma de mi cintura.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_13" id="p13_N" value="2">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_13" id="p13_CN" value="1">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_13" id="p13_CS" value="0">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_13" id="p13_S" value="0">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>14. Estoy preocupado(a) porque quiero ser una persona más delgada.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_14" id="p14_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_14" id="p14_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_14" id="p14_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_14" id="p14_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>15. Suelo pensar en darme un atracón (comer mucho al mismo tiempo).</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_15" id="p15_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_15" id="p15_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_15" id="p15_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_15" id="p15_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>16. Como con moderación delante de los demás, pero me doy un atracón cuando se van.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_16" id="p16_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_16" id="p16_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_16" id="p16_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_16" id="p16_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>17. Si engordo un kilo, me preocupa que pueda seguir ganando peso.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_17" id="p17_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_17" id="p17_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_17" id="p17_CS" value="1">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_17" id="p17_S" value="2">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>18. Pienso en vomitar para perder peso.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_18" id="p18_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_18" id="p18_CN" value="3">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_18" id="p18_CS" value="4">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_18" id="p18_S" value="4">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>19. Creo que el tamaño de mis muslos es adecuado.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_19" id="p19_N" value="2">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_19" id="p19_CN" value="1">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_19" id="p19_CS" value="0">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_19" id="p19_S" value="0">Siempre</label></td>   
                    </tr>
                    <tr>
                        <td class="argumento">
                            <p>20. Como o bebo a escondidas.</p>
                        </td>
                        <td><label><input type="radio" name="pregunta_20" id="p20_N" value="0">Nunca</label></td>
                        <td><label><input type="radio" name="pregunta_20" id="p20_CN" value="0">Casi Nunca</label></td>    
                        <td><label><input type="radio" name="pregunta_20" id="p20_CS" value="3">Casi Siempre</label></td>    
                        <td><label><input type="radio" name="pregunta_20" id="p20_S" value="4">Siempre</label></td>   
                    </tr>
                </table>
                <br><br><br>
                <input class="boton_enviar" type="button" value="Enviar" onclick="checarSelecciones()">
            </form>
        </div>
        <br><br><br>
        <div>
            <div id="result" class="result"></div>
        </div>
        <br><br>
    </section>

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
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
                    
    </body>
    <script type="text/javascript">
    window.onload = alertify.alert('Test "Anorexia vs Bulimia"<br><br>Instrucciones','Elige una opción para cada pregunta '+
    'según como te sientas más identificado/a.<br><br>Las preguntas tratan acerca de tu comportamiento alimenticio, asi como tu '+
    'forma de pensar sobre tu cuerpo.<br><br>Cuando hayas terminado de contestar todas las preguntas, da click en el boton "Enviar" para saber tu resultado.'+
    '<br><br>Nota: El proposito de este test es tratar de predecir si tu comportamiento es semejante a una persona que tiene alguno de estos trastorno alimenticios a partir de las opciones que elijas, más no es seguro que lo puedas padecer. '+
    'Te recomendamos visitar a un especialista (psicologo o nutriologo) para obtener mayor información.');
</script>
</html>
