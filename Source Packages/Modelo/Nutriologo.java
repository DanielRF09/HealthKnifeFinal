
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
public class Nutriologo {
    
    //Variables
    int idNutriologo;
    String nombreNutriologo;
    String appatNutriologo;
    String apmatNutriologo;
    String sexoNutriologo;
    String fechaNutriologo;
    long telefonoNutriologo;
    String correoNutriologo;
    String userNutriologo;
    String passwordNutriologo;
    int idTipoUsuario;

    public Nutriologo() {
    }

    public Nutriologo(int idNutriologo, String nombreNutriologo, String appatNutriologo, String apmatNutriologo, String sexoNutriologo, String fechaNutriologo, long telefonoNutriologo, String correoNutriologo, String userNutriologo, String passwordNutriologo, int idTipoUsuario) {
        this.idNutriologo = idNutriologo;
        this.nombreNutriologo = nombreNutriologo;
        this.appatNutriologo = appatNutriologo;
        this.apmatNutriologo = apmatNutriologo;
        this.sexoNutriologo = sexoNutriologo;
        this.fechaNutriologo = fechaNutriologo;
        this.telefonoNutriologo = telefonoNutriologo;
        this.correoNutriologo = correoNutriologo;
        this.userNutriologo = userNutriologo;
        this.passwordNutriologo = passwordNutriologo;
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdNutriologo() {
        return idNutriologo;
    }

    public void setIdNutriologo(int idNutriologo) {
        this.idNutriologo = idNutriologo;
    }

    public String getNombreNutriologo() {
        return nombreNutriologo;
    }

    public void setNombreNutriologo(String nombreNutriologo) {
        this.nombreNutriologo = nombreNutriologo;
    }

    public String getAppatNutriologo() {
        return appatNutriologo;
    }

    public void setAppatNutriologo(String appatNutriologo) {
        this.appatNutriologo = appatNutriologo;
    }

    public String getApmatNutriologo() {
        return apmatNutriologo;
    }

    public void setApmatNutriologo(String apmatNutriologo) {
        this.apmatNutriologo = apmatNutriologo;
    }

    public String getSexoNutriologo() {
        return sexoNutriologo;
    }

    public void setSexoNutriologo(String sexoNutriologo) {
        this.sexoNutriologo = sexoNutriologo;
    }

    public String getFechaNutriologo() {
        return fechaNutriologo;
    }

    public void setFechaNutriologo(String fechaNutriologo) {
        this.fechaNutriologo = fechaNutriologo;
    }

    public long getTelefonoNutriologo() {
        return telefonoNutriologo;
    }

    public void setTelefonoNutriologo(long telefonoNutriologo) {
        this.telefonoNutriologo = telefonoNutriologo;
    }

    public String getCorreoNutriologo() {
        return correoNutriologo;
    }

    public void setCorreoNutriologo(String correoNutriologo) {
        this.correoNutriologo = correoNutriologo;
    }

    public String getUserNutriologo() {
        return userNutriologo;
    }

    public void setUserNutriologo(String userNutriologo) {
        this.userNutriologo = userNutriologo;
    }

    public String getPasswordNutriologo() {
        return passwordNutriologo;
    }

    public void setPasswordNutriologo(String passwordNutriologo) {
        this.passwordNutriologo = passwordNutriologo;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
    public static Nutriologo verificarNutriologoUser(String userNutriologo, int idTipoUsuario) throws SQLException, SQLException {
        Nutriologo nu = null;
        Conexion cn = new Conexion();
        Connection con;
        
        PreparedStatement pr;
        ResultSet rs;

        if (idTipoUsuario == 2) {
            try {
                con = cn.getConnection();
                String sql = "SELECT idNutriologo, nombreNutriologo, appatNutriologo, apmatNutriologo, sexoNutriologo, fechaNutriologo, telefonoNutriologo, aes_decrypt(correoNutriologo, 'BraceBlack'), aes_decrypt(userNutriologo, 'BraceBlack'), aes_decrypt(passwordNutriologo, 'BraceBlack'), idTipoUsuario FROM nutriologo WHERE userNutriologo = aes_encrypt(?, 'BraceBlack')";
                pr = con.prepareStatement(sql);
                pr.setString(1, userNutriologo);
                rs = pr.executeQuery();
                if (rs.next()) {
                    nu = new Nutriologo();
                    System.out.println("ESTE Nutriologo SI EXISTE");
                } else {
                    System.out.println("ESTE Nutriologo NO EXISTE");
                }
                
                con.close();
                pr.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("ERROR AL VERIFICAR USUARIO");
                ex.printStackTrace();
                nu = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo
                
            }
        }

        return nu;
    }
    
    public static Nutriologo verificarNutriologoEmail(String correoNutriologo, String passwordNutriologo, int idTipoUsuario) throws SQLException, SQLException {
        Nutriologo nu = null;
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
                String sql = "SELECT idNutriologo, nombreNutriologo, appatNutriologo, apmatNutriologo, sexoNutriologo, fechaNutriologo, telefonoNutriologo, aes_decrypt(correoNutriologo, 'BraceBlack'),\n"
                        + " aes_decrypt(userNutriologo, 'BraceBlack'), aes_decrypt(passwordNutriologo, 'BraceBlack'), idTipoUsuario\n"
                        + " FROM nutriologo WHERE correoNutriologo = aes_encrypt(?, 'BraceBlack') AND passwordNutriologo = aes_encrypt(?,'BraceBlack');";
                pr = con.prepareStatement(sql);
                pr.setString(1, correoNutriologo);
                pr.setString(2, passwordNutriologo);
                rs = pr.executeQuery();
                while (rs.next()) {
                    if (rs.getString("nombreNutriologo") != null) {
//                        Le asignamos todos los datos al objeto us que va a ser el dueño de la sesion activa

                        nu = new Nutriologo();
                        nu.setIdNutriologo(rs.getInt("idNutriologo"));
                        nu.setNombreNutriologo(rs.getString("nombreNutriologo"));
                        nu.setAppatNutriologo(rs.getString("appatNutriologo"));
                        nu.setApmatNutriologo(rs.getString("apmatNutriologo"));
                        //nu.setSexoNutriologo(rs.getString("sexoNutriologo"));
                        nu.setFechaNutriologo(rs.getString("fechaNutriologo"));
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
                nu = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo
                
            }
        }

        return nu;
    }
    
    
    
    
    
}
