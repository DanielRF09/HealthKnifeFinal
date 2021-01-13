
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDAdministradores;
import Modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AdministradorDAO implements CRUDAdministradores {

    //Variables de conexion BD
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Administrador a = new Administrador();
    
    @Override
    public List listar() {
        
        ArrayList<Administrador>list = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Administrador adm = new Administrador();
                adm.setIdAdministrador(rs.getInt("idAdministrador"));
                adm.setNombreAdmin(rs.getString("nombreAdmin"));
                adm.setAppatAdmin(rs.getString("appatAdmin"));
                adm.setApmatAdmin(rs.getString("apmatAdmin"));
                adm.setFechaAdmin(rs.getString("fechaAdmin"));
                adm.setTelefonoAdmin(rs.getLong("telefonoAdmin"));
                adm.setCorreoAdmin(rs.getString("correoAdmin"));
                adm.setUserAdmin(rs.getString("userAdmin"));
                adm.setPasswordAdmin(rs.getString("passwordAdmin"));
                adm.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
   
                //agregamos el usuario
                list.add(adm);

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
    public Administrador list(int idAdministrador) {
        String sql = "SELECT * FROM administrador WHERE idAdministrador="+idAdministrador;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                a.setIdAdministrador(rs.getInt("idAdministrador"));
                a.setNombreAdmin(rs.getString("nombreAdmin"));
                a.setAppatAdmin(rs.getString("appatAdmin"));
                a.setApmatAdmin(rs.getString("apmatAdmin"));
                a.setFechaAdmin(rs.getString("fechaAdmin"));
                a.setTelefonoAdmin(rs.getLong("telefonoAdmin"));
                a.setCorreoAdmin(rs.getString("correoAdmin"));
                a.setUserAdmin(rs.getString("userAdmin"));
                a.setPasswordAdmin(rs.getString("passwordAdmin"));
                a.setIdTipoUsuario(rs.getInt("idTipoUsuario"));

            }
            
            //Cerramos conexiones
                
            con.close();
            ps.close();
            rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return a;
    }

    @Override
    public boolean agregar(Administrador adm) {
        String sql = "CALL agregarAdmin('"+adm.getNombreAdmin()+"','"+adm.getAppatAdmin()+"', '"+adm.getApmatAdmin()+"', '"+adm.getFechaAdmin()+"', "+adm.getTelefonoAdmin()+", '"+adm.getCorreoAdmin()+"', '"+adm.getUserAdmin()+"', '"+adm.getPasswordAdmin()+"')";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
        } catch (Exception e) {
            
            System.err.println("Error: " + e);
            
        }
        
        
        return false;
    }

    @Override
    public boolean editar(Administrador adm) {
        String sql = "CALL actualizarAdm("+adm.getIdAdministrador()+", '"+adm.getNombreAdmin()+"', '"+adm.getAppatAdmin()+"', '"+adm.getApmatAdmin()+"', '"+adm.getFechaAdmin()+"', "+adm.getTelefonoAdmin()+", '"+adm.getUserAdmin()+"')";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
        } catch (Exception e) {
        
            System.err.println("Error: "+e);
        
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int idAdministrador) {
        String sql = "DELETE FROM administrador where idAdministrador="+idAdministrador;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            
            //Cerramos conexiones
                
                ps.close();
                rs.close();
        } catch (Exception e) {
        
            System.out.println("Error: " +e);
        
        }
        
        return false;
    }
    
    
}
