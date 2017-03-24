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
			<h1>Ici, on compte les sessions et on regarde les changements effectués</h1>
			<a href="<c:url value='/pizzas/list'></c:url>"><< Retour à l'accueil</a>
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