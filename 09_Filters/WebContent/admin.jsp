<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello in Admin Panel!</title>
</head>
<body>
	<h2>Hello in Admin Panel!</h2>
	<h3>Your IP adress is: <%= request.getRemoteAddr() %></h3>
	<a href="LogoutServlet">Logout</a>
</body>
</html>