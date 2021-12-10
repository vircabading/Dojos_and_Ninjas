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
//	INDEX JSP
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
			<h1>Dojos and Ninjas Index</h1>
			<div class="row">
				<button class="col btn btn-warning m-3">ADD NEW DOJO</button>
				<button class="col btn btn-success m-3">ADD NEW NINJA</button>
			</div>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><strong>ID</strong></th>
						<th scope="col"><strong>Name</strong></th>
						<th scope="col"><strong>Action</strong></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${ dojosList }">
						<tr>
							<td>${ dojo.id }</td>
							<td><a href="/dojos/${ dojo.id }">${ dojo.name }</a></td>
							<td class="row align-items-center">
							<!-- AREA FOR ACTIONS BUTTONS -->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>

	<!-- //// JAVASCRIPT LINKS ///////////////////////////////// -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>