package fr.pizzeria.admin.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> pizzaList() {
		return pizzaEJB.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newPizza(Pizza pizza) {
		pizzaEJB.saveNew(pizza);
	}

	@Path("/{code}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePizza(@PathParam("code") String codePizza, Pizza newPizza) {
		pizzaEJB.update(codePizza, newPizza);
	}

	@Path("/{code}")
	@DELETE
	public void deletePizza(@PathParam("code") String codePizza) {
		pizzaEJB.delete(codePizza);
	}

}
