package jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.data.City;
import jdbc.db.DbUtil;

/**
 * Servlet implementation class SqlServlet
 */
@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SqlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("get");
		if (2==2) {
			List<City> cityList = getCities();
			request.setAttribute("cityList", cityList);
			request.getRequestDispatcher("citylist.jsp").forward(request, response);
		} else {
			response.sendError(403);
		}

	}

	private List<City> getCities() {
		List<City> cityList = null;
		final String sqlQuery = "SELECT Name, Population FROM city";
		try (Connection conn = DbUtil.getInstance().getConnection();
				Statement statement = conn.createStatement();
				ResultSet resulSet = statement.executeQuery(sqlQuery);) {
			String cityName = null;
			int cityPopulation = 0;
			cityList = new ArrayList<>();
			while(resulSet.next()){
				cityName = resulSet.getString("Name");
				cityPopulation = resulSet.getInt("Population");
				City city = new City(cityName, cityPopulation);
				cityList.add(city);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return cityList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
