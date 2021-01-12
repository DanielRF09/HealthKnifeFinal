package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Administrador {
    
    //Variables
    int idAdministrador;
    String nombreAdmin;
    String appatAdmin;
    String apmatAdmin;
    String fechaAdmin;
    long telefonoAdmin;
    String correoAdmin;
    String userAdmin;
    String passwordAdmin;
    int idTipoUsuario;
    
    //CConstructor

    public Administrador() {
    }

    public Administrador(int idAdministrador, String nombreAdmin, String appatAdmin, String apmatAdmin, String fechaAdmin, long telefonoAdmin, String correoAdmin, String userAdmin, String passwordAdmin, int idTipoUsuario) {
        this.idAdministrador = idAdministrador;
        this.nombreAdmin = nombreAdmin;
        this.appatAdmin = appatAdmin;
        this.apmatAdmin = apmatAdmin;
        this.fechaAdmin = fechaAdmin;
        this.telefonoAdmin = telefonoAdmin;
        this.correoAdmin = correoAdmin;
        this.userAdmin = userAdmin;
        this.passwordAdmin = passwordAdmin;
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getAppatAdmin() {
        return appatAdmin;
    }

    public void setAppatAdmin(String appatAdmin) {
        this.appatAdmin = appatAdmin;
    }

    public String getApmatAdmin() {
        return apmatAdmin;
    }

    public void setApmatAdmin(String apmatAdmin) {
        this.apmatAdmin = apmatAdmin;
    }

    public String getFechaAdmin() {
        return fechaAdmin;
    }

    public void setFechaAdmin(String fechaAdmin) {
        this.fechaAdmin = fechaAdmin;
    }

    public long getTelefonoAdmin() {
        return telefonoAdmin;
    }

    public void setTelefonoAdmin(long telefonoAdmin) {
        this.telefonoAdmin = telefonoAdmin;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public static Administrador verificarAdministradorUser(String userAdmin, int idTipoUsuario) throws SQLException, SQLException {
        Administrador ad = null;
        Conexion cn = new Conexion();
        Connection con;
        
        PreparedStatement pr;
        ResultSet rs;

        if (idTipoUsuario == 2) {
            try {
                con = cn.getConnection();
                String sql = "SELECT idAdministrador, nombreAdmin, appatAdmin, apmatAdmin, fechaAdmin, telefonoAdmin, aes_decrypt(correoAdmin, 'BraceBlack'),\n"
                        + " aes_decrypt(userAdmin, 'BraceBlack'), aes_decrypt(passwordAdmin, 'BraceBlack'), idTipoUsuario\n"
                        + " FROM administrador WHERE userAdmin = aes_encrypt(?, 'BraceBlack')";
                pr = con.prepareStatement(sql);
                pr.setString(1, userAdmin);
                rs = pr.executeQuery();
                if (rs.next()) {
                    ad = new Administrador();
                    System.out.println("ESTE ADMINISTRADOR SI EXISTE");
                } else {
                    System.out.println("ESTE ADMINISTRADOR NO EXISTE");
                }
                
                con.close();
                pr.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("ERROR AL VERIFICAR USUARIO");
                ex.printStackTrace();
                ad = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo
                
            }
        }

        return ad;
    }
    
    
    public static Administrador verificarAdministradorEmail(String correoAdmin, String passwordAdmin, int idTipoUsuario) throws SQLException, SQLException {
        Administrador ad = null;
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement pr;
        ResultSet rs;

        if (idTipoUsuario == 1) {
//            INICIO DE SESION
            System.out.println("Estas iniciando sesion UwU");
            try {
                con = cn.getConnection();
//                Este es el String para MYSQL
//                String sql = "SELECT * FROM Usuario WHERE correoUsuario = ? AND passwordUsuario = ?";
                String sql = "SELECT idAdministrador, nombreAdmin, appatAdmin, apmatAdmin, fechaAdmin, telefonoAdmin, aes_decrypt(correoAdmin, 'BraceBlack'), aes_decrypt(userAdmin, 'BraceBlack'), aes_decrypt(passwordAdmin, 'BraceBlack'), idTipoUsuario FROM administrador WHERE correoAdmin = aes_encrypt(?, 'BraceBlack') AND passwordAdmin = aes_encrypt(?,'BraceBlack');";
                pr = con.prepareStatement(sql);
                pr.setString(1, correoAdmin);
                pr.setString(2, passwordAdmin);
                rs = pr.executeQuery();
                while (rs.next()) {
                    if (rs.getString("nombreAdmin") != null) {
//                        Le asignamos todos los datos al objeto us que va a ser el dueño de la sesion activa

                        ad = new Administrador();
                        ad.setIdAdministrador(rs.getInt("idAdministrador"));
                        ad.setNombreAdmin(rs.getString("nombreAdmin"));
                        ad.setAppatAdmin(rs.getString("appatAdmin"));
                        ad.setApmatAdmin(rs.getString("apmatAdmin"));
                        ad.setFechaAdmin(rs.getString("fechaAdmin"));
                        //ad.setTelefonoAdmin(rs.getInt("telefonoAdmin"));
//                        Estos datos no los vamos a pedir para evitarnos problemas
//                        us.setCorreo(rs.getString("correoUsuario"));
//                        us.setUserName(rs.getString("userUsuario"));
//                        us.setPassword(rs.getString("passwordUsuario"));
                    }
                }
                
                con.close();
                pr.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("ERROR AL VERIFICAR USUARIO");
                System.out.println("VERIFICAR EMAIL");
                ex.printStackTrace();
                ad = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo
                
            }
        }

        return ad;
    }
    
    
}
