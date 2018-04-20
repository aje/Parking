<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg}</h2>
	<hr> <h2>Edit ${user[0].name}:</h2>
	<form action="/SpringMVC/users/editUser" method="post">       	
		<input name="name" value="${user[0].name}" placeholder="Name" type="text">
		<input name="lastname" value="${user[0].lastname}" placeholder="Lastname" type="text">
		<input name="email" value="${user[0].email}" placeholder="Email" type="text">
		<input name="mobile" value="${user[0].mobile}" placeholder="Mobile" type="text">
		<input name="job" value="${user[0].job}" placeholder="Job" type="text">
		<input name="id" value="${user[0].id}" type="hidden">
		<input value="submit" type="submit">
	</form>
</body>
</html>