<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<fieldset>
	<h1>Book Register Form</h1>
	Enter Book_No:<input type="number" name="num">
	Enter Title:<input type="text" name="title">
	Enter Author:<input type="text" name="author">
	Enter Publication:<input type="text" name="pub">
	Enter Price:<input type="number" name="price">
	<input type="submit" name="1">
	</fieldset>
</form>
<%@ page import="java.sql.*" %>
<%
	if(request.getParameter("1")!=null){
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String pub = request.getParameter("pub");
		int price = Integer.parseInt(request.getParameter("num"));
		out.println("<h2>"+num+" "+title+" "+author+" "+pub+" "+price);
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		try{
			Connection con = DriverManager.getConnection(jdbcurl,username,password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO BOOK VALUES (?,?,?,?,?)");
			ps.setInt(1, num);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setString(4, pub);
			ps.setInt(5, price);
			ps.execute();
			out.println("Succesfully Inserted data");
			String query="SELECT * FROM BOOK";
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