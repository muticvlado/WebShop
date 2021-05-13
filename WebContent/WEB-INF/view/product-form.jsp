<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<jsp:include page="include/manu.jsp"></jsp:include>
<hr>
<h3>Product</h3>

<form:form method="post" modelAttribute="product" action="product-save">
	<form:hidden path="id"/>
	<table>		
		<tr>
			<td>Name</td><td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
				<form:select path="category.id" items="${categories}" itemValue="id" itemLabel="name" placeholder="---------------"/>
			</td>
		</tr>
		<tr>
			<td>Tax</td><td><form:input path="tax"/></td>
		</tr>
		<tr>
			<td>Price</td><td><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Image</td><td><form:input path="image"/></td>
		</tr>
		<tr>
			<td>Description</td><td><form:textarea path="description" cols="40" rows="5"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>

</body>
</html>