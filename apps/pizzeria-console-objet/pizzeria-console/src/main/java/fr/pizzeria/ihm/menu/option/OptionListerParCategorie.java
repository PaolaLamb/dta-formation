package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class OptionListerParCategorie extends OptionMenu {

	public OptionListerParCategorie(Dao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas groupées par catégorie";
	}

	@Override
	public void execute() {
		dao.listByCat().forEach((key, value) -> System.out.println(key + " : " + value));
	}

}
