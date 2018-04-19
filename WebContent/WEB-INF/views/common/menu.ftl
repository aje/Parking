<%@ page session= "true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3><a href="/SpringMVC/">Home</a> - 
<a href="/SpringMVC/users">Users</a>

<hr>
<a href="?lang=en">English</a> | 
<a href="?lang=fr">French</a> 
<c:choose>
	<c:when test= "${empty name}">
		- <a href="/SpringMVC/register">Register</a> - 
		<a href="/SpringMVC/login">Login</a></h3>	
	</c:when>
	<c:otherwise>
		<hr> Welcome <%=session.getAttribute("name")%> - <a href="/SpringMVC/logout">Logout</a>
	</c:otherwise>
</c:choose>
