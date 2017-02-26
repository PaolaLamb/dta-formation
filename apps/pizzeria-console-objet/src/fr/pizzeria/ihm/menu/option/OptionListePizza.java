package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.IPizzaDao;

public class OptionListePizza extends OptionMenu {

	public OptionListePizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la liste des pizzas" ;

	}

	@Override
	public void execute() {
		List<Pizza> pizzasList = dao.findAll() ;
		for(Pizza pizza : pizzasList) {
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "€) ");
		}
		System.out.println(Pizza.getNbPizza() + " ont été créées lors de cette session");
	}
	
	
	
}
