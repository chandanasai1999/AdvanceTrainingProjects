package myDao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcUtils {
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    public static Connection getConnection() throws SQLException{
    	return dataSource.getConnection();
    }
    public static DataSource getDataSource(){
    	return dataSource;
    }
    
}
