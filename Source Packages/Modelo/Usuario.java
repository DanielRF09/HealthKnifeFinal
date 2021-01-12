
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    
    //Variables
    int idUsuario;
    String nombreUsuario;
    String appatUsuario;
    String apmatUsuario;
    String sexoUsuario;
    String fechaUsuario;
    String correoUsuario;
    String userUsuario;
    String passwordUsuario;
    int idTipoUsuario;
    int idTest;

    //Constructor
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String appatUsuario, String apmatUsuario, String sexoUsuario, String fechaUsuario, String correoUsuario, String userUsuario, String passwordUsuario, int idTipoUsuario, int idTest) {
        this.nombreUsuario = nombreUsuario;
        this.appatUsuario = appatUsuario;
        this.apmatUsuario = apmatUsuario;
        this.sexoUsuario = sexoUsuario;
        this.fechaUsuario = fechaUsuario;
        this.correoUsuario = correoUsuario;
        this.userUsuario = userUsuario;
        this.passwordUsuario = passwordUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idTest = idTest;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getAppatUsuario() {
        return appatUsuario;
    }

    public void setAppatUsuario(String appatUsuario) {
        this.appatUsuario = appatUsuario;
    }

    public String getApmatUsuario() {
        return apmatUsuario;
    }

    public void setApmatUsuario(String apmatUsuario) {
        this.apmatUsuario = apmatUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(String fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
 
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
    
    
    
    public static Usuario verificarUsuarioUser(String userUsuario, int tipo) throws SQLException, SQLException {
        Usuario us = null;
        Conexion cn = new Conexion();
        Connection con;
        
        PreparedStatement pr;
        ResultSet rs;

        if (tipo == 2 || tipo == 4) {
            try {
                con = cn.getConnection();
                String sql = "SELECT idUsuario, nombreUsuario, appatUsuario, apmatUsuario, sexoUsuario, fechaUsuario, aes_decrypt(correoUsuario, 'BraceBlack'),"
                        + " aes_decrypt(userUsuario, 'BraceBlack'), aes_decrypt(passwordUsuario, 'BraceBlack'), idTipoUsuario, idTest  FROM usuario"
                        + " WHERE userUsuario = aes_encrypt(?, 'BraceBlack')";
                pr = con.prepareStatement(sql);
                pr.setString(1, userUsuario);
                rs = pr.executeQuery();
                if (rs.next()) {
                    us = new Usuario();
                    System.out.println("ESTE USUARIO SI EXISTE");
                } else {
                    System.out.println("ESTE USUARIO NO EXISTE");
                }
                
                con.close();
                pr.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("ERROR AL VERIFICAR USUARIO");
                ex.printStackTrace();
                us = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo

            }
        }

        return us;
    }
    
    
    public static Usuario verificarUsuarioEmail(String correoUsuario, String passwordUsuario, int tipo) throws SQLException, SQLException {
        Usuario us = null;
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement pr;
        ResultSet rs;

        if (tipo == 1 || tipo == 3) {
//            INICIO DE SESION
            System.out.println("Estas iniciando sesion UwU");
            try {
                con = cn.getConnection();
//                Este es el String para MYSQL
//                String sql = "SELECT * FROM Usuario WHERE correoUsuario = ? AND passwordUsuario = ?";
                String sql = "SELECT idUsuario, nombreUsuario, appatUsuario, apmatUsuario, sexoUsuario, fechaUsuario, aes_decrypt(correoUsuario, 'BraceBlack'),\n"
                        + " aes_decrypt(userUsuario, 'BraceBlack'), aes_decrypt(passwordUsuario, 'BraceBlack'), idTipoUsuario,\n"
                        + " idTest  FROM usuario WHERE correoUsuario = aes_encrypt(?, 'BraceBlack') AND passwordUsuario = aes_encrypt(?,'BraceBlack');";
                pr = con.prepareStatement(sql);
                pr.setString(1, correoUsuario);
                pr.setString(2, passwordUsuario);
//                System.out.println("email = " + correoUsuario);
//                System.out.println("password = " + passwordUsuario);
//                System.out.println("pr = " + pr);
                rs = pr.executeQuery();
                while (rs.next()) {
                    if (rs.getString("nombreUsuario") != null) {
//                        Le asignamos todos los datos al objeto us que va a ser el dueño de la sesion activa

                        us = new Usuario();
                        us.setIdUsuario(rs.getInt("idUsuario"));
                        us.setNombreUsuario(rs.getString("nombreUsuario"));
                        us.setAppatUsuario(rs.getString("appatUsuario"));
                        us.setApmatUsuario(rs.getString("apmatUsuario"));
                        us.setSexoUsuario(rs.getString("sexoUsuario"));
                        us.setFechaUsuario(rs.getString("fechaUsuario"));
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
                us = null;
                
            } finally {
//                Cerramos todo pa que no pase nada feo
                
            }
        } else if (tipo == 2 || tipo == 4) {
//            Aqui verificamos que no existe el correo para que se pueda registrar
            try {
                con = cn.getConnection();
                String sql = "SELECT idUsuario, nombreUsuario, appatUsuario, apmatUsuario, sexoUsuario, fechaUsuario, aes_decrypt(correoUsuario, 'BraceBlack'),\n"
                        + " aes_decrypt(userUsuario, 'BraceBlack'), aes_decrypt(passwordUsuario, 'BraceBlack'), idTipoUsuario,\n"
                        + " idTest  FROM usuario WHERE correoUsuario = aes_encrypt(?, 'BraceBlack')";
                pr = con.prepareStatement(sql);
                pr.setString(1, correoUsuario);
                rs = pr.executeQuery();
                if (rs.next()) {
                    us = new Usuario();
                    us.setNombreUsuario(rs.getString("nombreUsuario"));
                    us.setAppatUsuario(rs.getString("appatUsuario"));
                    us.setApmatUsuario(rs.getString("apmatUsuario"));
                    us.setSexoUsuario(rs.getString("sexoUsuario"));
                    us.setFechaUsuario(rs.getString("fechaUsuario"));
                    System.out.println("ESTE CORREO SI EXISTE");
                } else {
                    System.out.println("ESTE CORREO NO EXISTE");
                }
                
                con.close();
                pr.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                us = null;
                
            } finally {
                
            }
        }

        return us;
    }
    
    
    
}
