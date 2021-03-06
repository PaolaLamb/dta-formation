<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ma Super Pizzeria</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='/css/bootstrap.min.css'></c:url>">

<link rel="stylesheet" href="<c:url value='/css/list.css'></c:url>">


<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/pizzas/list'></c:url>">Ma
					super pizzeria</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value='/logout'></c:url>">Déconnexion</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</nav>


		<header>
			<h2>Ici, on compte les sessions et on regarde les changements
				effectués</h2>
		</header>

		${compteur} session(s) ouverte(s)


		<table class="table" id="creations">
			<thead>
				<tr align=center>
					<th>Pizzas Créées</th>
					<th>Date et Heure</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="creation" items="${listCreation}">
					<tr>
						<td>${creation.pizza}</td>
						<td>${creation.dateTime}</td>
					</tr>
				</c:forEach>
			</tbody>


			<thead>
				<tr align=center>
					<th>Pizzas Modifiées</th>
					<th>Date et Heure</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="modif" items="${listModifs}">
					<tr>
						<td>${modif.pizza}</td>
						<td>${modif.dateTime}</td>
					</tr>
				</c:forEach>
			</tbody>

			<thead>
				<tr align=center>
					<th>Pizzas Supprimées</th>
					<th>Date et Heure</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="suppr" items="${listSupprs}">
					<tr>
						<td>${suppr.pizza}</td>
						<td>${suppr.dateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>




	</div>


</body>
</html>