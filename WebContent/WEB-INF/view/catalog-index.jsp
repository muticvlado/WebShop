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
<a href="login">Login</a>
<br><br>
<a href="user-form-registration">Registration</a>
<hr>
<h3>Katalog proizvoda</h3>

<a href="catalog">Buying</a>
<br><br>

	<table>
		<tr><th>Id</th><th>Name</th><th>Price</th><th>Image</th><th>Description</th></tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td style="text-align: center"><img src="${product.image}" style="max-height: 50px"/></td>					
					<td>${product.description}</td>			
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>