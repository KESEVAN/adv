

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class police
 */
public class police extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public police() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int s = Integer.parseInt(request.getParameter("n"));
		String details = request.getParameter("detail");
		System.out.println("Details"+s+" "+details);
		String jdbcurl = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcurl,username,password);
			Statement st = con.createStatement();
//			String query="CREATE TABLE POLICE (Area VARCHAR(30),Name VARCHAR(30),CODE INT(10),PHNO INT(30));";
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			if(s==1) {
				String query = "SELECT * FROM `police` WHERE Area = \""+details+"\";";
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					out.print("<br>Area:"+ details + "<br>Name"+ rs.getString(2)+ "<br>PHNO:"+rs.getInt(4));
				}
			}
			else {
				String query1 = "SELECT * FROM `police` WHERE PHNO = \""+details+"\";";
				ResultSet rs1 = st.executeQuery(query1);
				while(rs1.next()) {
					out.print("<br><h2>PHNO"+ details + "<br><h2>Name"+ rs1.getString(2)+ "<br><h2>PHNO:"+rs1.getInt(4));
				}
			}
		}
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
