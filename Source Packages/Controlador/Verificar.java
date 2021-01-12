package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Administrador;
import Modelo.Nutriologo;
import Modelo.Usuario;

/**
 * Servlet implementation class Verificar
 */
public class Verificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        int tipo = Integer.parseInt(request.getParameter("tipo"));

        String userName, nombre, appat, apmat, sexo, email, password;

        Usuario u = new Usuario();
        Administrador a = new Administrador();
        Nutriologo n = new Nutriologo();
        
        if (tipo == 1) {
//            Este es un inicio de sesion
            email = request.getParameter("email");
            password = request.getParameter("password");
            
            u = Usuario.verificarUsuarioEmail(email, password, tipo);
            a = Administrador.verificarAdministradorEmail(email, password, tipo);
            n = Nutriologo.verificarNutriologoEmail(email, password, tipo);
            
            if (u != null) {
//                Quiere decir que si existe ese usuario y por lo tanto tambien puede iniciar sesion.

                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", u);
                session.setAttribute("usuario", u);
                

//                Lo pasamos a la pagina principal y pues con todo y sesion y tods sus datos en el objeto u
                response.sendRedirect("indexUsuarios.jsp");

            }else if(a != null){
                
                HttpSession session = request.getSession();
                session.setAttribute("idAdministrador", a);
                session.setAttribute("usuario", a);
                
                //Pagina a la que lo enviamos
                response.sendRedirect("indexAdmin.jsp");
            
            }else if(n != null){
                
                HttpSession session = request.getSession();
                session.setAttribute("idNutriologo", n);
                session.setAttribute("usuario", n);
                
                //Pagina a la que lo enviamos
                response.sendRedirect("indexNutriologo.jsp");
            
            }else {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta charset=\"UTF-8\">");
                    out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
                    out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto:300,300i,400,700&display=swap\" rel=\"stylesheet\">");
                    out.println("<link rel=\"stylesheet\" href=\"css/estilospaginaerrores.css\">");
                    out.println("<title>Registro Error</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<section class=\"main\">");
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<h2>Error al iniciar Sesión</h2>");
                    out.println("<div class=\"Parrafo\" style=\"width:300px; margin-left:auto; margin-right:auto; color:white;\">");
                    out.println("<p style=\"font-size: 20px;\">Lo sentimos, correo y/o contraseña incorrecta</p>");
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                    out.println("</div>");
                    out.println("</section>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } else if (tipo == 2) {
//            Este es un registro de Usuario

//            Aqui vamos a obtener todos los datos del usuario y despues comprobar si no existia anteriormente
            userName = request.getParameter("userName");
            nombre = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            sexo = request.getParameter("gender");
            email = request.getParameter("email");
            password = request.getParameter("password");

//            REVISAMOS QUE NO EXISTA EL CORREO NI EL USERNAME
            if (Usuario.verificarUsuarioEmail(email, null, tipo) == null && Usuario.verificarUsuarioUser(userName, tipo) == null) {
//                Esto quiere decir que ni el correo ni el userName
                System.out.println("VAMOS A AGREGAR UN NUEVO USUARIO");
                RegistrarUsuario.agregarUsuario(nombre, appat, apmat, sexo, email, userName, password, password, email, sexo);
                
                u = Usuario.verificarUsuarioEmail(email, password, tipo);
                
                
                HttpSession session = request.getSession();
                session.setAttribute("usuario", u);
//                Redireccionamos a la pagina de inicio para que inicie sesion
                response.sendRedirect("login.jsp");

            } else {
                System.out.println("NO SE REGISTRÓ ESTE USUARIO");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Registro</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Lo sentimos, ese CORREO y/o UserName ya esta en uso</h1>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }

        }else if (tipo == 3) {
//            Inisio de sesion con google
            email = request.getParameter("emailGoogle");
            password = "Google";
            u = Usuario.verificarUsuarioEmail(email, password, tipo);
            System.out.println("u = " + u);
            if (u != null) {
//                Quiere decir que si existe ese usuario y por lo tanto tambien puede iniciar sesion.

                HttpSession session = request.getSession();
                session.setAttribute("usuario", u);

//                Lo pasamos a la pagina principal y pues con todo y sesion y tods sus datos en el objeto u
                response.sendRedirect("indexUsuarios.jsp");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", true);
                response.sendRedirect("signUpGoogle.jsp?dato=true");
            }
            
            
        }  else if (tipo == 4) {
//            Registro con google
            userName = request.getParameter("userName");
            nombre = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            sexo = request.getParameter("gender");
            email = request.getParameter("email");
            password = "Google";
            System.out.println("E");

//            System.out.println("userName = " + userName);
//            System.out.println("nombre = " + nombre);
//            System.out.println("appat = " + appat);
////            if (appat == "undefined") {
////                appat = "";
////                System.out.println("appat = " + appat);
////            }
//            System.out.println("apmat = " + apmat);
////            if (apmat == undefined) {
////               
////                apmat = "";
////                System.out.println("apmat = " + apmat);
////            }
//            System.out.println("sexo = " + sexo);
//            System.out.println("email = " + email);

            if (Usuario.verificarUsuarioEmail(email, null, tipo) == null && Usuario.verificarUsuarioUser(userName, tipo) == null) {
                System.out.println("VAMOS A AGREGAR UN NUEVO USUARIO");
                RegistrarUsuario.agregarUsuario(nombre, appat, apmat, sexo, email, userName, password, password, email, sexo);
                //                Redireccionamos a la pagina de inicio para que inicie sesion
                tipo = 1;
                u = Usuario.verificarUsuarioEmail(email, password, tipo);

                HttpSession session = request.getSession();
                session.setAttribute("usuario", u);

                System.out.println(session.getAttribute("usuario"));
                response.sendRedirect("indexUsuarios.jsp");
            } else {
                System.out.println("NO SE REGISTRÓ ESTE USUARIO");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Registro</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Este UserName ya esta en uso, intenta con otro</h1>");
                    out.println("<a href='signUpGoogle.jsp'>Regresar</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
        
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Verificar.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Verificar.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
