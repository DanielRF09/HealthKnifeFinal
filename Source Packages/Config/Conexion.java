package Config;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class Conexion {
	
	Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bejjth2bbmwh0cshchxb-mysql.services.clever-cloud.com:20167/bejjth2bbmwh0cshchxb","uqwfhl8r7awjda0e","VGeitQLrJIc7bpUkm7Xw");
            
            
        }catch (Exception e){
            System.err.println("Error en BD: "+e);
        }
    
    }
    
    public Connection getConnection(){
        return con;
    }
	
}
