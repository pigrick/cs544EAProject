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
<title>Product Creation/Edit</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
	<h2>Product Creation/Edit</h2>
		<form:form modelAttribute="product" method="post">
			<form:hidden path="id" /> 
			<div class="form-group">
				<label>Name: <form:errors path="name" cssClass="alert-danger" /></label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<label>Description: <form:errors path="description" cssClass="alert-danger" /></label>
					<form:textarea path="description" class="form-control" rows="5" cols="30" />
			</div>
			<div class="form-group">
				<label>Original Price: <form:errors path="oriPrice" cssClass="alert-danger" /></label> 
				<form:input path="oriPrice" class="form-control" />
			</div>
			<div class="form-group">
				<label>Sale Price: <form:errors path="salePrice" cssClass="alert-danger" /></label> 
				<form:input path="salePrice" class="form-control" />
			</div>
			<div class="form-group">
				<label>Weight: <form:errors path="weight" cssClass="alert-danger" /></label> 
				<form:input path="weight" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>