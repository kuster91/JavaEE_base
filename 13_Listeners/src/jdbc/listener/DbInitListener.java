package jdbc.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jdbc.db.DbUtil;

@WebListener
public class DbInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DbUtil.getInstance().close();
		System.out.println("Context Destroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Context initialized");
		try{
			DbUtil.getInstance().getConnection();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}

}
