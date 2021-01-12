package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.CRecetas;
import ModeloDAO.CRecetasDAO;

/**
 * Servlet implementation class ControladorCRecetas
 */
public class ControladorCRecetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String Agregar = "AgregarRecetaUsuario.jsp";
    String recetasGuardadas = "RecetasGuardadas.jsp";
    String listrecetaGuardada = "DetalleRecetaGuardada.jsp";
    CRecetas cre = new CRecetas();
    CRecetasDAO  recdao= new CRecetasDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCRecetas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCRecetas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("Agregar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            
            cre.setIdReceta(idReceta);
            cre.setIdUsuario(idUsuario);
            
            recdao.Agregar(cre);
            
            acceso = Agregar;   
        }else if(action.equalsIgnoreCase("recetasGuardadas")){
            
            request.setAttribute("idUsuario", request.getParameter("idUsuario"));
            acceso = recetasGuardadas;
        
        }else if (action.equalsIgnoreCase("listrecetaGuardada")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaGuardada;
            
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
        
        if (action.equalsIgnoreCase("Agregar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            
            cre.setIdReceta(idReceta);
            cre.setIdUsuario(idUsuario);
            
            recdao.Agregar(cre);
            
            acceso = Agregar;
            
            
        }else if(action.equalsIgnoreCase("recetasGuardadas")){
            
            request.setAttribute("idUsuario", request.getParameter("idUsuario"));
            acceso = recetasGuardadas;
        
        }else if (action.equalsIgnoreCase("listrecetaGuardada")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaGuardada;
            
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
