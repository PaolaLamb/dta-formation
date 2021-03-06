<%@page import="fr.pizzeria.model.Pizza"%>
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
			<h2>Gestion des pizzas</h2>
		</header>


		<form class="form-horizontal" method="POST">
			<fieldset>

				<!-- Form Name -->
				<legend>Modifier la pizza ${pizza.nom}</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Nom</label>
					<div class="col-md-4">
						<input id="textinput" name="libelle" type="text"
							value="${pizza.nom}" class="form-control input-md" required="">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Référence</label>
					<div class="col-md-4">
						<input id="textinput" name="reference" type="text"
							value="${pizza.code}" class="form-control input-md" required="">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Prix</label>
					<div class="col-md-4">
						<input id="textinput" name="prix" type="number"
							value="${pizza.prix}" class="form-control input-md" required="">
					</div>
				</div>

				<!-- Multiple Radios -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="radios">Catégorie</label>
					<div class="col-md-4">
						<div class="radio">
							<label for="radios-0"> <input type="radio" name="radios"
								id="radios-0" value="VIANDE" checked="checked"> Viande
							</label>
						</div>
						<div class="radio">
							<label for="radios-1"> <input type="radio" name="radios"
								id="radios-1" value="SANS_VIANDE"> Sans viande
							</label>
						</div>
						<div class="radio">
							<label for="radios-2"> <input type="radio" name="radios"
								id="radios-2" value="POISSON"> Poisson
							</label>
						</div>
					</div>
				</div>

				<div class="form-group" align="center">
					<input type="submit" value="Modifier" type="button" class="btn btn-success" />	
				</div>


			</fieldset>
		</form>
	</div>


</body>

</html>