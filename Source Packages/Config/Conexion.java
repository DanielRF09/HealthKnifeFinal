package Config;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class Conexion {
	
	Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwugm79dpslks9qc1gdm-mysql.services.clever-cloud.com:20730/bwugm79dpslks9qc1gdm","u0r6dhg8udef4avn","9QFxlPtgDUmDAdrEJgB");
            
            
        }catch (Exception e){
            System.err.println("Error en BD: "+e);
        }
    
    }
    
    public Connection getConnection(){
        return con;
    }
	
}
