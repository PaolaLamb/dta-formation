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

	<c:if test='${!empty erreur}'>${erreur}</c:if>

	<div class="container">
		<form class="form-horizontal" method="POST" >
			<fieldset>

				<!-- Form Name -->
				<legend>Please sign in</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">ID</label>
					<div class="col-md-4">
						<input name="userId" type="text" placeholder="ID" class="form-control input-md" required="">
					</div>
				</div>

					<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="passwordinput">Password</label>
					<div class="col-md-4">
						<input name="password" type="password"	placeholder="password" class="form-control input-md" required="">
					</div>
				</div>
				
				<!-- Button -->
				<div class="form-group">
 	 				<label class="col-md-4 control-label" for=""></label>
  					<div class="col-md-4">
    					<input type="submit" value="Se connecter" /> 
  					</div>
				</div>

			</fieldset>
		</form>
	</div>

</body>
</html>