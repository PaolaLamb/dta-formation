<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
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
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'></c:url>">


	<!-- Latest compiled and minified JavaScript -->
	<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
</head>
<body>




	<div class="container">
		<header>
			<h1>Liste des pizzas</h1>
			<a href="<c:url value='/pizzas/new'></c:url>" class="btn btn-primary" > <span class="glyphicon glyphicon-floppy-disk"></span> Ajouter une pizza</a>
			<a href="<c:url value='/technique'></c:url>" class="btn btn-primary" > <span class="glyphicon glyphicon-stats"></span> Statistiques </a>
		</header>

		<table class="table" id="pizzas">
			<thead>
				<tr align=center>
					<th>Libellé</th>
					<th>Nom</th>
					<th>Prix</th>
					<th>Catégorie</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="pizza" items="${listPizzas}">
					<tr>
						<td>${pizza.code}</td>
						<td>${pizza.nom}</td>
						<td>${pizza.prix}</td>
						<td>${pizza.categoriePizza.niceName}</td>
						
						<td>
							<a href="<c:url value='/pizzas/edit?code=${pizza.code}'></c:url>" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Editer</a>
							<a href="<c:url value='/pizzas/delete?code=${pizza.code}'></c:url>" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Supprimer</a>
						</td>
					</tr>

				</c:forEach>



			</tbody>
		</table>
	</div>

</body>
</html>