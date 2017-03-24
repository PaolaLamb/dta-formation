package fr.pizzeria.admin.metier;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SuppressionPizzaEvent;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<CreerPizzaEvent> creerPizza;

	@Inject
	private Event<ModifierPizzaEvent> modifierPizza;

	@Inject
	private Event<SuppressionPizzaEvent> suppressionPizza;

	@Inject
	private DaoPizza<Pizza, String> pizzaDao;

	public List<Pizza> findAll() {
		return pizzaDao.findAll();
	}

	public void saveNew(Pizza pizza) {
		pizzaDao.saveNew(pizza);
		creerPizza.fire(new CreerPizzaEvent(pizza, LocalDateTime.now()));
	}

	public void update(String codePizza, Pizza pizza) {
		pizzaDao.update(codePizza, pizza);
		modifierPizza.fire(new ModifierPizzaEvent(pizza, LocalDateTime.now()));

	}

	public void delete(String codePizza) {
		pizzaDao.delete(codePizza);

	}

}
