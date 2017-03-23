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
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'></c:url>">


	<!-- Latest compiled and minified JavaScript -->
	<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
</head>

<body>
	
	<c:if test='${!empty errorMsg}'><c:out value='attention aux espaces, entrez un nombre entier'/></c:if>
	
	<div class="container">
		<header>
			<h1>Gestion des pizzas</h1>
			<a href="<c:url value='/pizzas/list'></c:url>"><< Retour à l'accueil</a>
		</header>
		
		<form class="form-horizontal" method="POST">
			<fieldset>

				<!-- Form Name -->
				<legend>Nouvelle pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Nom</label>
					<div class="col-md-4">
						<input id="textinput" name="libelle" type="text" value="<c:if test='${!empty pizza}'><c:out value='${pizza.nom}'/></c:if>" class="form-control input-md" required="required">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Référence</label>
					<div class="col-md-4">
						<input id="textinput" name="reference" type="text" value="<c:if test='${!empty pizza}'><c:out value='${pizza.code}'/></c:if>"  class="form-control input-md" required="required">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Prix</label>
					<div class="col-md-4">
						<input id="textinput" name="prix" type="number" value="<c:if test='${!empty pizza}'><c:out value='${pizza.prix}'/></c:if>" class="form-control input-md" required="required">
					</div>
				</div>

				<!-- Multiple Radios -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="radios">Catégorie</label>
					<div class="col-md-4">
						<div class="radio">
							<label for="radios-0"> <input type="radio" name="radios" id="radios-0" value="VIANDE" checked="checked"> Viande	</label>
						</div>
						<div class="radio">
							<label for="radios-1"> <input type="radio" name="radios" id="radios-1" value="SANS_VIANDE"> Sans viande	</label>
						</div>
						<div class="radio">
							<label for="radios-2"> <input type="radio" name="radios" id="radios-2" value="POISSON"> Poisson </label>
						</div>
					</div>
				</div>
				
				<div class="form-group" align="center">
					<input type="submit" value="Ajouter" /> 
				</div>

			</fieldset>
		</form>
	</div>
	

</body>

</html>