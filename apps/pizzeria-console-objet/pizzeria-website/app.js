var API_PIZZAS="http://localhost:8080/pizzeria-admin-app/api/rest/pizzas" ;

$(document).ready(function() {
    $.ajax({
        url: API_PIZZAS
    }).then(function(data) {
        var bodyLines = data.map(function(pizza){
            return "<tr>" 
            + "<td>" + pizza.id + "</td>"
            + "<td>" + pizza.code + "</td>"
            + "<td>" + pizza.nom + "</td>"
            + "<td>" + pizza.prix + "</td>"
            + "<td>" + pizza.categoriePizza + "</td>"
            + "</tr>" ; 
        }) ;
        $('tbody').html(bodyLines) ;
    }) ;
}) ;

