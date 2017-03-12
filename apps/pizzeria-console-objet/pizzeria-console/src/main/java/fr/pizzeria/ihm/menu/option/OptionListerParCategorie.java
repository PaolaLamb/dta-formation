package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionListerParCategorie extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionListerParCategorie(Dao<Pizza, String> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas groupées par catégorie";
	}

	@Override
	public void execute() {
		dao.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((key, value) -> System.out.println(key + " : " + value));
	}

}
