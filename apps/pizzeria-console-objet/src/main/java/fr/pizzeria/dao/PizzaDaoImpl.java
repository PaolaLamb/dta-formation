package fr.pizzeria.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements Dao<Pizza, String, CategoriePizza> {
	private List<Pizza> pizzasList;

	public PizzaDaoImpl() {
		super();
	}

	public PizzaDaoImpl(List<Pizza> pizzasList) {
		this.pizzasList = pizzasList;
	}

	@Override
	public List<Pizza> findAll() {
		return pizzasList;
	}

	@Override
	public void createFiles() {
		// TODO Auto-generated method stub

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

		/*
		 * int index = 0 ; for(Pizza pizza : pizzasList) {
		 * if(codePizza.equals(pizza.getCode())) { pizzasList.set(index,
		 * newPizza) ; }// else { //throw new UpdatePizzaException() ; ///PASBON
		 * //} index++ ; }
		 */
	}

	@Override
	public void delete(String codePizza) {

		Optional<Pizza> resultat = pizzasList.stream().filter(p -> p.getCode().equals(codePizza)).findAny();
		resultat.ifPresent(p -> {
			pizzasList.remove(p);
			Pizza.setNbPizza(Pizza.getNbPizza() - 1);
		});

		/*
		 * int index = 0 ; for(Pizza pizza : pizzasList) {
		 * if(codePizza.equals(pizza.getCode())) { break ; } //else { throw new
		 * DeletePizzaException() ; /// PAS BON } index++ ;
		 * 
		 * } //FAIRE UNE FONCTION QUI RETURN SI LA PIZZA EXISTE POUR EVITER LE
		 * BREAK (boolean) + g�rer exception pizzasList.remove(index) ;
		 */
	}

	@Override
	public Map<CategoriePizza, List<Pizza>> listByCat() {
		Map<CategoriePizza, List<Pizza>> map = pizzasList.stream()
				.collect(Collectors.groupingBy(Pizza::getCategoriePizza));
		return map;
	}

	@Override
	public void showMostExp() {
		pizzasList.stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(p.getNom()
				+ " est actuellement la plus ch�re pizza des pizzas disponibles avec " + p.getPrix() + "� "));

	}

}
