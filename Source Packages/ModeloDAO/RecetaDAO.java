
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
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingrediente1, r.ingrediente2, r.ingrediente3,\n" +
                        "r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10, r.proceso1, r.proceso2, r.proceso3, \n" +
                        "r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3, c.nombreCategoria \n" +
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
                rec.setIngrediente1(rs.getString("ingrediente1"));
                rec.setIngrediente2(rs.getString("ingrediente2"));
                rec.setIngrediente3(rs.getString("ingrediente3"));
                rec.setIngrediente4(rs.getString("ingrediente4"));
                rec.setIngrediente5(rs.getString("ingrediente5"));
                rec.setIngrediente6(rs.getString("ingrediente6"));
                rec.setIngrediente7(rs.getString("ingrediente7"));
                rec.setIngrediente8(rs.getString("ingrediente8"));
                rec.setIngrediente9(rs.getString("ingrediente9"));
                rec.setIngrediente10(rs.getString("ingrediente10"));
                rec.setProceso1(rs.getString("proceso1"));
                rec.setProceso2(rs.getString("proceso2"));
                rec.setProceso3(rs.getString("proceso3"));
                rec.setProceso4(rs.getString("proceso4"));
                rec.setProceso5(rs.getString("proceso5"));
                rec.setProceso6(rs.getString("proceso6"));
                rec.setProceso7(rs.getString("proceso7"));
                rec.setProceso8(rs.getString("proceso8"));
                rec.setEnfermedad(rs.getString("enfermedad"));
                rec.setEnfermedad2(rs.getString("enfermedad2"));
                rec.setEnfermedad3(rs.getString("enfermedad3"));
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
                r.setIngrediente1(rs.getString("ingrediente1"));
                r.setIngrediente2(rs.getString("ingrediente2"));
                r.setIngrediente3(rs.getString("ingrediente3"));
                r.setIngrediente4(rs.getString("ingrediente4"));
                r.setIngrediente5(rs.getString("ingrediente5"));
                r.setIngrediente6(rs.getString("ingrediente6"));
                r.setIngrediente7(rs.getString("ingrediente7"));
                r.setIngrediente8(rs.getString("ingrediente8"));
                r.setIngrediente9(rs.getString("ingrediente9"));
                r.setIngrediente10(rs.getString("ingrediente10"));
                r.setProceso1(rs.getString("proceso1"));
                r.setProceso2(rs.getString("proceso2"));
                r.setProceso3(rs.getString("proceso3"));
                r.setProceso4(rs.getString("proceso4"));
                r.setProceso5(rs.getString("proceso5"));
                r.setProceso6(rs.getString("proceso6"));
                r.setProceso7(rs.getString("proceso7"));
                r.setProceso8(rs.getString("proceso8"));
                r.setEnfermedad(rs.getString("enfermedad"));
                r.setEnfermedad2(rs.getString("enfermedad2"));
                r.setEnfermedad3(rs.getString("enfermedad3"));
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
                r.setIngrediente1(rs.getString("ingrediente1"));
                r.setIngrediente2(rs.getString("ingrediente2"));
                r.setIngrediente3(rs.getString("ingrediente3"));
                r.setIngrediente4(rs.getString("ingrediente4"));
                r.setIngrediente5(rs.getString("ingrediente5"));
                r.setIngrediente6(rs.getString("ingrediente6"));
                r.setIngrediente7(rs.getString("ingrediente7"));
                r.setIngrediente8(rs.getString("ingrediente8"));
                r.setIngrediente9(rs.getString("ingrediente9"));
                r.setIngrediente10(rs.getString("ingrediente10"));
                r.setProceso1(rs.getString("proceso1"));
                r.setProceso2(rs.getString("proceso2"));
                r.setProceso3(rs.getString("proceso3"));
                r.setProceso4(rs.getString("proceso4"));
                r.setProceso5(rs.getString("proceso5"));
                r.setProceso6(rs.getString("proceso6"));
                r.setProceso7(rs.getString("proceso7"));
                r.setProceso8(rs.getString("proceso8"));
                r.setEnfermedad(rs.getString("enfermedad"));
                r.setEnfermedad2(rs.getString("enfermedad2"));
                r.setEnfermedad3(rs.getString("enfermedad3"));
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
                r.setIngrediente1(rs.getString("ingrediente1"));
                r.setIngrediente2(rs.getString("ingrediente2"));
                r.setIngrediente3(rs.getString("ingrediente3"));
                r.setIngrediente4(rs.getString("ingrediente4"));
                r.setIngrediente5(rs.getString("ingrediente5"));
                r.setIngrediente6(rs.getString("ingrediente6"));
                r.setIngrediente7(rs.getString("ingrediente7"));
                r.setIngrediente8(rs.getString("ingrediente8"));
                r.setIngrediente9(rs.getString("ingrediente9"));
                r.setIngrediente10(rs.getString("ingrediente10"));
                r.setProceso1(rs.getString("proceso1"));
                r.setProceso2(rs.getString("proceso2"));
                r.setProceso3(rs.getString("proceso3"));
                r.setProceso4(rs.getString("proceso4"));
                r.setProceso5(rs.getString("proceso5"));
                r.setProceso6(rs.getString("proceso6"));
                r.setProceso7(rs.getString("proceso7"));
                r.setProceso8(rs.getString("proceso8"));
                r.setEnfermedad(rs.getString("enfermedad"));
                r.setEnfermedad2(rs.getString("enfermedad2"));
                r.setEnfermedad3(rs.getString("enfermedad3"));
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
                r.setIngrediente1(rs.getString("ingrediente1"));
                r.setIngrediente2(rs.getString("ingrediente2"));
                r.setIngrediente3(rs.getString("ingrediente3"));
                r.setIngrediente4(rs.getString("ingrediente4"));
                r.setIngrediente5(rs.getString("ingrediente5"));
                r.setIngrediente6(rs.getString("ingrediente6"));
                r.setIngrediente7(rs.getString("ingrediente7"));
                r.setIngrediente8(rs.getString("ingrediente8"));
                r.setIngrediente9(rs.getString("ingrediente9"));
                r.setIngrediente10(rs.getString("ingrediente10"));
                r.setProceso1(rs.getString("proceso1"));
                r.setProceso2(rs.getString("proceso2"));
                r.setProceso3(rs.getString("proceso3"));
                r.setProceso4(rs.getString("proceso4"));
                r.setProceso5(rs.getString("proceso5"));
                r.setProceso6(rs.getString("proceso6"));
                r.setProceso7(rs.getString("proceso7"));
                r.setProceso8(rs.getString("proceso8"));
                r.setEnfermedad(rs.getString("enfermedad"));
                r.setEnfermedad2(rs.getString("enfermedad2"));
                r.setEnfermedad3(rs.getString("enfermedad3"));
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
                r.setIngrediente1(rs.getString("ingrediente1"));
                r.setIngrediente2(rs.getString("ingrediente2"));
                r.setIngrediente3(rs.getString("ingrediente3"));
                r.setIngrediente4(rs.getString("ingrediente4"));
                r.setIngrediente5(rs.getString("ingrediente5"));
                r.setIngrediente6(rs.getString("ingrediente6"));
                r.setIngrediente7(rs.getString("ingrediente7"));
                r.setIngrediente8(rs.getString("ingrediente8"));
                r.setIngrediente9(rs.getString("ingrediente9"));
                r.setIngrediente10(rs.getString("ingrediente10"));
                r.setProceso1(rs.getString("proceso1"));
                r.setProceso2(rs.getString("proceso2"));
                r.setProceso3(rs.getString("proceso3"));
                r.setProceso4(rs.getString("proceso4"));
                r.setProceso5(rs.getString("proceso5"));
                r.setProceso6(rs.getString("proceso6"));
                r.setProceso7(rs.getString("proceso7"));
                r.setProceso8(rs.getString("proceso8"));
                r.setEnfermedad(rs.getString("enfermedad"));
                r.setEnfermedad2(rs.getString("enfermedad2"));
                r.setEnfermedad3(rs.getString("enfermedad3"));
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
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingrediente1, r.ingrediente2, r.ingrediente3,\n" +
                "r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10, r.proceso1, r.proceso2, r.proceso3, \n" +
                "r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3, c.nombreCategoria \n" +
                "From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas;";
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
                rec.setIngrediente1(rs.getString("ingrediente1"));
                rec.setIngrediente2(rs.getString("ingrediente2"));
                rec.setIngrediente3(rs.getString("ingrediente3"));
                rec.setIngrediente4(rs.getString("ingrediente4"));
                rec.setIngrediente5(rs.getString("ingrediente5"));
                rec.setIngrediente6(rs.getString("ingrediente6"));
                rec.setIngrediente7(rs.getString("ingrediente7"));
                rec.setIngrediente8(rs.getString("ingrediente8"));
                rec.setIngrediente9(rs.getString("ingrediente9"));
                rec.setIngrediente10(rs.getString("ingrediente10"));
                rec.setProceso1(rs.getString("proceso1"));
                rec.setProceso2(rs.getString("proceso2"));
                rec.setProceso3(rs.getString("proceso3"));
                rec.setProceso4(rs.getString("proceso4"));
                rec.setProceso5(rs.getString("proceso5"));
                rec.setProceso6(rs.getString("proceso6"));
                rec.setProceso7(rs.getString("proceso7"));
                rec.setProceso8(rs.getString("proceso8"));
                rec.setEnfermedad(rs.getString("enfermedad"));
                rec.setEnfermedad2(rs.getString("enfermedad2"));
                rec.setEnfermedad3(rs.getString("enfermedad3"));
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
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingrediente1, r.ingrediente2, r.ingrediente3,\n" +
"r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10, r.proceso1, r.proceso2, r.proceso3, \n" +
"r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3, c.nombreCategoria \n" +
"From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas;";
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
                rec.setIngrediente1(rs.getString("ingrediente1"));
                rec.setIngrediente2(rs.getString("ingrediente2"));
                rec.setIngrediente3(rs.getString("ingrediente3"));
                rec.setIngrediente4(rs.getString("ingrediente4"));
                rec.setIngrediente5(rs.getString("ingrediente5"));
                rec.setIngrediente6(rs.getString("ingrediente6"));
                rec.setIngrediente7(rs.getString("ingrediente7"));
                rec.setIngrediente8(rs.getString("ingrediente8"));
                rec.setIngrediente9(rs.getString("ingrediente9"));
                rec.setIngrediente10(rs.getString("ingrediente10"));
                rec.setProceso1(rs.getString("proceso1"));
                rec.setProceso2(rs.getString("proceso2"));
                rec.setProceso3(rs.getString("proceso3"));
                rec.setProceso4(rs.getString("proceso4"));
                rec.setProceso5(rs.getString("proceso5"));
                rec.setProceso6(rs.getString("proceso6"));
                rec.setProceso7(rs.getString("proceso7"));
                rec.setProceso8(rs.getString("proceso8"));
                rec.setEnfermedad(rs.getString("enfermedad"));
                rec.setEnfermedad2(rs.getString("enfermedad2"));
                rec.setEnfermedad3(rs.getString("enfermedad3"));
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
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingrediente1, r.ingrediente2, r.ingrediente3,\n" +
"r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10, r.proceso1, r.proceso2, r.proceso3, \n" +
"r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3, c.nombreCategoria \n" +
"From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas;";
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
                rec.setIngrediente1(rs.getString("ingrediente1"));
                rec.setIngrediente2(rs.getString("ingrediente2"));
                rec.setIngrediente3(rs.getString("ingrediente3"));
                rec.setIngrediente4(rs.getString("ingrediente4"));
                rec.setIngrediente5(rs.getString("ingrediente5"));
                rec.setIngrediente6(rs.getString("ingrediente6"));
                rec.setIngrediente7(rs.getString("ingrediente7"));
                rec.setIngrediente8(rs.getString("ingrediente8"));
                rec.setIngrediente9(rs.getString("ingrediente9"));
                rec.setIngrediente10(rs.getString("ingrediente10"));
                rec.setProceso1(rs.getString("proceso1"));
                rec.setProceso2(rs.getString("proceso2"));
                rec.setProceso3(rs.getString("proceso3"));
                rec.setProceso4(rs.getString("proceso4"));
                rec.setProceso5(rs.getString("proceso5"));
                rec.setProceso6(rs.getString("proceso6"));
                rec.setProceso7(rs.getString("proceso7"));
                rec.setProceso8(rs.getString("proceso8"));
                rec.setEnfermedad(rs.getString("enfermedad"));
                rec.setEnfermedad2(rs.getString("enfermedad2"));
                rec.setEnfermedad3(rs.getString("enfermedad3"));
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
        String sql = "Select r.idReceta, r.nombreReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, r.ingrediente1, r.ingrediente2, r.ingrediente3,\n" +
