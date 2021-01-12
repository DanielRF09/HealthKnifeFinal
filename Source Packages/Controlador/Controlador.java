package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;


public class Controlador extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String listar = "listaUsuarios.jsp";
    String agregar = "AgregarUsuario.jsp";
    String editar = "EditarUsuario.jsp";
    Usuario u = new Usuario();
    UsuarioDAO  usudao= new UsuarioDAO();
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
            
            String nombreUsuario = request.getParameter("nombreUsuario");
            String appatUsuario = request.getParameter("appatUsuario");
            String apmatUsuario = request.getParameter("apmatUsuario");
            String sexoUsuario = request.getParameter("sexoUsuario");
            String fechaUsuario = request.getParameter("fechaUsuario");
            String correoUsuario = request.getParameter("correoUsuario");
            String userUsuario = request.getParameter("userUsuario");
            String passwordUsuario = request.getParameter("passwordUsuario");
            
            
            u.setNombreUsuario(nombreUsuario);
            u.setAppatUsuario(appatUsuario);
            u.setApmatUsuario(apmatUsuario);
            u.setSexoUsuario(sexoUsuario);
            u.setFechaUsuario(fechaUsuario);
            u.setCorreoUsuario(correoUsuario);
            u.setUserUsuario(userUsuario);
            u.setPasswordUsuario(passwordUsuario);
            
            
            
            usudao.agregar(u);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idUsuario", request.getParameter("idUsuario"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nombreUsuarioactu = request.getParameter("nombreUsuario");
            String appatUsuario = request.getParameter("appatUsuario");
            String apmatUsuario = request.getParameter("apmatUsuario");
            String sexoUsuario = request.getParameter("sexoUsuario");
            String fechaUsuario = request.getParameter("fechaUsuario");
            String userUsuario = request.getParameter("userUsuario");
            
            u.setIdUsuario(idUsuario);
            u.setNombreUsuario(nombreUsuarioactu);
            u.setAppatUsuario(appatUsuario);
            u.setApmatUsuario(apmatUsuario);
            u.setSexoUsuario(sexoUsuario);
            u.setFechaUsuario(fechaUsuario);
            u.setUserUsuario(userUsuario);
 
            usudao.editar(u);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            u.setIdUsuario(idUsuario);
            usudao.eliminar(idUsuario);
            
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
            
            String nombreUsuario = request.getParameter("nombreUsuario");
            String appatUsuario = request.getParameter("appatUsuario");
            String apmatUsuario = request.getParameter("apmatUsuario");
            String sexoUsuario = request.getParameter("sexoUsuario");
            String fechaUsuario = request.getParameter("fechaUsuario");
            String correoUsuario = request.getParameter("correoUsuario");
            String userUsuario = request.getParameter("userUsuario");
            String passwordUsuario = request.getParameter("passwordUsuario");
            
            
            u.setNombreUsuario(nombreUsuario);
            u.setAppatUsuario(appatUsuario);
            u.setApmatUsuario(apmatUsuario);
            u.setSexoUsuario(sexoUsuario);
            u.setFechaUsuario(fechaUsuario);
            u.setCorreoUsuario(correoUsuario);
            u.setUserUsuario(userUsuario);
            u.setPasswordUsuario(passwordUsuario);
            
            
         
            usudao.agregar(u);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idUsuario", request.getParameter("idUsuario"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nombreUsuarioactu = request.getParameter("nombreUsuario");
            String appatUsuario = request.getParameter("appatUsuario");
            String apmatUsuario = request.getParameter("apmatUsuario");
            String sexoUsuario = request.getParameter("sexoUsuario");
            String fechaUsuario = request.getParameter("fechaUsuario");
            String userUsuario = request.getParameter("userUsuario");
            
            u.setIdUsuario(idUsuario);
            u.setNombreUsuario(nombreUsuarioactu);
            u.setAppatUsuario(appatUsuario);
            u.setApmatUsuario(apmatUsuario);
            u.setSexoUsuario(sexoUsuario);
            u.setFechaUsuario(fechaUsuario);
            u.setUserUsuario(userUsuario);
 
            usudao.editar(u);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            u.setIdUsuario(idUsuario);
            usudao.eliminar(idUsuario);
            
            acceso= listar;
        
        }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
