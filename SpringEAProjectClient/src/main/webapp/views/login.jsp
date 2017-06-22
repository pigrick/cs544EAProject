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
<title>Order List</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	
	<div class="container">
		<h2>Login</h2>
		<form:form method="post">
			<div class="form-group">
				<label>Username: <form:errors path="username" cssClass="alert-danger" /></label>
				<input type="text" name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label>Password:</label>
					<input type="password" name="password" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>

</body>
</html>