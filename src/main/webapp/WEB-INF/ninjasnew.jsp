<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formatting (dates) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- form:form -->
<%@ page isErrorPage="true"%>
<!-- for rendering errors on PUT routes -->

<!--/////////////////////////////////////////////////////
//	NINJASNEW JSP
///////////////////////////////////////////////////////// -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- //// CSS LINKS //////////////////////////////////////// -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dojos and Ninjas</title>
</head>
<body>
	<!-- //// HEADER /////////////////////////////////////////// -->
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="navbar-brand d-flex align-items-center"> <strong
					class="text-warning">DOJOS AND NINJAS</strong>
				</a> <a class="btn btn-secondary " href="/dojos">HOME</a>
			</div>
		</div>
	</header>

	<!-- //// MAIN AREA //////////////////////////////////////// -->
	<main role="main">
		<div class="container mt-4 bg-info rounded">
			<h1>Create New Ninja</h1>
			<div class="bg-infop-3">
				<!-- //// CREATE NEW DOJO FORM ///////////////// -->
				<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo" class="form-select">
						<c:forEach var="dojo" items="${dojosList}">
							<form:option value="${dojo.id}" path="dojo">
								${ dojo.name }
							</form:option>
						</c:forEach>
					</form:select>
					<p class="form-group">
						<form:label path="firstName">First Name:</form:label>
						<form:input class="form-control mb-3" path="firstName" />
						<form:errors path="firstName" class="alert alert-danger mb-3" />
					</p>
					<p class="form-group">
						<form:label path="lastName">Last Name:</form:label>
						<form:input class="form-control mb-3" path="lastName" />
						<form:errors path="lastName" class="alert alert-danger mb-3" />
					</p>
					<p class="form-group">
						<form:label path="age">Age in years:</form:label>
						<form:input class="form-control mb-3" path="age" type="number" />
						<form:errors path="age" class="alert alert-danger mb-3" />
					</p>
					<input class="btn btn-success mb-3" type="submit"
						value="Submit New Ninja" />
				</form:form>
			</div>
		</div>
	</main>

	<!-- //// JAVASCRIPT LINKS ///////////////////////////////// -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>