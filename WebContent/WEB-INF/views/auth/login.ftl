<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	    
	<h2>${msg}</h2>Login ${name}<hr>
	<strong><form:errors path="user.*" /></strong>
	
	<form action="/SpringMVC/loginCheck" method="post">  	
		<input name="mobile" placeholder="Mobile" type="text"> <form:errors path="user.mobile" /><br>
		<input name="password" placeholder="Password" type="text"> <form:errors path="user.password" />
		<input value="submit" type="submit">
	</form>

</body>
</html>