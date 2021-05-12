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
<h3>Category list</h3>
<a href="category-form">Add new category</a><br><br>

	<table>
		<tr><th>Id</th><th>Name</th><th>Action</th></tr>
			<c:forEach items="${categories}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>
						<a href="category-update?id=${category.id}">Update</a> |
					 	<a href="category-delete?id=${category.id}" onclick="return confirm('Delete category?')">Delete</a>			
					</td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>