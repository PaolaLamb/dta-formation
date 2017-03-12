package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionListePizza extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionListePizza(Dao<Pizza, String> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la liste des pizzas";
	}

	@Override
	public void execute() {
		dao.findAll().forEach(pizza -> System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
				+ pizza.getPrix() + "€ ) " + pizza.getCategoriePizza()));

		System.out.println(Pizza.getNbPizza() + " ont été créées lors de cette session");
	}
}
