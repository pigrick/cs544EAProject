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
	<h2>User Registration</h2>
	<div class="container">
		<form:form modelAttribute="user" method="post">
			<form:hidden path="id"/>
			<div class="form-group">
				<label>Username: <form:errors path="username" cssClass="alert-danger" /></label>
				<form:input path="username" class="form-control" />
			</div>
			<div class="form-group">
				<label>Password: <form:errors path="password" cssClass="alert-danger" /></label>
					<form:password path="password" class="form-control" />
			</div>
			<div class="form-group">
				<label>First Name: <form:errors path="firstName" cssClass="alert-danger" /></label>
				<form:input path="firstName" class="form-control" />
			</div>
			<div class="form-group">
				<label>Last Name: <form:errors path="lastName" cssClass="alert-danger" /></label>
				<form:input path="lastName" class="form-control" />
			</div>
			<div class="form-group">
				<label>Email: <form:errors path="email" cssClass="alert-danger" /></label>
				<form:input path="email" class="form-control" />
			</div>
			<div class="form-group">
				<label>Street: <form:errors path="address.street" cssClass="alert-danger" /></label>
				<form:input path="address.street" class="form-control" />
			</div>
			<div class="form-group">
				<label>City: <form:errors path="address.city" cssClass="alert-danger" /></label>
				<form:input path="address.city" class="form-control" />
			</div>
			<div class="form-group">
				<label>State: <form:errors path="address.state" cssClass="alert-danger" /></label>
				<form:input path="address.state" class="form-control" />
			</div>
			<div class="form-group">
				<label>Country: <form:errors path="address.country" cssClass="alert-danger" /></label>
				<form:input path="address.country" class="form-control" />
			</div>
			<div class="form-group">
				<label>Zipcode: <form:errors path="password" cssClass="alert-danger" /></label>
				<form:input path="address.zipcode" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>