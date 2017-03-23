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
		</header>

		${compteur} sessions sont ouvertes 


		


	</div>


</body>
</html>