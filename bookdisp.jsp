<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<fieldset>
		Enter title:<input type="text" name="title">
		<input type="submit" name="1">
	</fieldset>
</form>
<%@ page import="java.sql.*" %>
<%
	if(request.getParameter("1") != null){
		String title = request.getParameter("title");
		String query="SELECT * FROM BOOK WHERE title="+"'"+title+"'";
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		try{
			Connection con = DriverManager.getConnection(jdbcurl,username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				out.println(rs.getInt("num")+" "+rs.getString("title")+" "+rs.getString("author")+" "+rs.getString("pub")+" "+rs.getInt("price")+" ");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


%>
</body>
</html>