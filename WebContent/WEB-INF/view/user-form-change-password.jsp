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
<h3>User - change password</h3>

<form:form method="post" action="user-change-password">

	<table>
		<tr>
			<td>Username</td><td><input name="username" value="${username}"/></td>
		</tr>
		<tr>
			<td>Old password</td><td><input name="oldP"/></td>
		</tr>
		<tr>
			<td>New password</td><td><input name="newP"/></td>
		</tr>
		<tr>
			<td>Repeat new password</td><td><input name="repeatP"/></td>
		</tr>
			
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table>
</form:form>

</body>
</html>