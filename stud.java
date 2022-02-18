package test;
import java.sql.*;

public class stud {
	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(jdbcurl,username,password);
			System.out.println("DB si connection>>");
			String query = "SELECT * FROM `student` WHERE CGPA<9.0;";
			String query2 = "SELECT * FROM student";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				System.out.println("USNL "+rs.getString(1)+"Name: "+rs.getString(2)+"CGPA: "+rs.getFloat(3));
			}
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt.executeQuery(query2);
			
			while(rs1.next())
			{
				if(rs1.getString("Name").equals("JOHN"))
				{
					rs1.updateFloat(3, (float)9.50);
					rs1.updateRow();
					System.out.println("Updated...");
				}
				System.out.println(" USN:"+rs1.getString("USN")+" Name "+rs1.getString("USN")+" CGPA: "+rs1.getDouble("CGPA"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
}
