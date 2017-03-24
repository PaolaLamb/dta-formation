package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.EventPizza;

public class PizzaStatistiquesService {

	@Inject
	private List<EventPizza> creationEvent;
	@Inject
	private List<EventPizza> modifEvent;
	@Inject
	private List<EventPizza> supprEvent;

	public void ecouteMonEvent(@Observes EventPizza event) {
		String eventType = event.getEventType().getLibelle();
		if ("creation".equals(eventType)) {
			creationEvent.add(event);
		} else if ("modif".equals(eventType)) {
			modifEvent.add(event);
		} else {
			supprEvent.add(event);
		}
	}
}
