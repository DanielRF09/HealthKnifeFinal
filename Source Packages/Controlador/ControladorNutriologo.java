package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Nutriologo;
import ModeloDAO.NutriologoDAO;

/**
 * Servlet implementation class ControladorNutriologo
 */
public class ControladorNutriologo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String listar = "listaNutriologos.jsp";
    String agregar = "AgregarNutriologo.jsp";
    String editar = "EditarNutriologo.jsp";
    Nutriologo n = new Nutriologo();
    NutriologoDAO  nutdao= new NutriologoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorNutriologo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorNutriologo at " + request.getContextPath() + "</h1>");
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
            
            String nombreNutriologo = request.getParameter("nombreNutriologo");
            String appatNutriologo = request.getParameter("appatNutriologo");
            String apmatNutriologo = request.getParameter("apmatNutriologo");
            String sexoNutriologo = request.getParameter("sexoNutriologo");
            String fechaNutriologo = request.getParameter("fechaNutriologo");
            int telefonoNutriologo = Integer.parseInt(request.getParameter("telefonoNutriologo"));
            String correoNutriologo = request.getParameter("correoNutriologo");
            String userNutriologo = request.getParameter("userNutriologo");
            String passwordNutriologo = request.getParameter("passwordNutriologo");
            
            
            n.setNombreNutriologo(nombreNutriologo);
            n.setAppatNutriologo(appatNutriologo);
            n.setApmatNutriologo(apmatNutriologo);
            n.setSexoNutriologo(sexoNutriologo);
            n.setFechaNutriologo(fechaNutriologo);
            n.setTelefonoNutriologo(telefonoNutriologo);
            n.setCorreoNutriologo(correoNutriologo);
            n.setUserNutriologo(userNutriologo);
            n.setPasswordNutriologo(passwordNutriologo);
            
            
            //Agregamos los datos al modelo
            nutdao.agregar(n);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idNutriologo", request.getParameter("idNutriologo"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idNutriologo = Integer.parseInt(request.getParameter("idNutriologo"));
            String nombreNutriologo = request.getParameter("nombreNutriologo");
            String appatNutriologo = request.getParameter("appatNutriologo");
            String apmatNutriologo = request.getParameter("apmatNutriologo");
            String sexoNutriologo = request.getParameter("sexoNutriologo");
            String fechaNutriologo = request.getParameter("fechaNutriologo");
            int telefonoNutriologo = Integer.parseInt(request.getParameter("telefonoNutriologo"));
            String userNutriologo = request.getParameter("userNutriologo");
            
            n.setIdNutriologo(idNutriologo);
            n.setNombreNutriologo(nombreNutriologo);
            n.setAppatNutriologo(appatNutriologo);
            n.setApmatNutriologo(apmatNutriologo);
            n.setSexoNutriologo(sexoNutriologo);
            n.setFechaNutriologo(fechaNutriologo);
            n.setTelefonoNutriologo(telefonoNutriologo);
            n.setUserNutriologo(userNutriologo);
 
            nutdao.editar(n);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idNutriologo = Integer.parseInt(request.getParameter("idNutriologo"));
            n.setIdNutriologo(idNutriologo);
            nutdao.eliminar(idNutriologo);
            
            acceso= listar;
        
        }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {
            
            String nombreNutriologo = request.getParameter("nombreNutriologo");
            String appatNutriologo = request.getParameter("appatNutriologo");
            String apmatNutriologo = request.getParameter("apmatNutriologo");
            String sexoNutriologo = request.getParameter("sexoNutriologo");
            String fechaNutriologo = request.getParameter("fechaNutriologo");
            long telefonoNutriologo = Long.parseLong(request.getParameter("telefonoNutriologo"));
            String correoNutriologo = request.getParameter("correoNutriologo");
            String userNutriologo = request.getParameter("userNutriologo");
            String passwordNutriologo = request.getParameter("passwordNutriologo");
            
            
            n.setNombreNutriologo(nombreNutriologo);
            n.setAppatNutriologo(appatNutriologo);
            n.setApmatNutriologo(apmatNutriologo);
            n.setSexoNutriologo(sexoNutriologo);
            n.setFechaNutriologo(fechaNutriologo);
            n.setTelefonoNutriologo(telefonoNutriologo);
            n.setCorreoNutriologo(correoNutriologo);
            n.setUserNutriologo(userNutriologo);
            n.setPasswordNutriologo(passwordNutriologo);
            
            
            //Agregamos los datos al modelo
            nutdao.agregar(n);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idNutriologo", request.getParameter("idNutriologo"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idNutriologo = Integer.parseInt(request.getParameter("idNutriologo"));
            String nombreNutriologo = request.getParameter("nombreNutriologo");
            String appatNutriologo = request.getParameter("appatNutriologo");
            String apmatNutriologo = request.getParameter("apmatNutriologo");
            String sexoNutriologo = request.getParameter("sexoNutriologo");
            String fechaNutriologo = request.getParameter("fechaNutriologo");
            long telefonoNutriologo = Long.parseLong(request.getParameter("telefonoNutriologo"));
            String userNutriologo = request.getParameter("userNutriologo");
            
            n.setIdNutriologo(idNutriologo);
            n.setNombreNutriologo(nombreNutriologo);
            n.setAppatNutriologo(appatNutriologo);
            n.setApmatNutriologo(apmatNutriologo);
            n.setSexoNutriologo(sexoNutriologo);
            n.setFechaNutriologo(fechaNutriologo);
            n.setTelefonoNutriologo(telefonoNutriologo);
            n.setUserNutriologo(userNutriologo);
 
            nutdao.editar(n);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idNutriologo = Integer.parseInt(request.getParameter("idNutriologo"));
            n.setIdNutriologo(idNutriologo);
            nutdao.eliminar(idNutriologo);
            
            acceso= listar;
        
        }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}

	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
