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
<title>Product List</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
	<h2>Product List</h2>
		<table class="table table-bordered">
			<tr>
				<th>Id</th> 
				<th>Name</th>
				<th>Description</th>
				<sec:authorize access="hasRole('ADMIN')" >
					<th>Original Price</th>
				</sec:authorize>
				<th>Sale Price</th>
				<th>Weight</th>
				<sec:authorize access="hasRole('ROLE_USER')" >
					<th>Add to Cart</th>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')" >
					<th>Edit</th>
					<th>Delete</th>
				</sec:authorize>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.id}" /></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.description}" /></td>
					<sec:authorize access="hasRole('ADMIN')" >
						<td><c:out value="${product.oriPrice}" /></td>
					</sec:authorize>
					<td><c:out value="${product.salePrice}" /></td>
					<td><c:out value="${product.weight}" /></td>
					<sec:authorize access="hasRole('ROLE_USER')" >
					<td>
						<form:form action="/product/addtocart" method="POST">
							<input type="hidden" name="id" value="${product.id}" />
							<input type="text" name="quantity" />
							<input type="submit" value="Add To Cart" />
						</form:form>
					</td>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')" >
					<td>
						<form action="/product/${product.id}" method="get">
							<input type="submit" value="Edit" />
						</form>
					</td>
					<td>
						<form:form action="/product/delete" method="POST">
							<input type="hidden" name="id" value="${product.id}" />
							<input type="submit" value="Delete" />
						</form:form>
					</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>