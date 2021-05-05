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
<h3>Order form</h3>

<form:form method="post" modelAttribute="invoice" action="order-save">
	<form:hidden path="id"/>
	<form:hidden path="user.username"/>
	<form:hidden path="complete"/>
	<table>		
		<tr>
			<td>Name</td><td><form:input path="user.name"/></td>
		</tr>
		<tr>
			<td>Surname</td><td><form:input path="user.surname"/></td>
		</tr>
		
		<tr>
			<td>Adress for delivery</td>
			<td><form:textarea path="adress_delivery" value="user.adress"/></td>
		</tr>		
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>

</body>
</html>