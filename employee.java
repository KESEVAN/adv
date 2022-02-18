

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*
;/**
 * Servlet implementation class employee
 */
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String add = request.getParameter("addr");
		String dob = request.getParameter("dob");
		String jdbcurl = "jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		String query="INSERT INTO `employee`(`ID`, `NAME`, `ADDR`, `DOB`) VALUES("+id+",'"+name+"','"+add+"','"+dob+"')";
		out.println(query);
		try {
			Connection con = DriverManager.getConnection(jdbcurl,username,password);
			PreparedStatement st = con.prepareStatement(query);
			st.execute();
			String query1 = "SELECT * FROM employee";
			ResultSet rs = st.executeQuery(query1);
//			out.println("<table border='1'> <tr><th>Name</th> <th>ID</th> <th>addr</th> <th>dob</th> </tr> ");
			out.print("<table border='1'> <tr> <th>Name</th> <th>Id</th> <th>Address</th> <th>DOB</th> </tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
