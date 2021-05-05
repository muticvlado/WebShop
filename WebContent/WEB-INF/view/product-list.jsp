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
<h3>Product list</h3><br>
<a href="product-form">Add new product</a><br><br>

	<table>
		<tr><th>Id</th><th>Name</th><th>Tax</th><th>Price</th><th>Image</th><th>Description</th><th>Action</th></tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.tax}</td>
					<td>${product.price}</td>
					<td style="text-align: center"><img src="${product.image}" style="max-height: 50px"/></td>					
					<td>${product.description}</td>
					<td>
						<a href="product-update?id=${product.id}">Update</a> |
					 	<a href="product-delete?id=${product.id}" onclick="return confirm('Delete product?')">Delete</a>			
					</td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>