<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style-table.css" rel="stylesheet" >
</head>

<body>
<h1>Web shop</h1>
<jsp:include page="include/manu.jsp"></jsp:include>
<hr>
<h3>User list</h3>
<a href="user-form">Add new user</a><br><br>

	<table>
		<tr><th>User number</th><th>Name</th><th>Surname</th><th>Phone</th><th>Adress</th><th>Enabled</th><th>Action</th></tr>
			<c:forEach items="${users}" var="user">
			<c:if test="${user.enabled == false}">
				<tr style="color: red">
			</c:if>
				
			<c:if test="${user.enabled == true}">
				<tr>
			</c:if>
				
					<td>${user.user_number}</td>
					<td>${user.name}</td>
					<td>${user.surname}</td>
					<td>${user.phone}</td>
					<td>${user.adress}</td>
					<td>${user.enabled}</td>
					<td>
						<a href="user-update?user_number=${user.user_number}">Update</a> |
					 	<a href="user-delete?user_number=${user.user_number}" onclick="return confirm('Delete user?')">Delete</a> |
					 	<a href="user-enable-disable?user_number=${user.user_number}">Enable or Disable</a>			
					</td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>