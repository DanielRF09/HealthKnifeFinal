
package ModeloDAO;

import Config.Conexion;
import Interfaces.CrudBlog;
import Modelo.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BlogDAO implements CrudBlog{

    
    
    Blog b = new Blog();
    
    @Override
    public List listar() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Blog>list = new ArrayList<>();
        String sql = "Select * From Blog";
        
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Blog blo = new Blog();
                blo.setIdBlog(rs.getInt("idBlog"));
                blo.setImgBlog(rs.getString("imgBlog"));
                blo.setTituloBlog(rs.getString("tituloBlog"));
                blo.setCuerpoBlog(rs.getString("cuerpoBlog"));


                //agregamos el usuario
                list.add(blo);

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
    public List listarUsuarios() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Blog>list = new ArrayList<>();
        String sql = "Select * From Blog";
        
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Blog blo = new Blog();
                blo.setIdBlog(rs.getInt("idBlog"));
                blo.setImgBlog(rs.getString("imgBlog"));
                blo.setTituloBlog(rs.getString("tituloBlog"));
                blo.setCuerpoBlog(rs.getString("cuerpoBlog"));


                //agregamos el usuario
                list.add(blo);

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
    public List listarNutriologos() {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Blog>list = new ArrayList<>();
        String sql = "Select * From Blog";
        
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Blog blo = new Blog();
                blo.setIdBlog(rs.getInt("idBlog"));
                blo.setImgBlog(rs.getString("imgBlog"));
                blo.setTituloBlog(rs.getString("tituloBlog"));
                blo.setCuerpoBlog(rs.getString("cuerpoBlog"));


                //agregamos el usuario
                list.add(blo);
 
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
    public Blog list(int idBlog) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "Select * From Blog WHERE idBlog = "+idBlog;
        
        try{
        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                b.setIdBlog(rs.getInt("idBlog"));
                b.setImgBlog(rs.getString("imgBlog"));
                b.setTituloBlog(rs.getString("tituloBlog"));
                b.setCuerpoBlog(rs.getString("cuerpoBlog"));
                
            }
            
            //Cerramos conexiones
               
                ps.close();
                rs.close();
            
        }catch (Exception e){
        
            System.out.println("Error: "+ e);
        }
        return b;
        
    }

    @Override
    public boolean agregar(Blog blo) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "insert into Blog (imgBlog, tituloBlog, cuerpoBlog) values ('"+blo.getImgBlog()+"', '"+blo.getTituloBlog()+"', '"+blo.getCuerpoBlog()+"')";
        
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
    public boolean editar(Blog blo) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "UPDATE Blog SET imgBlog = '"+blo.getImgBlog()+"', tituloBlog = '"+blo.getTituloBlog()+"', cuerpoBlog = '"+blo.getCuerpoBlog()+"' WHERE idBlog = "+blo.getIdBlog()+"";
        
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
    public boolean editar_nut(Blog blo) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "UPDATE Blog SET imgBlog = '"+blo.getImgBlog()+"', tituloBlog = '"+blo.getTituloBlog()+"', cuerpoBlog = '"+blo.getCuerpoBlog()+"' WHERE idBlog = "+blo.getIdBlog()+"";
        
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
    public boolean eliminar(int idBlog) {
        
        //Variables de conexion BD
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "DELETE FROM Blog where idBlog="+idBlog;
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
