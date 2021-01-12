package Controlador;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrarUsuario {
    
    private Connection cn;
    private Statement set;
    private ResultSet rs;

    public RegistrarUsuario() {

    }

    public static RegistrarUsuario agregarUsuario(String nombre, String appat, String apmat, String sexo, String correo, String username, String password, String idTipoUsuario, String idCRecetas, String idTest) {
        RegistrarUsuario ru = null;
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement pr = null;
        ResultSet rs = null;
        System.out.println("Agregar Usuario");

        try {
            con = cn.getConnection();

            String sql = "CALL agregarUsu (?, ?, ?, ?, current_date(), ?, ? , ? );";
            pr = con.prepareStatement(sql);
            pr.setString(1, nombre);
            pr.setString(2, appat);
            pr.setString(3, apmat);
            pr.setString(4, sexo);
            pr.setString(5, correo);
            pr.setString(6, username);
            pr.setString(7, password);

            pr.executeUpdate();

            System.out.println("USUARIO REGISTRADO");
            
            
        } catch (SQLException ex) {
            System.out.println("Error al agregar usuairio");
        }
        return ru;
    }
    
}

