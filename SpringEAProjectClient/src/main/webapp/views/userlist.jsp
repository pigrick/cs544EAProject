<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User List</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Enabled</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Country</th>
				<th>Zipcode</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.enabled}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.address.street}" /></td>
					<td><c:out value="${user.address.city}" /></td>
					<td><c:out value="${user.address.state}" /></td>
					<td><c:out value="${user.address.country}" /></td>
					<td><c:out value="${user.address.zipcode}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>