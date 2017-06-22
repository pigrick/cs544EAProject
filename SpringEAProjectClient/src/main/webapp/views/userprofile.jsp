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
					<span class="form-control"><c:out value="${loggedInUser.username}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">First Name:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.firstName}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">lastName:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.lastName}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.email}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Street:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.address.street}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">City:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.address.city}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">State:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.address.state}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Country:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.address.country}" /></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Zipcode:</label>
				<div class="col-sm-10">
					<span class="form-control"><c:out value="${loggedInUser.address.zipcode}" /></span>
				</div>
			</div>
			
			<form action="profile/edit">
				<input type="submit" class="btn btn-default" value="Edit" />
			</form>
			
			<table class="table table-bordered">
			<tr>
				<th>Credit Card Number</th>
				<th>Card Holder Name</th>
				<th>Expired Date</th>
				<th>Billing Street</th>
				<th>Billing City</th>
				<th>Billing State</th>
				<th>Billing Country</th>
				<th>Billing Zipcode</th>

			</tr>
			<c:forEach var="creditcard" items="${loggedInUser.creditCards}">
				<tr>
					<td><c:out value="${creditcard.ccNo}" /></td>
					<td><c:out value="${creditcard.name}" /></td>
					<td><c:out value="${creditcard.expiredDate}" /></td>
					<td><c:out value="${creditcard.billingAddress.street}" /></td>
					<td><c:out value="${creditcard.billingAddress.city}" /></td>		
					<td><c:out value="${creditcard.billingAddress.state}" /></td>	
					<td><c:out value="${creditcard.billingAddress.country}" /></td>	
					<td><c:out value="${creditcard.billingAddress.zipcode}" /></td>					
				</tr>
			</c:forEach>
		</table>
			<h2>Add Credit Card</h2>
			<form:form action="/user/profile/addcc" modelAttribute="creditCard" method="post">
			<form:hidden path="id"/>
			<div class="form-group">
				<label>Credit Card Number: <form:errors path="ccNo" cssClass="alert-danger" /></label>
				<form:input path="ccNo" class="form-control" />
			</div>
			<div class="form-group">
				<label>Card Holder Name: <form:errors path="name" cssClass="alert-danger" /></label>
					<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<label>Expired Date: <form:errors path="expiredDate" cssClass="alert-danger" /></label>
				<form:input path="expiredDate" class="form-control" />
			</div>
			<div class="form-group">
				<label>Billing Street: <form:errors path="billingAddress.street" cssClass="alert-danger" /></label>
				<form:input path="billingAddress.street" class="form-control" />
			</div>
			<div class="form-group">
				<label>Billing City: <form:errors path="billingAddress.city" cssClass="alert-danger" /></label>
				<form:input path="billingAddress.city" class="form-control" />
			</div>
			<div class="form-group">
				<label>Billing State: <form:errors path="billingAddress.state" cssClass="alert-danger" /></label>
				<form:input path="billingAddress.state" class="form-control" />
			</div>
			<div class="form-group">
				<label>Billing Country: <form:errors path="billingAddress.country" cssClass="alert-danger" /></label>
				<form:input path="billingAddress.country" class="form-control" />
			</div>
			<div class="form-group">
				<label>Billing Zipcode: <form:errors path="billingAddress.zipcode" cssClass="alert-danger" /></label>
				<form:input path="billingAddress.zipcode" class="form-control" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>