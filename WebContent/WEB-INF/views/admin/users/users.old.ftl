<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
	 <h2>${msg} ${name}</h2>
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>lastname</th>
		<th>email</th>
		<th>mobile</th>
		<th>password</th>
		<th>job</th>
		<th>status</th>
		<th>type</th>
		<th>created_at</th>
		<th>updated_at</th>
		<th>actions</th>
	</tr>
	<c:forEach items="${data}" var="user" >
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.lastname}</td>
			<td>${user.email}</td>
			<td>${user.mobile}</td>
			<td>${user.password}</td>
			<td>${user.job}</td>
			<td>${user.status}</td>
			<td>${user.type}</td>
			<td>${user.created_at}</td>
			<td>${user.updated_at}</td>
			<td>
				
				<form action="/SpringMVC/users/edit" method="POST"><input type="hidden" name="id" value="${user.id}"><input type="submit" value="edit"></form>
				
				<c:choose>
				    <c:when test="${user.status=='true'}">
				        <form action="/SpringMVC/users/delete/${user.id}" method="get"><input name="id" type="hidden" value="${user.id}"><input type="submit" value="del"></form>
				    </c:when>    
				    <c:otherwise>
				        <form action="/SpringMVC/users/recover/${user.id}" method="get"><input name="id" type="hidden" value="${user.id}"><input type="submit" value="bring back"></form>
				    </c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>