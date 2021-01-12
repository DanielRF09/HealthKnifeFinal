
package ModeloDAO;

import Config.Conexion;
import Interfaces.ICRecetas;
import Modelo.CRecetas;
import Modelo.Receta;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CRecetasDAO implements ICRecetas{

    
    
    CRecetas cr = new CRecetas();
    
    @Override
    public boolean Agregar(CRecetas cre) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO crecetas(idReceta, idUsuario) VALUES ("+cre.getIdReceta()+", "+cre.getIdUsuario()+")";
        
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
    public List recetasGuardadas(int idUsuario) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<CRecetas>list = new ArrayList<>();
        
        String sql = "Select r.nombreReceta AS Receta, u.userUsuario, rel.idUsuario, r.idReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta,"
                + " r.ingrediente1, r.ingrediente2, r.ingrediente3, r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10,"
                + " r.proceso1, r.proceso2, r.proceso3, r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3 From receta AS r INNER JOIN crecetas AS rel ON r.idReceta = rel.idReceta INNER JOIN usuario AS u ON u.idUsuario = rel.idUsuario WHERE u.idUsuario="+idUsuario;
        
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                CRecetas cre = new CRecetas();
//                Receta r = new Receta();
//                Usuario u = new Usuario();
                
                
                cre.setReceta(rs.getString("Receta"));
                cre.setUserUsuario(rs.getString("userUsuario"));
                cre.setIdUsuario(rs.getInt("idUsuario"));
                cre.setIdReceta(rs.getInt("idReceta"));
                cre.setImgReceta(rs.getString("imgReceta"));
                cre.setDescripcion(rs.getString("descripcion"));
                cre.setCaloriasReceta(rs.getInt("caloriasReceta"));
                cre.setTiempoReceta(rs.getString("tiempoReceta"));
                cre.setPrecioReceta(rs.getDouble("precioReceta"));
                cre.setIngrediente1(rs.getString("ingrediente1"));
                cre.setIngrediente2(rs.getString("ingrediente2"));
                cre.setIngrediente3(rs.getString("ingrediente3"));
                cre.setIngrediente4(rs.getString("ingrediente4"));
                cre.setIngrediente5(rs.getString("ingrediente5"));
                cre.setIngrediente6(rs.getString("ingrediente6"));
                cre.setIngrediente7(rs.getString("ingrediente7"));
                cre.setIngrediente8(rs.getString("ingrediente8"));
                cre.setIngrediente9(rs.getString("ingrediente9"));
                cre.setIngrediente10(rs.getString("ingrediente10"));
                cre.setProceso1(rs.getString("proceso1"));
                cre.setProceso2(rs.getString("proceso2"));
                cre.setProceso3(rs.getString("proceso3"));
                cre.setProceso4(rs.getString("proceso4"));
                cre.setProceso5(rs.getString("proceso5"));
                cre.setProceso6(rs.getString("proceso6"));
                cre.setProceso7(rs.getString("proceso7"));
                cre.setProceso8(rs.getString("proceso8"));
                cre.setEnfermedad(rs.getString("enfermedad"));
                cre.setEnfermedad2(rs.getString("enfermedad2"));
                cre.setEnfermedad3(rs.getString("enfermedad3"));

                //agregamos el usuario
                list.add(cre);
                
 
            }
            
            //Cerramos conexiones
                con.close();
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return list;
        
    }

    @Override
    public CRecetas listrecetaGuardada(int idReceta) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "Select r.nombreReceta AS Receta, u.userUsuario, rel.idUsuario, r.idReceta, r.imgReceta, r.descripcion, r.caloriasReceta, r.tiempoReceta, r.precioReceta, "
                + " r.ingrediente1, r.ingrediente2, r.ingrediente3, r.ingrediente4, r.ingrediente5, r.ingrediente6, r.ingrediente7, r.ingrediente8, r.ingrediente9, r.ingrediente10,"
                + " r.proceso1, r.proceso2, r.proceso3, r.proceso4, r.proceso5, r.proceso6, r.proceso7, r.proceso8, r.enfermedad, r.enfermedad2, r.enfermedad3 From receta AS r INNER JOIN crecetas AS rel ON r.idReceta = rel.idReceta INNER JOIN usuario AS u ON u.idUsuario = rel.idUsuario WHERE r.idReceta="+idReceta;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                cr.setIdReceta(rs.getInt("idReceta"));
                cr.setReceta(rs.getString("Receta"));
                cr.setUserUsuario(rs.getString("userUsuario"));
                cr.setIdUsuario(rs.getInt("idUsuario"));
                cr.setImgReceta(rs.getString("imgReceta"));
                cr.setDescripcion(rs.getString("descripcion"));
                cr.setCaloriasReceta(rs.getInt("caloriasReceta"));
                cr.setTiempoReceta(rs.getString("tiempoReceta"));
                cr.setPrecioReceta(rs.getDouble("precioReceta"));
                cr.setIngrediente1(rs.getString("ingrediente1"));
                cr.setIngrediente2(rs.getString("ingrediente2"));
                cr.setIngrediente3(rs.getString("ingrediente3"));
                cr.setIngrediente4(rs.getString("ingrediente4"));
                cr.setIngrediente5(rs.getString("ingrediente5"));
                cr.setIngrediente6(rs.getString("ingrediente6"));
                cr.setIngrediente7(rs.getString("ingrediente7"));
                cr.setIngrediente8(rs.getString("ingrediente8"));
                cr.setIngrediente9(rs.getString("ingrediente9"));
                cr.setIngrediente10(rs.getString("ingrediente10"));
                cr.setProceso1(rs.getString("proceso1"));
                cr.setProceso2(rs.getString("proceso2"));
                cr.setProceso3(rs.getString("proceso3"));
                cr.setProceso4(rs.getString("proceso4"));
                cr.setProceso5(rs.getString("proceso5"));
                cr.setProceso6(rs.getString("proceso6"));
                cr.setProceso7(rs.getString("proceso7"));
                cr.setProceso8(rs.getString("proceso8"));
                cr.setEnfermedad(rs.getString("enfermedad"));
                cr.setEnfermedad2(rs.getString("enfermedad2"));
                cr.setEnfermedad3(rs.getString("enfermedad3"));
                
            }
            
            //Cerramos conexiones
                con.close();
                ps.close();
                rs.close();
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return cr;
    }
    
}
