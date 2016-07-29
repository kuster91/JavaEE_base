package jdbc.listener;

import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ReqListener implements ServletRequestListener{
	public void requestDestroyed(ServletRequestEvent sre){
		System.out.println("request destroyed");
	}
	public void requestInitialized(ServletRequestEvent sre){
		System.out.println("request initialized");
	}
}
