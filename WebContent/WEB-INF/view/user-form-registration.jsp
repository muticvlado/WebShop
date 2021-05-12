<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3>User</h3>

<form:form method="post" modelAttribute="user" action="user-registration">
	<table>	
		<form:hidden path="user_number"/>	
		<tr>
			<td>Username</td><td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>Password</td><td><form:input type="password" path="password"/></td>
		</tr>
		<tr>
			<td>Name</td><td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Surname</td><td><form:input path="surname"/></td>
		</tr>
		<tr>
			<td>Email</td><td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Phone</td><td><form:input path="phone"/></td>
		</tr>
		<tr>
			<td>Adress</td><td><form:textarea path="adress" cols="40" rows="5"/></td>
		</tr>
		<form:hidden path="enabled" value="true"/>		
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>

</body>
</html>