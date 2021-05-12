<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h3>Invoice list - all users</h3><br>

	<table>
		<tr><th>Id</th><th>Date</th><th>User</th><th>Amount</th><th>Details</th></tr>
			<c:forEach items="${invoices}" var="invoice">
				<tr>
					<td>${invoice.id}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${invoice.date}"/></td>
					<td>${invoice.user.username}</td>
		            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2">${invoice.amount}</fmt:formatNumber></td>
					<td><a href="invoice-details?id=${invoice.id}">Details</a></td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>