package myPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo3 {
	public static void main(String [] argv) throws ClassNotFoundException, IOException, SQLException{
		fun3();
	}
public static void fun3() throws ClassNotFoundException, IOException, SQLException{
	Connection con=JdbcUtils.getConnection();
	Statement stm=(Statement) con.createStatement();
	String sql="select * from user";
	System.out.println(sql);
	ResultSet rs=stm.executeQuery(sql);
	int count = rs.getMetaData().getColumnCount();
	while(rs.next()){
		for(int i=1;i<=count;i++){
			System.out.print(rs.getString(i));
			if(i < count)
			System.out.print(",");
		}
		System.out.println();
	}
	System.out.println(con);
}
}
