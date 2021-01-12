package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Blog;
import ModeloDAO.BlogDAO;

/**
 * Servlet implementation class ControladorBlog
 */
public class ControladorBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String listar = "listaBlog.jsp";
    String agregar = "AgregarBlog.jsp";
    String listarUsuarios = "BlogUsuarios.jsp";
    String listarNutriologos = "BlogNutriologos.jsp";
    String editar = "EditarBlog.jsp";
    
    Blog b = new Blog();
    BlogDAO  blodao= new BlogDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorBlog</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorBlog at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("listarUsuarios")) {
            
            acceso = listarUsuarios;
            
        }else if (action.equalsIgnoreCase("listarNutriologos")) {
            
            acceso = listarNutriologos;
            
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {

            String imgBlog = request.getParameter("imgBlog");
            String tituloBlog = request.getParameter("tituloBlog");
            String cuerpoBlog = request.getParameter("cuerpoBlog");

                       
            b.setImgBlog(imgBlog);
            b.setTituloBlog(tituloBlog);
            b.setCuerpoBlog(cuerpoBlog);

            
            
            //Agregamos los datos al modelo
            blodao.agregar(b);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idBlog", request.getParameter("idBlog"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idBlog = Integer.parseInt(request.getParameter("idBlog"));
            String imgBlog = request.getParameter("imgBlog");
            String tituloBlog = request.getParameter("tituloBlog");
            String cuerpoBlog = request.getParameter("cuerpoBlog");
            
            b.setIdBlog(idBlog);
            b.setImgBlog(imgBlog);
            b.setTituloBlog(tituloBlog);
            b.setCuerpoBlog(cuerpoBlog);
 
            blodao.editar(b);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idBlog = Integer.parseInt(request.getParameter("idBlog"));
            b.setIdBlog(idBlog);
            blodao.eliminar(idBlog);
            
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
            
        }else if (action.equalsIgnoreCase("listarUsuarios")) {
            
            acceso = listarUsuarios;
            
        }else if (action.equalsIgnoreCase("listarNutriologos")) {
            
            acceso = listarNutriologos;
            
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {

            String imgBlog = request.getParameter("imgBlog");
            String tituloBlog = request.getParameter("tituloBlog");
            String cuerpoBlog = request.getParameter("cuerpoBlog");

                       
            b.setImgBlog(imgBlog);
            b.setTituloBlog(tituloBlog);
            b.setCuerpoBlog(cuerpoBlog);

            
            
            //Agregamos los datos al modelo
            blodao.agregar(b);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idBlog", request.getParameter("idBlog"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idBlog = Integer.parseInt(request.getParameter("idBlog"));
            String imgBlog = request.getParameter("imgBlog");
            String tituloBlog = request.getParameter("tituloBlog");
            String cuerpoBlog = request.getParameter("cuerpoBlog");
            
            b.setIdBlog(idBlog);
            b.setImgBlog(imgBlog);
            b.setTituloBlog(tituloBlog);
            b.setCuerpoBlog(cuerpoBlog);
 
            blodao.editar(b);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idBlog = Integer.parseInt(request.getParameter("idBlog"));
            b.setIdBlog(idBlog);
            blodao.eliminar(idBlog);
            
            acceso= listar;
        
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
