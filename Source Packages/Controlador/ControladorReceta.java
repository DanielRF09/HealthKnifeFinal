package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Receta;
import ModeloDAO.RecetaDAO;

/**
 * Servlet implementation class ControladorReceta
 */
public class ControladorReceta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String listar = "listaRecetas.jsp";
    String listarindexAdministrador = "indexAdmin.jsp";
    String listarindexPrincipal = "RecetasPrincipal.jsp";
    String listarindexUsuario = "Recetas.jsp";
    String listarindexNutriologo = "indexNutriologo.jsp";
    String listreceta = "DetalleReceta.jsp";
    String listrecetaPrincipal = "DetalleRecetaPrincipal.jsp";
    String listrecetaUsuario = "DetalleRecetaUsuario.jsp";
    String listrecetaNutriologo = "DetalleRecetaNutriologo.jsp";
    String agregar = "AgregarReceta.jsp";
    String editar = "EditarReceta.jsp";
    String editar_nut = "EditarRecetaNut.jsp";
    Receta r = new Receta();
    RecetaDAO  recdao= new RecetaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorReceta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReceta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            
            acceso = listar;
            
        }else if(action.equalsIgnoreCase("listarindexAdministrador")){
        
            acceso = listarindexAdministrador;
        
        }else if(action.equalsIgnoreCase("listarindexPrincipal")){
        
            acceso = listarindexPrincipal;
        
        }else if(action.equalsIgnoreCase("listarindexUsuario")){
        
            acceso = listarindexUsuario;
        
        }else if(action.equalsIgnoreCase("listarindexNutriologo")){
        
            acceso = listarindexNutriologo;
        
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {
            
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
            
            
            //Agregamos los datos al modelo
            recdao.agregar(r);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("editar_nut")) {
            
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= editar_nut;
            
        }else if (action.equalsIgnoreCase("listreceta")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listreceta;
            
        }else if (action.equalsIgnoreCase("listrecetaPrincipal")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaPrincipal;
            
        }else if (action.equalsIgnoreCase("listrecetaUsuario")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaUsuario;
            
        }else if (action.equalsIgnoreCase("listrecetaNutriologo")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaNutriologo;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
 
            recdao.editar(r);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("ActualizarNut")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
 
            recdao.editar(r);
            
            acceso = listarindexNutriologo;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            r.setIdReceta(idReceta);
            recdao.eliminar(idReceta);
            
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
            
        }else if(action.equalsIgnoreCase("listarindexAdministrador")){
        
            acceso = listarindexAdministrador;
        
        }else if(action.equalsIgnoreCase("listarindexPrincipal")){
        
            acceso = listarindexPrincipal;
        
        }else if(action.equalsIgnoreCase("listarindexUsuario")){
        
            acceso = listarindexUsuario;
        
        }else if(action.equalsIgnoreCase("listarindexNutriologo")){
        
            acceso = listarindexNutriologo;
        
        }else if (action.equalsIgnoreCase("agregar")) {
            
            acceso = agregar;
            
        }else if (action.equalsIgnoreCase("Registrar")) {
            
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
            
            
            //Agregamos los datos al modelo
            recdao.agregar(r);
            
            acceso=listar;
            
        }else if (action.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= editar;
            
        }else if (action.equalsIgnoreCase("listreceta")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listreceta;
            
        }else if (action.equalsIgnoreCase("listrecetaPrincipal")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaPrincipal;
            
        }else if (action.equalsIgnoreCase("listrecetaUsuario")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaUsuario;
            
        }else if (action.equalsIgnoreCase("listrecetaNutriologo")){
        
            request.setAttribute("idReceta", request.getParameter("idReceta"));
            acceso= listrecetaNutriologo;
            
        }else if (action.equalsIgnoreCase("Actualizar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
 
            recdao.editar(r);
            
            acceso = listar;
            
        }else if (action.equalsIgnoreCase("ActualizarNut")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            String nombreReceta = request.getParameter("nombreReceta");
            String imgReceta = request.getParameter("imgReceta");
            String descripcion = request.getParameter("descripcion");
            int caloriasReceta = Integer.parseInt(request.getParameter("caloriasReceta"));
            String tiempoReceta = request.getParameter("tiempoReceta");
            Double precioReceta = Double.parseDouble(request.getParameter("precioReceta"));
            String ingredientes = request.getParameter("ingredientes");
            String procesos = request.getParameter("procesos");
            String enfermedades = request.getParameter("enfermedades");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngredientes(ingredientes);
            r.setProcesos(procesos);
            r.setEnfermedades(enfermedades);
            r.setIdCategoriasRecetas(idCategoriasRecetas);
 
            recdao.editar(r);
            
            acceso = listarindexNutriologo;
            
        }else if (action.equalsIgnoreCase("eliminar")) {
            
            int idReceta = Integer.parseInt(request.getParameter("idReceta"));
            r.setIdReceta(idReceta);
            recdao.eliminar(idReceta);
            
            acceso= listar;
        
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
		
	}
	
	public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
