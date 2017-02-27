package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.model.*;
import fr.pizzeria.dao.IPizzaDao;

public class OptionListePizza extends OptionMenu {

	public OptionListePizza(IPizzaDao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la liste des pizzas";
	}

	@Override
	public void execute() {
		/*
		 * List<Pizza> pizzasList = dao.findAll() ; for(Pizza pizza :
		 * pizzasList) { System.out.println(pizza.getCode() + " -> " +
		 * pizza.getNom() + " (" + pizza.getPrix() + "€) " +
		 * pizza.categoriePizza); }
		 */

		dao.findAll().forEach(pizza -> System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
				+ pizza.getPrix() + "€) " + pizza.getCategoriePizza()));

		System.out.println(Pizza.getNbPizza() + " ont été créées lors de cette session");
	}
}
