package jdbc.db;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.regexp.internal.recompile;

public class DbUtil {
	private static DbUtil dbUtil;

	private ComboPooledDataSource connectionPool;

	private DbUtil() throws  PropertyVetoException {
		connectionPool = new ComboPooledDataSource();
		//podstawowe info o bazie
		connectionPool.setDriverClass("com.mysql.jdbc.Driver");
		connectionPool.setJdbcUrl("jdbc:mysql://localhost:3306/world");
		connectionPool.setUser("root");
		connectionPool.setPassword("admin");
		
		connectionPool.setInitialPoolSize(5);
		connectionPool.setMinPoolSize(5);;
		connectionPool.setMaxPoolSize(20);
		
		connectionPool.setAcquireIncrement(5);
		connectionPool.setMaxIdleTime(3600);
	}
	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
	
	public static DbUtil getInstance(){
		if(dbUtil == null){
			try{
				dbUtil = new DbUtil();
			}catch(PropertyVetoException ex){
				ex.printStackTrace();
			}
		}
		return dbUtil;
	}
	
	public void close(){
		connectionPool.close();
	}
	

}
