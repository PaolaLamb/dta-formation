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
				<a class="navbar-brand" href="<c:url value='/pizzas/list'></c:url>"> Ma
					super pizzeria</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/pizzas/new'></c:url>"> <span
							class="glyphicon glyphicon-floppy-disk"></span> Ajouter une pizza
					</a></li>
					<li><a href="<c:url value='/technique'></c:url>"> <span
							class="glyphicon glyphicon-stats"></span> Statistiques
					</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value='/logout'></c:url>">Déconnexion</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</nav>





		<header>
			<h2>Liste des pizzas</h2>
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

						<td><a
							href="<c:url value='/pizzas/edit?code=${pizza.code}'></c:url>"
							class="btn btn-primary"><span
								class="glyphicon glyphicon-pencil"></span> Editer</a> <a
							href="<c:url value='/pizzas/delete?code=${pizza.code}'></c:url>"
							class="btn btn-danger"><span
								class="glyphicon glyphicon-remove"></span> Supprimer</a></td>
					</tr>

				</c:forEach>



			</tbody>
		</table>
	</div>

</body>
</html>