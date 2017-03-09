package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class OptionMostExpensivePizza extends OptionMenu {

	public OptionMostExpensivePizza(Dao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la pizza au tarif le plus élevé";
	}

	@Override
	public void execute() {
		dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(p.getNom()
				+ " est actuellement la plus chère pizza des pizzas disponibles avec " + p.getPrix() + "€ "));
	}

}
