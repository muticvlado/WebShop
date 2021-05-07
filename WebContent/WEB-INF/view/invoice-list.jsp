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
<h3>Invoice list</h3><br>

	<table>
		<tr><th>Id</th><th>Date</th><th>User</th><th>Amount</th><th>Details</th></tr>
			<c:forEach items="${invoices}" var="invoice">
				<tr>
					<td>${invoice.id}</td>
					<td>${invoice.date}</td>
					<td>${invoice.user.username}</td>
		            <td>${invoice.amount}</td>
					<td><a href="invoice-details?id=${invoice.id}">Details</a></td>					
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>