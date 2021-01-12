package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Administrador;
import ModeloDAO.AdministradorDAO;

/**
 * Servlet implementation class ControladorAdministrador
 */
public class ControladorAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String listar = "listaAdministrador.jsp";
    String agregar = "AgregarAdministrador.jsp";
    String editar = "EditarAdministrador.jsp";
    Administrador a = new Administrador();
    AdministradorDAO  admdao= new AdministradorDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAdministrador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAdministrador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {
            
            String nombreAdmin = request.getParameter("nombreAdmin");
            String appatAdmin = request.getParameter("appatAdmin");
            String apmatAdmin = request.getParameter("apmatAdmin");
            String fechaAdmin = request.getParameter("fechaAdmin");
            int telefonoAdmin = Integer.parseInt(request.getParameter("telefonoAdmin"));
            String correoAdmin =  request.getParameter("correoAdmin");
            String userAdmin = request.getParameter("userAdmin");
            String passwordAdmin = request.getParameter("passwordAdmin");
            
            
            a.setNombreAdmin(nombreAdmin);
            a.setAppatAdmin(appatAdmin);
            a.setApmatAdmin(apmatAdmin);
            a.setFechaAdmin(fechaAdmin);
            a.setTelefonoAdmin(telefonoAdmin);
            a.setCorreoAdmin(correoAdmin);
            a.setUserAdmin(userAdmin);
            a.setPasswordAdmin(passwordAdmin);
            
            
            //Agregamos los datos al modelo
            admdao.agregar(a);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idAdministrador", request.getParameter("idAdministrador"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
            String nombreAdmin = request.getParameter("nombreAdmin");
            String appatAdmin = request.getParameter("appatAdmin");
            String apmatAdmin = request.getParameter("apmatAdmin");
            String fechaAdmin = request.getParameter("fechaAdmin");
            int telefonoAdmin = Integer.parseInt(request.getParameter("telefonoAdmin"));
            String userAdmin = request.getParameter("userAdmin");
            
            a.setIdAdministrador(idAdministrador);
            a.setNombreAdmin(nombreAdmin);
            a.setAppatAdmin(appatAdmin);
            a.setApmatAdmin(apmatAdmin);
            a.setFechaAdmin(fechaAdmin);
            a.setTelefonoAdmin(telefonoAdmin);
            a.setUserAdmin(userAdmin);
 
            admdao.editar(a);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
            a.setIdAdministrador(idAdministrador);
            admdao.eliminar(idAdministrador);
            
            acceso= listar;
        
        }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {
            
            String nombreAdmin = request.getParameter("nombreAdmin");
            String appatAdmin = request.getParameter("appatAdmin");
            String apmatAdmin = request.getParameter("apmatAdmin");
            String fechaAdmin = request.getParameter("fechaAdmin");
            long telefonoAdmin = Long.parseLong(request.getParameter("telefonoAdmin"));
            String correoAdmin =  request.getParameter("correoAdmin");
            String userAdmin = request.getParameter("userAdmin");
            String passwordAdmin = request.getParameter("passwordAdmin");
            
            
            a.setNombreAdmin(nombreAdmin);
            a.setAppatAdmin(appatAdmin);
            a.setApmatAdmin(apmatAdmin);
            a.setFechaAdmin(fechaAdmin);
            a.setTelefonoAdmin(telefonoAdmin);
            a.setCorreoAdmin(correoAdmin);
            a.setUserAdmin(userAdmin);
            a.setPasswordAdmin(passwordAdmin);
            
            
            //Agregamos los datos al modelo
            admdao.agregar(a);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idAdministrador", request.getParameter("idAdministrador"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
            String nombreAdmin = request.getParameter("nombreAdmin");
            String appatAdmin = request.getParameter("appatAdmin");
            String apmatAdmin = request.getParameter("apmatAdmin");
            String fechaAdmin = request.getParameter("fechaAdmin");
            long telefonoAdmin = Long.parseLong(request.getParameter("telefonoAdmin"));
            String userAdmin = request.getParameter("userAdmin");
            
            a.setIdAdministrador(idAdministrador);
            a.setNombreAdmin(nombreAdmin);
            a.setAppatAdmin(appatAdmin);
            a.setApmatAdmin(apmatAdmin);
            a.setFechaAdmin(fechaAdmin);
            a.setTelefonoAdmin(telefonoAdmin);
            a.setUserAdmin(userAdmin);
 
            admdao.editar(a);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
            a.setIdAdministrador(idAdministrador);
            admdao.eliminar(idAdministrador);
            
            acceso= listar;
        
        }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
