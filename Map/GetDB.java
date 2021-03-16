package net.javaguide.WikiCampsTaiwan.dao._Common;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;
/**
 * Servlet implementation class ConnectDB
 */
@WebServlet("/gDB")
public class GetDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDB() {
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
		JSONObject jobj = new JSONObject();
		final String url = "jdbc:mariadb://localhost:3306/wikicamp";
		final String user = "user";
		final String pwd = "1234";
		String query = "SELECT * FROM latlng";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Test OK");
		} catch (Exception e) {
			out.println("Driver Test Fail");
		}
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("ConnectDB OK");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rsmd = rs.getMetaData();
			Map<String, Object> map = new HashMap<String, Object>();
			ArrayList<Object> al_obj = new ArrayList<Object>();
			int idx = 1;
			while (rs.next()) {
				ArrayList<String> al_pn = new ArrayList<String>();
				al_pn.add(rs.getString(1));
				al_pn.add(rs.getString(3));
				al_pn.add(rs.getString(7));
				al_pn.add(rs.getString(6));
				al_pn.add(rs.getString(10));
				al_pn.add(rs.getString(13));
				al_obj.add(al_pn);
			}
			jobj.put("info",al_obj);
			out.print(jobj);
			
		} catch (Exception e) {
			out.println("ConnectDB Fail");
		}

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
