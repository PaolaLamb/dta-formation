<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>Insert title here</title>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1> Liste des pizzas </h1>
	
	
	<table class="table table-inverse">
		<thead>
            <tr align=center>
                <th> Libellé </th>
                <th> Nom </th>
                <th> Prix </th>
                <th> Catégorie </th>
            </tr>
        </thead>
        <tbody>
			
	<% 
	List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas") ;
	for(Pizza pizza : pizzas) {
	%> 
			<tr>
				<td> <%= pizza.getCode() %>   </td>
				<td> <%= pizza.getNom() %> </td>
				<td> <%= pizza.getPrix() %> </td>
				<td> <%= pizza.getCategoriePizza() %> </td>
			</tr>

	<% } %>
			
		
		</tbody>
	</table>
	
</body>
</html>