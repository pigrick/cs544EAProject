<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Rickoning Store</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">User<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/user/profile"}">Profile</a></li>
						<li><a href="/user/all">List</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/product/all">List</a></li>
						<li><a href="/product/add">Create</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Order<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" action="/product/search">
				<div class="input-group">
					<input type="text" name="name" class="form-control"
						placeholder="Search for Product">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/user/cart"><span
						class="glyphicon glyphicon-shopping-cart"></span>Cart <span
						class="badge"><c:out value="${cart.getSize()}" /></span></a></li>
				<li><a href="/user/register"><span
						class="glyphicon glyphicon-user"></span> Register </a></li>
				<sec:authorize access="isAnonymous()">
					<li><a href="/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="/logout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>

