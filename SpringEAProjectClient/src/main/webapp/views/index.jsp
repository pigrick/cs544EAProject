<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
<title>Home Page</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="container">
  <div class="jumbotron">
    <h1>Welcome to the RICKONING STORE! </h1>      
    <p>This is the most awesome online store you will ever visit</p>
  </div>
  <p>Customer Guarantee satisfied</p>      
  <p>Buy on Sunday get 20% off!</p>      
</div>
</body>
</html>