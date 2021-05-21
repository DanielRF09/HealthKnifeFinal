
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDRecetas;
import Modelo.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RecetaDAO implements CRUDRecetas{

    
    
    Receta r = new Receta();
    
    @Override
    public List listar() {
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        ArrayList<Receta>list = new ArrayList<>();
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingredientes,\n" +
                        "r.procesos, r.enfermedades, c.nombreCategoria \n" +
                        "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas ORDER by idReceta;";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Receta rec = new Receta();
                rec.setIdReceta(rs.getInt("idReceta"));
                rec.setNombreReceta(rs.getString("nombreReceta"));
                rec.setImgReceta(rs.getString("imgReceta"));
                rec.setDescripcion(rs.getString("descripcion"));
                rec.setCaloriasReceta(rs.getInt("caloriasReceta"));
                rec.setTiempoReceta(rs.getString("tiempoReceta"));
                rec.setPrecioReceta(rs.getDouble("precioReceta"));
                rec.setIngredientes(rs.getString("ingredientes"));
                rec.setProcesos(rs.getString("procesos"));
                rec.setEnfermedades(rs.getString("enfermedades"));
                rec.setNombreCategoria(rs.getString("nombreCategoria"));

                //agregamos el usuario
                list.add(rec);
 
            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list;
    }

    @Override
    public Receta list(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM receta WHERE idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                r.setIdReceta(rs.getInt("idReceta"));
                r.setNombreReceta(rs.getString("nombreReceta"));
                r.setImgReceta(rs.getString("imgReceta"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCaloriasReceta(rs.getInt("caloriasReceta"));
                r.setTiempoReceta(rs.getString("tiempoReceta"));
                r.setPrecioReceta(rs.getDouble("precioReceta"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setProcesos(rs.getString("procesos"));
                r.setEnfermedades(rs.getString("enfermedades"));
                r.setIdCategoriasRecetas(rs.getInt("idCategoriasRecetas"));

            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return r;
    }
    
    @Override
    public Receta listreceta(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM receta WHERE idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                r.setIdReceta(rs.getInt("idReceta"));
                r.setNombreReceta(rs.getString("nombreReceta"));
                r.setImgReceta(rs.getString("imgReceta"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCaloriasReceta(rs.getInt("caloriasReceta"));
                r.setTiempoReceta(rs.getString("tiempoReceta"));
                r.setPrecioReceta(rs.getDouble("precioReceta"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setProcesos(rs.getString("procesos"));
                r.setEnfermedades(rs.getString("enfermedades"));
                r.setIdCategoriasRecetas(rs.getInt("idCategoriasRecetas"));

            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return r;
    }
    
    @Override
    public Receta listrecetaPrincipal(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM receta WHERE idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                r.setIdReceta(rs.getInt("idReceta"));
                r.setNombreReceta(rs.getString("nombreReceta"));
                r.setImgReceta(rs.getString("imgReceta"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCaloriasReceta(rs.getInt("caloriasReceta"));
                r.setTiempoReceta(rs.getString("tiempoReceta"));
                r.setPrecioReceta(rs.getDouble("precioReceta"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setProcesos(rs.getString("procesos"));
                r.setEnfermedades(rs.getString("enfermedades"));
                r.setIdCategoriasRecetas(rs.getInt("idCategoriasRecetas"));

            }
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return r;
    }
    
    @Override
    public Receta listrecetaUsuario(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM receta WHERE idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                r.setIdReceta(rs.getInt("idReceta"));
                r.setNombreReceta(rs.getString("nombreReceta"));
                r.setImgReceta(rs.getString("imgReceta"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCaloriasReceta(rs.getInt("caloriasReceta"));
                r.setTiempoReceta(rs.getString("tiempoReceta"));
                r.setPrecioReceta(rs.getDouble("precioReceta"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setProcesos(rs.getString("procesos"));
                r.setEnfermedades(rs.getString("enfermedades"));
                r.setIdCategoriasRecetas(rs.getInt("idCategoriasRecetas"));

            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return r;
    }
    
    @Override
    public Receta listrecetaNutriologo(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM receta WHERE idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                r.setIdReceta(rs.getInt("idReceta"));
                r.setNombreReceta(rs.getString("nombreReceta"));
                r.setImgReceta(rs.getString("imgReceta"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCaloriasReceta(rs.getInt("caloriasReceta"));
                r.setTiempoReceta(rs.getString("tiempoReceta"));
                r.setPrecioReceta(rs.getDouble("precioReceta"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setProcesos(rs.getString("procesos"));
                r.setEnfermedades(rs.getString("enfermedades"));
                r.setIdCategoriasRecetas(rs.getInt("idCategoriasRecetas"));

            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return r;
    }
    
    
    
    @Override
    public List listarindexAdministrador() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Receta>list_index = new ArrayList<>();
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingredientes,\n" +
                "r.procesos, r.enfermedades, c.nombreCategoria \n" +
                "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas ORDER by idReceta;";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Receta rec = new Receta();
                rec.setIdReceta(rs.getInt("idReceta"));
                rec.setNombreReceta(rs.getString("nombreReceta"));
                rec.setImgReceta(rs.getString("imgReceta"));
                rec.setDescripcion(rs.getString("descripcion"));
                rec.setCaloriasReceta(rs.getInt("caloriasReceta"));
                rec.setTiempoReceta(rs.getString("tiempoReceta"));
                rec.setPrecioReceta(rs.getDouble("precioReceta"));
                rec.setIngredientes(rs.getString("ingredientes"));
                rec.setProcesos(rs.getString("procesos"));
                rec.setEnfermedades(rs.getString("enfermedades"));
                rec.setNombreCategoria(rs.getString("nombreCategoria"));
                
                //agregamos el usuario
                list_index.add(rec);

 
            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list_index;

    }
    
    @Override
    public List listarindexPrincipal() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Receta>list_index = new ArrayList<>();
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingredientes,\n" +
                "r.procesos, r.enfermedades, c.nombreCategoria \n" +
                "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas ORDER by idReceta;";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Receta rec = new Receta();
                rec.setIdReceta(rs.getInt("idReceta"));
                rec.setNombreReceta(rs.getString("nombreReceta"));
                rec.setImgReceta(rs.getString("imgReceta"));
                rec.setDescripcion(rs.getString("descripcion"));
                rec.setCaloriasReceta(rs.getInt("caloriasReceta"));
                rec.setTiempoReceta(rs.getString("tiempoReceta"));
                rec.setPrecioReceta(rs.getDouble("precioReceta"));
                rec.setIngredientes(rs.getString("ingredientes"));
                rec.setProcesos(rs.getString("procesos"));
                rec.setEnfermedades(rs.getString("enfermedades"));
                rec.setNombreCategoria(rs.getString("nombreCategoria"));

                //agregamos el usuario
                list_index.add(rec);
 
            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list_index;

    }
    
    @Override
    public List listarindexUsuario() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Receta>list_index = new ArrayList<>();
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingredientes,\n" +
                "r.procesos, r.enfermedades, c.nombreCategoria \n" +
                "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas ORDER by idReceta;";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Receta rec = new Receta();
                rec.setIdReceta(rs.getInt("idReceta"));
                rec.setNombreReceta(rs.getString("nombreReceta"));
                rec.setImgReceta(rs.getString("imgReceta"));
                rec.setDescripcion(rs.getString("descripcion"));
                rec.setCaloriasReceta(rs.getInt("caloriasReceta"));
                rec.setTiempoReceta(rs.getString("tiempoReceta"));
                rec.setPrecioReceta(rs.getDouble("precioReceta"));
                rec.setIngredientes(rs.getString("ingredientes"));
                rec.setProcesos(rs.getString("procesos"));
                rec.setEnfermedades(rs.getString("enfermedades"));
                rec.setNombreCategoria(rs.getString("nombreCategoria"));

                //agregamos el usuario
                list_index.add(rec);
 
            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list_index;

    }
    
    @Override
    public List listarindexNutriologo() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Receta>list_index = new ArrayList<>();
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingredientes,\n" +
                "r.procesos, r.enfermedades, c.nombreCategoria \n" +
                "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas ORDER by idReceta;";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Receta rec = new Receta();
                rec.setIdReceta(rs.getInt("idReceta"));
                rec.setNombreReceta(rs.getString("nombreReceta"));
                rec.setImgReceta(rs.getString("imgReceta"));
                rec.setDescripcion(rs.getString("descripcion"));
                rec.setCaloriasReceta(rs.getInt("caloriasReceta"));
                rec.setTiempoReceta(rs.getString("tiempoReceta"));
                rec.setPrecioReceta(rs.getDouble("precioReceta"));
                rec.setIngredientes(rs.getString("ingredientes"));
                rec.setProcesos(rs.getString("procesos"));
                rec.setEnfermedades(rs.getString("enfermedades"));
                rec.setNombreCategoria(rs.getString("nombreCategoria"));

                //agregamos el usuario
                list_index.add(rec);
 
            }
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list_index;

    }
    

    @Override
    public boolean agregar(Receta rec) {
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL agregarReceta('"+rec.getNombreReceta()+"','"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngredientes()+"', '"+rec.getProcesos()+"', '"+rec.getEnfermedades()+"', "+rec.getIdCategoriasRecetas()+" )";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                con.close();
                ps.close();
                
            
        } catch (Exception e) {
            
            System.err.println("Error: " + e);
            
        }
        
        
        return false;
    }

    @Override
    public boolean editar(Receta rec) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL actualizarRec("+rec.getIdReceta()+", '"+rec.getNombreReceta()+"', '"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngredientes()+"', '"+rec.getProcesos()+"', '"+rec.getEnfermedades()+"', "+rec.getIdCategoriasRecetas()+" )";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                
                ps.close();
               
            
        } catch (Exception e) {
        
            System.err.println("Error: "+e);
        
        }
        
        return false;
    }
    
    @Override
    public boolean editar_nut(Receta rec) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL actualizarRec("+rec.getIdReceta()+", '"+rec.getNombreReceta()+"', '"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngredientes()+"', '"+rec.getProcesos()+"', '"+rec.getEnfermedades()+"', "+rec.getIdCategoriasRecetas()+" )";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                
                ps.close();
               
            
        } catch (Exception e) {
        
            System.err.println("Error: "+e);
        
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "DELETE FROM receta where idReceta="+idReceta;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                
                ps.close();
                
            
        } catch (Exception e) {
        
            System.out.println("Error: " +e);
        
        }
        
        return false;

    }
    
}
