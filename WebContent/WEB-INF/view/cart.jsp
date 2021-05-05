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
<h3>Cart</h3><br>

<table>
	<tr><td>Date</td><td>${cart.date}</td></tr>
	<tr><td>Name</td><td>${cart.user.name}</td></tr>
	<tr><td>Surname</td><td>${cart.user.surname}</td></tr>
</table>
<hr>
<a href="order?cart_id=${cart.id}">Buy</a>
	<table>
		<tr><th>Id</th><th>Name</th><th>Price</th><th>Quantity</th><th>Image</th><th>Action</th><th>Total</th></tr>
			<c:forEach items="${cart.items}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.product.name}</td>
					<td>${item.price}</td>
					<td>${item.quantity}</td>
					<td style="text-align: center"><img src="${item.product.image}" style="max-height: 50px"/></td>					
					<td>
						<h5><a href="add-one?item_id=${item.id}">Add One</a></h5>
						<h5><a href="remove-one?item_id=${item.id}">Remove One</a></h5>
						<h5><a href="delete-item?item_id=${item.id}">Delete</a></h5>		
					</td>	
					<td>${item.price*item.quantity}</td>								
				</tr>
			</c:forEach>
			<tr><td colspan="6"><h3 style="text-align: center">${total}</h3></td></tr>			
	</table>
	
</body>
</html>