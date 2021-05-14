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

<table>
	<tr><td>Date</td><td><fmt:formatDate pattern="dd-MM-YYYY" value="${invoice.date}"/> </td></tr>
	<tr><td>Name</td><td>${invoice.user.name}</td></tr>
	<tr><td>Surname</td><td>${invoice.user.surname}</td></tr>
</table>
<hr>
<br>
	<table>
		<tr><th>#</th><th>Name</th><th>Price</th><th>Quantity</th><th>Total</th></tr>
			<c:forEach items="${invoice.items}" var="item" varStatus="counter">
				<tr>
					<td>${counter.count}</td>
					<td>${item.product.name}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.price}</fmt:formatNumber></td>
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.quantity}</fmt:formatNumber></td>
					<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${item.price*item.quantity}</fmt:formatNumber></td>								
				</tr>
			</c:forEach>
			<tr><td colspan="7"><h3 style="text-align: center">Ukupno: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${total}</fmt:formatNumber></h3></td></tr>			
	</table>
	
</body>
</html>