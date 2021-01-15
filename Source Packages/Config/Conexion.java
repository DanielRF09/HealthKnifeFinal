package Config;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class Conexion {
	
	Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_healthknife","root","n0m3l0");
            
            
        }catch (Exception e){
            System.err.println("Error en BD: "+e);
        }
    
    }
    
    public Connection getConnection(){
        return con;
    }
	
}
