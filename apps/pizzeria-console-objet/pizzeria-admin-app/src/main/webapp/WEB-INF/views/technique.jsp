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


<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
</head>
<body>
	<div class="container">
		<header>
			<h1>Ici, on compte les sessions</h1>
			<a href="<c:url value='/pizzas/list'></c:url>"><< Retour à l'accueil</a>
		</header>

		${compteur} sessions sont ouvertes 


	<table class="table" id="creations">
		<thead>
			<tr align=center>
				<th>Pizza Créées</th>
				<th>Heure et Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="creation" items="${listEventCreation}">
				<tr>
					<td>${creation.pizza}</td>
					<td>${creation.dateTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<table class="table" id="modif">
		<thead>
			<tr align=center>
				<th>Pizza Créées</th>
				<th>Heure et Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="modif" items="${listEventModif}">
				<tr>
					<td>${modif.pizza}</td>
					<td>${modif.dateTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		


	</div>


</body>
</html>