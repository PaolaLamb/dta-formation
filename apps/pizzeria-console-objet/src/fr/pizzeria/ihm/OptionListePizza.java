package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionListePizza extends OptionMenu {
	public OptionListePizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Liste des pizzas" ;
	}

	@Override
	public void execute() {
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza.code + " -> " + pizza.nom + " (" + pizza.prix + "€) ");
		}
		System.out.println(Pizza.nbPizzas + " pizzas ont été créées\n");
	}
	
}
