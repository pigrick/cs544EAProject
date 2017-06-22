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
<title>Shopping Cart</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<h2>Shopping Cart</h2>

		<table class="table table-bordered">
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Total Weight</th>
				<th>Total Price</th>
				<th>Change</th>
			</tr>
			<c:forEach var="orderline" items="${cart.orderlines}">
				<tr>
					<td><c:out value="${orderline.product.name}" /></td>
					<td><c:out value="${orderline.quantity}" /></td>
					<td><c:out value="${orderline.getTotalWeight()}" /></td>
					<td><c:out value="${orderline.getTotalPrice()}" /></td>
					<td><form:form action="/user/cart/change" method="POST">
							<input type="hidden" name="id" value="${orderline.product.id}" />
							<input type="text" name="quantity" />
							<input type="submit" value="Change" />
						</form:form></td>
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
		<form:form action="/user/checkout" method="GET">
			<input type="submit" class="btn btn-default" value="Checkout" />
		</form:form>
	</div>
</body>
</html>