var API_INGREDIENTS="http://localhost:8080/rest/ingredients"; 

$(document)
	.ready(function() { 
		data.forEach(function(obj){
			  console.log(obj.nom);
			  	  
		  });
		  
	$.ajax({ url: API_INGREDIENTS}
	})
	.then(function(data) {
		var bodyLines = data.map(function(ingredient){
			return "<tr>" + 
			"<td>" + ingredient.id + "</td>" + 
			"<td>" + ingredient.nom + "</td>" + 
			"<td>" + ingredient.prix + "</td>" + 
			"<td>" + ingredient.quantity + "</td>" + 
			"</tr>" ; 
		}); 

	$('.ingredients tbody').html(bodyLines) ; 
	}) ; 
}) ;

