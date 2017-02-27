package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.*;

public class OptionListerParCategorie extends OptionMenu {
	
	public OptionListerParCategorie(IPizzaDao<Pizza, String, CategoriePizza> dao, Scanner scan) {
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
