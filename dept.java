package test;

import java.sql.*;

public class dept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcurl,username,password);
			System.out.println("DB is connected");
			String query="SELECT NO_EMP FROM `department` WHERE NAME=\"CSE\";";
			String query2="SELECT NAME,ID FROM `department` WHERE YEAR_ESTAB=2010;";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("No of emp"+rs.getInt(1)+"\n");
			}
			ResultSet rs1 = st.executeQuery(query2);
			while(rs1.next())
			{
				System.out.println(rs1.getString(1)+rs1.getInt(2));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
