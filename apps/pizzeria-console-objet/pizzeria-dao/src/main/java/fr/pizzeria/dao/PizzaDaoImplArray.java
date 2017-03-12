package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class PizzaDaoImplArray implements DaoPizza<Pizza, String> {
	private List<Pizza> pizzasList;

	/**
	 * Constructeur sans argument
	 */
	public PizzaDaoImplArray() {
		super();
		this.pizzasList = new ArrayList<>();
		pizzasList.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzasList.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzasList.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		pizzasList.add(new Pizza(3, "FRO", "La 4 Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		pizzasList.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzasList.add(new Pizza(5, "SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzasList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzasList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}

	/**
	 * @param pizzaList
	 */
	public PizzaDaoImplArray(List<Pizza> pizzaList) {
		this.pizzasList = pizzaList;
	}

	@Override
	public List<Pizza> findAll() {
		return pizzasList;
	}

	@Override
	public void saveNew(Pizza pizza) {
		if (pizza.getCode() == null || pizza.getCode().length() > 3) {
			throw new SavePizzaException();
		} else {
			pizzasList.add(pizza);
		}
		Pizza.setNbPizza(Pizza.getNbPizza() + 1);
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		Optional<Pizza> resultat = pizzasList.stream().filter(p -> p.getCode().equals(codePizza)).findAny();
		resultat.ifPresent(p -> pizzasList.set(p.getId(), newPizza));

	}

	@Override
	public void delete(String codePizza) {

		Optional<Pizza> resultat = pizzasList.stream().filter(p -> p.getCode().equals(codePizza)).findAny();
		resultat.ifPresent(p -> {
			pizzasList.remove(p);
			Pizza.setNbPizza(Pizza.getNbPizza() - 1);
		});

	}

}
