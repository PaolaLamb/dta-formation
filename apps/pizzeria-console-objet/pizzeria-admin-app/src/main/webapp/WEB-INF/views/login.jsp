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
						class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/pizzas/list'></c:url>">Ma super pizzeria </a>
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
					<li><a href="<c:url value='/login'></c:url>">Connexion</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</nav>

		<c:if test='${!empty erreur}'><div class="alert alert-danger" role="alert">Mauvais Identifiants</div></c:if>

		<form class="form-horizontal" method="POST">
			<fieldset>

				<!-- Form Name -->
				<legend>Bienvenue, veuillez vous connecter !</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">ID</label>
					<div class="col-md-4">
						<input name="userId" type="text" placeholder="ID"
							class="form-control input-md" required="">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="passwordinput">Password</label>
					<div class="col-md-4">
						<input name="password" type="password" placeholder="password"
							class="form-control input-md" required="">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<input type="submit" value="Se connecter" type="button" class="btn btn-success" />	
					</div>
				</div>

			</fieldset>
		</form>
	</div>

</body>
</html>