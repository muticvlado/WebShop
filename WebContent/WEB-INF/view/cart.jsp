<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
<h3>Cart</h3>
<jsp:include page="include/manu.jsp"></jsp:include>
<table>
	<tr><td>Date</td><td><fmt:formatDate pattern="dd-MM-YYYY" value="${cart.date}"/> </td></tr>
	<tr><td>Name</td><td>${cart.user.name}</td></tr>
	<tr><td>Surname</td><td>${cart.user.surname}</td></tr>
</table>
<hr>
<a href="order-save?cart_id=${cart.id}" onclick="return confirm('Do yuo want finish buying?')">Buy</a>
<br><br>
	<table>
		<tr><th>Id</th><th>Name</th><th>Price</th><th>Quantity</th><th>Image</th><th>Action</th><th>Total</th></tr>
			<c:forEach items="${cart.items}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.product.name}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.price}</fmt:formatNumber></td>
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.quantity}</fmt:formatNumber></td>
					<td style="text-align: center"><img src="${item.product.image}" style="max-height: 50px"/></td>					
					<td>
						<h5><a href="add-one?item_id=${item.id}">Add One</a></h5>
						<h5><a href="remove-one?item_id=${item.id}">Remove One</a></h5>
						<h5><a href="delete-item?item_id=${item.id}">Delete</a></h5>		
					</td>	
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.price*item.quantity}</fmt:formatNumber></td>								
				</tr>
			</c:forEach>
			<tr><td colspan="7"><h3 style="text-align: center">Ukupno: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${total}</fmt:formatNumber></h3></td></tr>			
	</table>
	
</body>
</html>