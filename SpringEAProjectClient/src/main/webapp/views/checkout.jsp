<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
<title>Checkout</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<h2>Checkout</h2>

		<table class="table table-bordered">
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Total Weight</th>
				<th>Total Price</th>
			</tr>
			<c:forEach var="orderline" items="${cart.orderlines}">
				<tr>
					<td><c:out value="${orderline.product.name}" /></td>
					<td><c:out value="${orderline.quantity}" /></td>
					<td><c:out value="${orderline.getTotalWeight()}" /></td>
					<td><c:out value="${orderline.getTotalPrice()}" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td><c:out value="${cart.getTotalWeight()}" /></td>
				<td><c:out value="${cart.getTotalPrice()}" /></td>
			</tr>
		</table>
		<form:form action="/user/profile" method="GET">
			<input type="submit" class="btn btn-default" value="Add Credit Card" />
		</form:form>
		<form:form modelAttribute="address" method="post">
			<table class="table table-bordered">
				<tr>
					<th>Use This</th>
					<th>Last 4 Digits of Credit Card Number</th>
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
						<td><input type="radio" name="cc" value="${creditcard.id}" /></td>
						<td><c:out value="${creditcard.getLast4ccNO()}" /></td>
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
			<h2>Shipping Address</h2>
			<div class="form-group">
				<input type="radio" name="ownaddress" value="yes"/> Use Own Address
				<input type="radio" name="ownaddress" value="no"/> Use New Address
			</div>
			<div class="form-group">
				<label>Street: <form:errors path="street"
						cssClass="alert-danger" /></label>
				<form:input path="street" class="form-control" />
			</div>
			<div class="form-group">
				<label>City: <form:errors path="city"
						cssClass="alert-danger" /></label>
				<form:input path="city" class="form-control" />
			</div>
			<div class="form-group">
				<label>State: <form:errors path="state"
						cssClass="alert-danger" /></label>
				<form:input path="state" class="form-control" />
			</div>
			<div class="form-group">
				<label>Country: <form:errors path="country"
						cssClass="alert-danger" /></label>
				<form:input path="country" class="form-control" />
			</div>
			<div class="form-group">
				<label>Zipcode: <form:errors path="zipcode"
						cssClass="alert-danger" /></label>
				<form:input path="zipcode" class="form-control" />
			</div>
			<input type="submit" class="btn btn-default" value="Confirm Order" />
		</form:form>
	</div>
</body>
</html>