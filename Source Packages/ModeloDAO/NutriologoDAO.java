
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDNutriologos;
import Modelo.Nutriologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NutriologoDAO implements CRUDNutriologos{

    Nutriologo n = new Nutriologo();
    
    @Override
    public List listar() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Nutriologo>list = new ArrayList<>();
        String sql = "SELECT * FROM nutriologo";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Nutriologo nut = new Nutriologo();
                nut.setIdNutriologo(rs.getInt("idNutriologo"));
                nut.setNombreNutriologo(rs.getString("nombreNutriologo"));
                nut.setAppatNutriologo(rs.getString("appatNutriologo"));
                nut.setApmatNutriologo(rs.getString("apmatNutriologo"));
                nut.setSexoNutriologo(rs.getString("sexoNutriologo"));
                nut.setFechaNutriologo(rs.getString("fechaNutriologo"));
                nut.setTelefonoNutriologo(rs.getLong("telefonoNutriologo"));
                nut.setCorreoNutriologo(rs.getString("correoNutriologo"));
                nut.setUserNutriologo(rs.getString("userNutriologo"));
                nut.setPasswordNutriologo(rs.getString("passwordNutriologo"));
                nut.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
               
                
                //agregamos el usuario
                list.add(nut);
                
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
    public Nutriologo list(int idNutriologo) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM nutriologo WHERE idNutriologo="+idNutriologo;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                n.setIdNutriologo(rs.getInt("idNutriologo"));
                n.setNombreNutriologo(rs.getString("nombreNutriologo"));
                n.setAppatNutriologo(rs.getString("appatNutriologo"));
                n.setApmatNutriologo(rs.getString("apmatNutriologo"));
                n.setSexoNutriologo(rs.getString("sexoNutriologo"));
                n.setFechaNutriologo(rs.getString("fechaNutriologo"));
                n.setTelefonoNutriologo(rs.getLong("telefonoNutriologo"));
                n.setCorreoNutriologo(rs.getString("correoNutriologo"));
                n.setUserNutriologo(rs.getString("userNutriologo"));
                n.setPasswordNutriologo(rs.getString("passwordNutriologo"));
                n.setIdTipoUsuario(rs.getInt("idTipoUsuario"));

            }
            
            //Cerramos conexiones
                
            con.close();
            ps.close();
            rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return n;
    }

    @Override
    public boolean agregar(Nutriologo nut) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL agregarNutri('"+nut.getNombreNutriologo()+"','"+nut.getAppatNutriologo()+"', '"+nut.getApmatNutriologo()+"', '"+nut.getSexoNutriologo()+"', '"+nut.getFechaNutriologo()+"', "+nut.getTelefonoNutriologo()+", '"+nut.getCorreoNutriologo()+"', '"+nut.getUserNutriologo()+"', '"+nut.getPasswordNutriologo()+"')";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                
                ps.close();
                
            
        } catch (Exception e) {
            
            System.err.println("Error: " + e);
            
        }
        
        
        return false;
        
    }

    @Override
    public boolean editar(Nutriologo nut) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL actualizarNut("+nut.getIdNutriologo()+", '"+nut.getNombreNutriologo()+"','"+nut.getAppatNutriologo()+"','"+nut.getApmatNutriologo()+"', '"+nut.getSexoNutriologo()+"', '"+nut.getFechaNutriologo()+"', "+nut.getTelefonoNutriologo()+", '"+nut.getUserNutriologo()+"')";
    
        
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
    public boolean eliminar(int idNutriologo) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "DELETE FROM nutriologo where idNutriologo="+idNutriologo;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                con.close();
                ps.close();
                
            
        } catch (Exception e) {
        
            System.out.println("Error: " +e);
        
        }
        
        return false;
    }
    
}