"r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10, r.proceso1, r.proceso2, r.proceso3, \n" +
"r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3, c.nombreCategoria \n" +
"From receta AS r INNER JOIN categoriasrecetas AS c ON r.idCategoriasRecetas=c.idCategoriasRecetas;";
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
                rec.setIngrediente1(rs.getString("ingrediente1"));
                rec.setIngrediente2(rs.getString("ingrediente2"));
                rec.setIngrediente3(rs.getString("ingrediente3"));
                rec.setIngrediente4(rs.getString("ingrediente4"));
                rec.setIngrediente5(rs.getString("ingrediente5"));
                rec.setIngrediente6(rs.getString("ingrediente6"));
                rec.setIngrediente7(rs.getString("ingrediente7"));
                rec.setIngrediente8(rs.getString("ingrediente8"));
                rec.setIngrediente9(rs.getString("ingrediente9"));
                rec.setIngrediente10(rs.getString("ingrediente10"));
                rec.setProceso1(rs.getString("proceso1"));
                rec.setProceso2(rs.getString("proceso2"));
                rec.setProceso3(rs.getString("proceso3"));
                rec.setProceso4(rs.getString("proceso4"));
                rec.setProceso5(rs.getString("proceso5"));
                rec.setProceso6(rs.getString("proceso6"));
                rec.setProceso7(rs.getString("proceso7"));
                rec.setProceso8(rs.getString("proceso8"));
                rec.setEnfermedad(rs.getString("enfermedad"));
                rec.setEnfermedad2(rs.getString("enfermedad2"));
                rec.setEnfermedad3(rs.getString("enfermedad3"));
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
        String sql = "CALL agregarReceta('"+rec.getNombreReceta()+"','"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngrediente1()+"', '"+rec.getIngrediente2()+"', '"+rec.getIngrediente3()+"', '"+rec.getIngrediente4()+"', '"+rec.getIngrediente5()+"', '"+rec.getIngrediente6()+"', '"+rec.getIngrediente7()+"', '"+rec.getIngrediente8()+"', '"+rec.getIngrediente9()+"', '"+rec.getIngrediente10()+"', '"+rec.getProceso1()+"', '"+rec.getProceso2()+"', '"+rec.getProceso3()+"', '"+rec.getProceso4()+"', '"+rec.getProceso5()+"', '"+rec.getProceso6()+"', '"+rec.getProceso7()+"', '"+rec.getProceso8()+"', '"+rec.getEnfermedad()+"', '"+rec.getEnfermedad2()+"', '"+rec.getEnfermedad3()+"', "+rec.getIdCategoriasRecetas()+" )";
        
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
        String sql = "CALL actualizarRec("+rec.getIdReceta()+", '"+rec.getNombreReceta()+"', '"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngrediente1()+"', '"+rec.getIngrediente2()+"', '"+rec.getIngrediente3()+"', '"+rec.getIngrediente4()+"', '"+rec.getIngrediente5()+"', '"+rec.getIngrediente6()+"', '"+rec.getIngrediente7()+"', '"+rec.getIngrediente8()+"', '"+rec.getIngrediente9()+"', '"+rec.getIngrediente10()+"', '"+rec.getProceso1()+"', '"+rec.getProceso2()+"', '"+rec.getProceso3()+"', '"+rec.getProceso4()+"', '"+rec.getProceso5()+"', '"+rec.getProceso6()+"', '"+rec.getProceso7()+"', '"+rec.getProceso8()+"', '"+rec.getEnfermedad()+"', '"+rec.getEnfermedad2()+"', '"+rec.getEnfermedad3()+"', "+rec.getIdCategoriasRecetas()+" )";
        
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
        String sql = "CALL actualizarRec("+rec.getIdReceta()+", '"+rec.getNombreReceta()+"', '"+rec.getImgReceta()+"', '"+rec.getDescripcion()+"', "+rec.getCaloriasReceta()+", '"+rec.getTiempoReceta()+"', "+rec.getPrecioReceta()+", '"+rec.getIngrediente1()+"', '"+rec.getIngrediente2()+"', '"+rec.getIngrediente3()+"', '"+rec.getIngrediente4()+"', '"+rec.getIngrediente5()+"', '"+rec.getIngrediente6()+"', '"+rec.getIngrediente7()+"', '"+rec.getIngrediente8()+"', '"+rec.getIngrediente9()+"', '"+rec.getIngrediente10()+"', '"+rec.getProceso1()+"', '"+rec.getProceso2()+"', '"+rec.getProceso3()+"', '"+rec.getProceso4()+"', '"+rec.getProceso5()+"', '"+rec.getProceso6()+"', '"+rec.getProceso7()+"', '"+rec.getProceso8()+"', '"+rec.getEnfermedad()+"', '"+rec.getEnfermedad2()+"', '"+rec.getEnfermedad3()+"', "+rec.getIdCategoriasRecetas()+" )";
        
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
