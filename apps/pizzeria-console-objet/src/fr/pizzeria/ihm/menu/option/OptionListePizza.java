package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.IPizzaDao;

public class OptionListePizza extends OptionMenu {

	public OptionListePizza(IPizzaDao<Pizza, String> dao, Scanner scan) {
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
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "�) " + pizza.categoriePizza);
		}
		System.out.println(Pizza.getNbPizza() + " ont �t� cr��es lors de cette session");
	}
}
