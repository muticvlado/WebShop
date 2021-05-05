<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style-table.css" rel="stylesheet" >
</head>

<body>
<h1>Web shop</h1>
<hr>
<h3>User list</h3><br>
<a href="user-form">Add new user</a><br><br>

	<table>
		<tr><th>User number</th><th>Name</th><th>Surname</th><th>Phone</th><th>Adress</th><th>Action</th></tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.user_number}</td>
					<td>${user.name}</td>
					<td>${user.surname}</td>
					<td>${user.phone}</td>
					<td>${user.adress}</td>
					<td>
						<a href="user-update?user_number=${user.user_number}">Update</a> |
					 	<a href="user-delete?user_number=${user.user_number}" onclick="return confirm('Delete user?')">Delete</a>			
					</td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>