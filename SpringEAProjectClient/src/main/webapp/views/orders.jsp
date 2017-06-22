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
<title>Order List</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<h2>Order List</h2>
		<c:forEach var="order" items="${orders}">
			<div class="well">
				<table>
					<tr>
						<td>Date of Order:</td>
						<td> <c:out value="${order.orderDate}" /></td>
					</tr>
					<tr>
						<td>Last 4 Digits Credit Card Number: </td>
						<td> <c:out value="${order.creditCard.getLast4ccNO()} " /></td>
					</tr>
					<tr>
						<td>Card Holder Name</td>
						<td> <c:out value="${order.creditCard.name} " /></td>
					</tr>
				</table>
				<h5>Shipping Address</h5>
				<table class="table table-bordered">
					<tr>
						<th>Street</th>
						<th>City</th>
						<th>State</th>
						<th>Country</th>
						<th>Zipcode</th>
					</tr>
					<tr>

						<td><c:out value="${order.shippingAddress.street}" /></td>
						<td><c:out value="${order.shippingAddress.city}" /></td>
						<td><c:out value="${order.shippingAddress.state}" /></td>
						<td><c:out value="${order.shippingAddress.country}" /></td>
						<td><c:out value="${order.shippingAddress.zipcode}" /></td>
					</tr>

				</table>
				<h4>Orderlines</h4>
				<table class="table table-bordered">
					<tr>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Total Weight</th>
						<th>Total Price</th>
					</tr>
					<c:forEach var="orderline" items="${order.orderlines}">
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
						<td></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>