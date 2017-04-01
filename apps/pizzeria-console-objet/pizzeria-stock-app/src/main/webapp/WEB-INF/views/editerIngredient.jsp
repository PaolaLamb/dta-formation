<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer un ingrédient</title>
</head>
<body>


	<form:form method="post" modelAttribute="ingredient">
		<table>
			<tr>
				<td>Nom</td>
				<td><form:input path="nom"  /></td>
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