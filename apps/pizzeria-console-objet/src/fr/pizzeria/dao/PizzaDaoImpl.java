package fr.pizzeria.dao;

import java.util.List;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
		if(pizza.getCode().length()>3) {
			throw new SavePizzaException() ;
		} else {
			pizzasList.add(pizza) ;
		}
		Pizza.setNbPizza(Pizza.getNbPizza()+1);	
	}

	
	
	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = 0 ;
		for(Pizza pizza : pizzasList) {
			if(codePizza.equals(pizza.getCode())) {
				pizzasList.set(index, newPizza) ;
			} else {
				throw new UpdatePizzaException() ; ///PASBON
			}
			index++ ;
		}
	}

	@Override
	public void delete(String codePizza) {
		int index = 0 ;
		for(Pizza pizza : pizzasList) {
			if(codePizza.equals(pizza.getCode())) {
				pizzasList.remove(index) ; ;
			} else {
				throw new DeletePizzaException() ; /// PAS BON
			}
			index++ ;
		}
		Pizza.setNbPizza(Pizza.getNbPizza()-1);
	}
	
	
}
