<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="movie.jsp" method="post">
	Enter Name:<input type="text"name="name">
	Enter Price:<input type="number" name = "age">
	<input type='submit' name="1">
</form>
<%
	if(request.getParameter("1") != null){
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		out.println("<h2>Name:"+name+"</h2>");
		out.println("<h2>Age:"+age+"</h2>");
		if(age<10)
			out.println("<h2>Price is 30</h2>");
		else if(age>62)
			out.println("<h2>Price is 50</h2>");
		else
			out.println("<h2>Price is 80</h2>");
	}

%>
</body>
</html>