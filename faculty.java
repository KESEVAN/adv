

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
/**
 * Servlet implementation class faculty
 */
public class faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faculty() {
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
		int sid = Integer.parseInt(request.getParameter("sid"));
		String name = request.getParameter("name");
		int fid = Integer.parseInt(request.getParameter("fid"));
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl,username,password);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String query="SELECT * FROM `faculty` ";
			Statement st = con.createStatement();
			String query1 = "UPDATE `faculty` SET `sid`="+sid+",`name`='"+name+"' WHERE `fid`="+fid;
			PreparedStatement ps = con.prepareStatement(query1);
			int n = ps.executeUpdate();
			out.println("Changes"+n);
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				out.print("<h2>"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
