package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class IpRequestFilter
 */
@WebFilter("/IpRequestFilter")
public class IpRequestFilter implements Filter {

	private String ipPattern;

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Ip filter");
		String requestIp = request.getRemoteAddr();
		if(requestIp.matches(ipPattern)){
			System.out.println("Ip OK");
			chain.doFilter(request, response);
		}else{
			System.out.println("Ip not OK");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendError(403);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ipPattern = fConfig.getInitParameter("ipPattern");
	}

}
