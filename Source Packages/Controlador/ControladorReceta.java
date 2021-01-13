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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
            String ingrediente1 = request.getParameter("ingrediente1");
            String ingrediente2 = request.getParameter("ingrediente2");
            String ingrediente3 = request.getParameter("ingrediente3");
            String ingrediente4 = request.getParameter("ingrediente4");
            String ingrediente5 = request.getParameter("ingrediente5");
            String ingrediente6 = request.getParameter("ingrediente6");
            String ingrediente7 = request.getParameter("ingrediente7");
            String ingrediente8 = request.getParameter("ingrediente8");
            String ingrediente9 = request.getParameter("ingrediente9");
            String ingrediente10 = request.getParameter("ingrediente10");
            String proceso1 = request.getParameter("proceso1");
            String proceso2 = request.getParameter("proceso2");
            String proceso3 = request.getParameter("proceso3");
            String proceso4 = request.getParameter("proceso4");
            String proceso5 = request.getParameter("proceso5");
            String proceso6 = request.getParameter("proceso6");
            String proceso7 = request.getParameter("proceso7");
            String proceso8 = request.getParameter("proceso8");
            String enfermedad = request.getParameter("enfermedad");
            String enfermedad2 = request.getParameter("enfermedad2");
            String enfermedad3 = request.getParameter("enfermedad3");
            int idCategoriasRecetas = Integer.parseInt(request.getParameter("idCategoriasRecetas"));
            
            r.setIdReceta(idReceta);
            r.setNombreReceta(nombreReceta);
            r.setImgReceta(imgReceta);
            r.setDescripcion(descripcion);
            r.setCaloriasReceta(caloriasReceta);
            r.setTiempoReceta(tiempoReceta);
            r.setPrecioReceta(precioReceta);
            r.setIngrediente1(ingrediente1);
            r.setIngrediente2(ingrediente2);
            r.setIngrediente3(ingrediente3);
            r.setIngrediente4(ingrediente4);
            r.setIngrediente5(ingrediente5);
            r.setIngrediente6(ingrediente6);
            r.setIngrediente7(ingrediente7);
            r.setIngrediente8(ingrediente8);
            r.setIngrediente9(ingrediente9);
            r.setIngrediente10(ingrediente10);
            r.setProceso1(proceso1);
            r.setProceso2(proceso2);
            r.setProceso3(proceso3);
            r.setProceso4(proceso4);
            r.setProceso5(proceso5);
            r.setProceso6(proceso6);
            r.setProceso7(proceso7);
            r.setProceso8(proceso8);
            r.setEnfermedad(enfermedad);
            r.setEnfermedad2(enfermedad2);
            r.setEnfermedad3(enfermedad3);
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
