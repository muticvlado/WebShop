<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="logout">
	<input type="submit" value="Logout">
</form:form>
<br>

<sec:authorize access="hasRole('admin')">
Admin >>
	<a href="category-list">Category list</a> | 
	<a href="product-list">Product list</a> |
	<a href="user-list">User list</a> |
	<a href="invoice-list">Invoices</a>
</sec:authorize>
<br><br>
User >>
	<a href="catalog">Catalog</a> | 
	<a href="user-invoice-list">Invoices of user</a> | 
	<a href="user-form-profile?user_number=${cart.user.user_number}">Edit profile >>> ${user.username}</a>
<br><br>