package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao<Pizza, String> {
	private List<Pizza> pizzasList ;
	
	public PizzaDaoImpl(List<Pizza> pizzasList) {
		this.pizzasList = pizzasList;
	}

	@Override
	public List<Pizza> findAll() {
		return pizzasList;
	}

	@Override
	public void saveNew(Pizza pizza) {
		pizzasList.add(pizza) ;
		Pizza.setNbPizza(Pizza.getNbPizza()+1);
	}

	
	
	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = 0 ;
		for(Pizza pizza : pizzasList) {
			if(codePizza.equals(pizza.getCode())) {
				pizzasList.set(index, newPizza) ;
			}
			index++ ;
		}
	}

	@Override
	public void delete(String codePizza) {
		int index = 0 ;
		for(Pizza pizza : pizzasList) {
			if(codePizza.equals(pizza.getCode())) {
				pizzasList.remove(index) ;
			}
			Pizza.setNbPizza(Pizza.getNbPizza()-1);
			index++ ;
		}
		
	}
	
	
}
