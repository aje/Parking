<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<#assign formErrors><@form.errors path="user.*" /></#assign>
	
	
	<strong></strong>
	<form action="/Parking/loginCheck" method="post">  	
		<input name="mobile" placeholder="Mobile" type="text"> <br>
		<input name="password" placeholder="Password" type="text"> 
		<input value="submit" type="submit">
	</form>

</body>
</html>