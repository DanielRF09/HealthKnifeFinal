
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDUsuarios;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CRUDUsuarios{   
    
    Usuario u = new Usuario();
    
    @Override
    public List listar() {
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        ArrayList<Usuario>list = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Usuario usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setAppatUsuario(rs.getString("appatUsuario"));
                usu.setApmatUsuario(rs.getString("apmatUsuario"));
                usu.setSexoUsuario(rs.getString("sexoUsuario"));
                usu.setFechaUsuario(rs.getString("fechaUsuario"));
                usu.setCorreoUsuario(rs.getString("correoUsuario"));
                usu.setUserUsuario(rs.getString("userUsuario"));
                usu.setPasswordUsuario(rs.getString("passwordUsuario"));
                usu.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                usu.setIdTest(rs.getInt("idTest"));
                
                //agregamos el usuario
                list.add(usu);
                
 
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
    public Usuario list(int idUsuario) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE idUsuario="+idUsuario;
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombreUsuario(rs.getString("nombreUsuario"));
                u.setAppatUsuario(rs.getString("appatUsuario"));
                u.setApmatUsuario(rs.getString("apmatUsuario"));
                u.setSexoUsuario(rs.getString("sexoUsuario"));
                u.setFechaUsuario(rs.getString("fechaUsuario"));
                u.setCorreoUsuario(rs.getString("correoUsuario"));
                u.setUserUsuario(rs.getString("userUsuario"));
                u.setPasswordUsuario(rs.getString("passwordUsuario"));
                u.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.setIdTest(rs.getInt("idTest"));

            }
            
            //Cerramos conexiones
                
            con.close();
            ps.close();
            rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return u;
        
    }

    @Override
    public boolean agregar(Usuario usu) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL agregarUsu('"+usu.getNombreUsuario()+"','"+usu.getAppatUsuario()+"', '"+usu.getApmatUsuario()+"', '"+usu.getSexoUsuario()+"', '"+usu.getFechaUsuario()+"', '"+usu.getCorreoUsuario()+"', '"+usu.getUserUsuario()+"', '"+usu.getPasswordUsuario()+"')";
        
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
    public boolean editar(Usuario usu) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "CALL actualizarUsu("+usu.getIdUsuario()+", '"+usu.getNombreUsuario()+"','"+usu.getAppatUsuario()+"','"+usu.getApmatUsuario()+"', '"+usu.getSexoUsuario()+"', '"+usu.getFechaUsuario()+"', '"+usu.getUserUsuario()+"')";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            //Cerramos conexiones
                con.close();
                ps.close();
                
            
        } catch (Exception e) {
        
            System.err.println("Error: "+e);
        
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int idUsuario) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "DELETE FROM usuario where idUsuario="+idUsuario;
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
