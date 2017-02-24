package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza, String> {
	private List<Pizza> pizzas ; //list de pizza
	
	public PizzaDaoImpl(List<Pizza> pizzas) { //constructeur
		this.pizzas = pizzas ;
	}
	
	
	@Override
	public List<Pizza> findAll() {
		return pizzas ;
	}


	@Override
	public void saveNew(Pizza pizza)   {
		if(pizza.code.length()>3) {
			throw new SavePizzaException() ;
		} else {
			pizzas.add(pizza) ;
		}
		Pizza.nbPizzas++ ;
		
	}


	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = 0;
		for (Pizza pizza : pizzas ) {
			if (codePizza.equals(pizza.code)){
				pizzas.set(index, pizza);
			} else {
				throw new UpdatePizzaException() ; ///PASBON
			}
			index++ ;
		}
		
	}


	@Override
	public void delete(String codePizza) {
		int index = 0 ;
		for (Pizza pizza : pizzas) {
			if (codePizza.equals(pizza.code)){
				pizzas.remove(index) ;
			} else {
				throw new DeletePizzaException() ; /// PAS BON
			}
			index++ ;
		}
		Pizza.nbPizzas-- ;
	}
}
