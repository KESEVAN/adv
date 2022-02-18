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
		Enter Marks:<input type="number" name="mark">
		<input type="submit" name="1">
	</fieldset>
</form>

<%
	if(request.getParameter("1") != null){
		int marks = Integer.parseInt(request.getParameter("mark"));
		if(marks>=90)
			out.print("<h2> Grade is A ");
		else if(marks<90 && marks>79)
			out.print("<h2> Grade is B ");
		else if(marks<80 && marks>69)
			out.print("<h2> Grade is C ");
		else
			out.print("<h2> Fail ");
		
	}



%>
</body>
</html>