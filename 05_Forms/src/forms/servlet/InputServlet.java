package forms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.bean.User;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		User user = createUserFromRequest(request);
		sendResponse(user, response);
	}

	private void sendResponse(User user, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h2>Dane odebrano pomyslnie</h2>");
		writer.println("<div>");
		writer.println(user.getUsername() + "<br>");
		writer.println(user.getPassword() + "<br>");
		writer.println(user.getGender() + "<br>");
		if (user.getHobby() != null) {
			writer.println("Hobby:<br>");
			for (String hob : user.getHobby()) {
				writer.println(" " + hob + "<br>");
			}
		}

	}

	private User createUserFromRequest(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pass"));
		user.setGender(request.getParameter("gender"));
		user.setHobby(request.getParameterValues("hobby"));
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = createUserFromRequest(request);
		sendResponse(user, response);
	}

}
