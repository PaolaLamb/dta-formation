package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.EventPizza;

@ApplicationScoped
public class PizzaStatistiquesService {

	@Inject
	private List<EventPizza> pizzaEvents;

	public void ecouteMonEvent(@Observes EventPizza event) {
		pizzaEvents.add(event);
	}

	public List<EventPizza> getPizzaEvents() {
		return pizzaEvents;
	}

}
