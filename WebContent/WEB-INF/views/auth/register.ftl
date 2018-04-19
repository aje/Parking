<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	    
	<h2>${msg}</h2>Register new user <hr>
	<strong><form:errors path="user.*" /></strong>
	
	<form action="/SpringMVC/adduser" method="post">     <spring:message code='label.name' />  	
		<input name="name" placeholder="" type="text"> <form:errors path="user.name*" /><br>
		<input name="lastname" placeholder="Lastname" type="text"> <form:errors path="user.lastname*" /><br>
		<input name="email" placeholder="Email" type="text"> <form:errors path="user.email*" /><br>
		<input name="mobile" placeholder="Mobile" type="text"> <form:errors path="user.mobile*" /><br>
		<input name="password" placeholder="Password" type="text"> <form:errors path="user.password*" /><br>
		<input name="job" placeholder="Job" type="text"> <form:errors path="user.job*" /><br>
		<input value="submit" type="submit">
	</form>

	
</body>
</html>