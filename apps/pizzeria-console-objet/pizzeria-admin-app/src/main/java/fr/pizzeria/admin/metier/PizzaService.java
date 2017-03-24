package fr.pizzeria.admin.metier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.EventPizza;
import fr.pizzeria.admin.event.EventType;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Inject
	private Event<EventPizza> creerPizza;

	@Inject
	private Event<EventPizza> modifierPizza;

	@Inject
	private Event<EventPizza> suppressionPizza;

	// @Inject
	// private DaoPizza<Pizza, String> pizzaDao;

	public List<Pizza> findAll() {
		return pizzaEJB.findAll();
	}

	public void saveNew(Pizza pizza) {
		pizzaEJB.saveNew(pizza);
		creerPizza.fire(new EventPizza(pizza, LocalDateTime.now(), EventType.valueOf("CREATION")));
	}

	public void update(String codePizza, Pizza pizza) {
		pizzaEJB.update(codePizza, pizza);
		modifierPizza.fire(new EventPizza(pizza, LocalDateTime.now(), EventType.valueOf("MODIFICATION")));

	}

	public void delete(String codePizza) {
		Optional<Pizza> pizza = pizzaEJB.obtainOne(codePizza);
		pizza.ifPresent(p -> {
			pizzaEJB.delete(codePizza);
			suppressionPizza.fire(new EventPizza(p, LocalDateTime.now(), EventType.valueOf("SUPPRESSION")));
		});

	}

}
