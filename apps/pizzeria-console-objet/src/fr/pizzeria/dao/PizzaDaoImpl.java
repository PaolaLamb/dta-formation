package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza, String> {
	private Pizza[] pizzas ; //tableau de pizza
	
	public PizzaDaoImpl(Pizza[] pizzas) { //constructeur
		this.pizzas = pizzas ;
	}
	
	
	@Override
	public Pizza[] findAll() {
		return pizzas ;
	}


	@Override
	public void saveNew(Pizza pizza)   {
		if(pizza.code.length()>3) {
			throw new SavePizzaException() ;
		} else {
			int size = pizzas.length ;
			Pizza[] newPizzas = Arrays.copyOf(pizzas, size+1) ; //copie du tableau précédent et insertion d'une ligne pour ajouter nouvelle pizza
			newPizzas[size] = pizza ;
			pizzas = newPizzas ;
			Pizza.nbPizzas++ ;
		}
		
	}


	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = 0;
		for (Pizza pizza : pizzas ) {
			if (codePizza.equals(pizza.code)){
				pizzas[index] = newPizza ;
			
			} else {
				throw new UpdatePizzaException() ; ///PASBON
			}
			index++ ;
		}
		
	}


	@Override
	public void delete(String codePizza) {
		int index = 0 ;
		int size = pizzas.length ;
		for (Pizza pizza : pizzas) {
			if (codePizza.equals(pizza.code)){
				Pizza[] newPizzas = new Pizza[size-1] ;
				System.arraycopy(pizzas, 0, newPizzas, 0, index);
				System.arraycopy(pizzas, index +1, newPizzas, index, size - index - 1);
				pizzas = newPizzas ;
				Pizza.nbPizzas-- ;
			} else {
				throw new DeletePizzaException() ; /// PAS BON
			}
			index++ ;
		}
	}
}
