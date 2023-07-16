<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
out.print("Ha cerrado sesion correctamente!");
HttpSession sess=request.getSession(true);
session.invalidate();  
response.sendRedirect("index.jsp");
%>
</body>
</html>