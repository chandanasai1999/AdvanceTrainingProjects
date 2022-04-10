package myPackage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private static Properties props =null;

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
   
    	
	    	InputStream in =JdbcUtils.class.getClassLoader()
	                 .getResourceAsStream("dbconfig.properties");
	    	
	    	Properties props = new Properties();
	    	props.load(in);
	    	
		
		
		
			
			Class.forName(props.getProperty("com.mysql.jdbc.Driver"));
			
		
    	return DriverManager.getConnection(props.getProperty("jdbc:mysql://localhost:3306/shoppingcart"),
    			props.getProperty("root"),props.getProperty("Simplilearn"));
    }
}
