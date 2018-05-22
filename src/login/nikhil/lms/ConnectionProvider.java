package login.nikhil.lms;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements DataSource {

static Connection conn=null;
	
	public static Connection getCon(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connURL, username, password);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
}
