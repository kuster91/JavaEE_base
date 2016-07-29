package datasource.util;

import java.sql.SQLException;
import java.sql.Connection;

import javax.naming.*;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource dataSource;
	
	public static Connection getConnection() throws SQLException{
		return getDSInstance().getConnection();
	}
	
	private static DataSource getDSInstance(){
		if(dataSource == null){
			try{
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:comp/env");
				dataSource=(DataSource) envContext.lookup("jdbc/world");
			}catch(NamingException ex){
				ex.printStackTrace();
			}
		}
		return dataSource;
	}
}
