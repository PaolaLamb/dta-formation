package fr.pizzeria.admin.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import fr.pizzeria.admin.event.EventPizza;

public class PizzaEventProducer {

	@Produces
	public List<EventPizza> getPizzaEvent() {
		return new ArrayList<>();
	}
}
