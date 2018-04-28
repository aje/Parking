<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<@form.errors path="user.*" />
		
	 <hr>
	<h2>${msg!}</h2>Register new user <hr>
	<strong><form:errors path="user.*" /></strong>
	
	<form action="/users/add" method="post">
		<input name="name" placeholder="name" type="text"><@form.errors path="user.name" /><br>
		<input name="email" placeholder="Email" type="text"><@form.errors path="user.email" /> <br>
		<input name="mobile" placeholder="Mobile" type="text"><@form.errors path="user.mobile" /> <br>
		<input name="password" placeholder="Password" type="text"><br>
		<input value="submit" type="submit">
	</form>

	
</body>
</html>