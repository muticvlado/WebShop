<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Web shop</h1>
<form:form action="logout">
	<input type="submit" value="Logout">
</form:form>
<br>
<sec:authorize access="hasRole('admin')">
<a href="category-list">Category list</a>
<a href="product-list">Product list</a>
<a href="user-list">User list</a>
<a href="invoice-list">Invoices</a>
</sec:authorize>
<a href="catalog">Catalog</a>
<a href="user-invoice-list">Invoices of user</a>
<br><br>
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