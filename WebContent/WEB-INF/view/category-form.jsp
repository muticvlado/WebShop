<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Web shop</h1>
<hr>
<h3>Category</h3>

<form:form method="post" modelAttribute="category" action="category-save">
	<form:hidden path="id"/>
	<table>		
		<tr>
			<td>Name</td><td><form:input path="name"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>

</body>
</html>