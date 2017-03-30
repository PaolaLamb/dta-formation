package fr.pizzeria.dao.impl.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repository.PizzaRepository;

@Repository
public class PizzaDaoImplDataJpa implements DaoPizza<Pizza, String> {

	@Autowired
	private PizzaRepository pizzaRep;

	@Override
	public List<Pizza> findAll() {
		return pizzaRep.findAll();
	}

	@Override
	public void saveNew(Pizza pizza) {
		pizzaRep.save(pizza);
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		Pizza pizza = pizzaRep.findPizzaByCode(codePizza);

		newPizza.setId(pizza.getId());
		pizzaRep.save(newPizza);

	}

	@Override
	public void delete(String codePizza) {
		Pizza pizza = pizzaRep.findPizzaByCode(codePizza);
		pizzaRep.delete(pizza.getId());
	}

}
