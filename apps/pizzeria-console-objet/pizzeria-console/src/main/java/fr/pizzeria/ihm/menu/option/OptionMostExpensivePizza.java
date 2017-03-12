package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionMostExpensivePizza extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionMostExpensivePizza(Dao<Pizza, String> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la pizza au tarif le plus élevé";
	}

	@Override
	public void execute() {
		dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(
				p.getNom() + " est actuellement la plus chère des pizzas disponibles avec " + p.getPrix() + "€ "));
	}

}
