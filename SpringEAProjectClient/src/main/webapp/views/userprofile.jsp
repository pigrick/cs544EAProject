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
		<h2>User Profile</h2>
		<div class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Username:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.username}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">First Name:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.firstName}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">lastName:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.lastName}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.email}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Street:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.address.street}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">City:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.address.city}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">State:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.address.state}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Country:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.address.country}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Zipcode:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${user.address.zipcode}" /></span>
				</div>
			</div>
			
			<form action="profile/edit">
				<input type="submit" class="btn btn-default" value="Edit" />
			</form>
			
			
			
		</div>
	</div>
</body>
</html>