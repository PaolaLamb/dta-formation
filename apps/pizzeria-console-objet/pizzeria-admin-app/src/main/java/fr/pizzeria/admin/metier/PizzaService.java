package fr.pizzeria.admin.metier;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.EventPizza;
import fr.pizzeria.admin.event.EventType;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<EventPizza> creerPizza;

	@Inject
	private Event<EventPizza> modifierPizza;

	@Inject
	private Event<EventPizza> suppressionPizza;

	@Inject
	private DaoPizza<Pizza, String> pizzaDao;

	public List<Pizza> findAll() {
		return pizzaDao.findAll();
	}

	public void saveNew(Pizza pizza) {
		pizzaDao.saveNew(pizza);
		creerPizza.fire(new EventPizza(pizza, LocalDateTime.now(), EventType.valueOf("creation".toUpperCase())));
	}

	public void update(String codePizza, Pizza pizza) {
		pizzaDao.update(codePizza, pizza);
		modifierPizza.fire(new EventPizza(pizza, LocalDateTime.now(), EventType.valueOf("MODIFICATION")));

	}

	public void delete(String codePizza) {
		pizzaDao.delete(codePizza);

	}

}
