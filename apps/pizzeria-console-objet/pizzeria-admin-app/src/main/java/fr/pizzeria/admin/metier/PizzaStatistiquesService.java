package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.EventPizza;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SuppressionPizzaEvent;

public class PizzaStatistiquesService {

	@Inject
	private List<EventPizza> creationEvent;

	public void ecouteMonEvent(@Observes CreerPizzaEvent event) {
		creationEvent.add(event);
	}

	public void ecouteMonEvent(@Observes ModifierPizzaEvent event) {

	}

	public void ecouteMonEvent(@Observes SuppressionPizzaEvent event) {

	}
}
