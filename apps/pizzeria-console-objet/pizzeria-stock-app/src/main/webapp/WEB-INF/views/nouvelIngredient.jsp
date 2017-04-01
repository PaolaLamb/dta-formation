<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ajouter un ingrédient</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='/css/bootstrap.min.css'></c:url>">

<link rel="stylesheet" href="<c:url value='/css/list.css'></c:url>">

<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>


</head>
<body>


	<form:form method="post" modelAttribute="ingredient">
		<table>
			<tr>
				<td>Nom</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><form:input path="prix" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><form:input path="quantity" /></td>
			</tr>
		</table>
		<input type="submit" value="Ajouter" type="button" class="btn btn-success" />	
	</form:form>
	
</body>
</html>