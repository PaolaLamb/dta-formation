package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.*;

public class OptionListerParCategorie extends OptionMenu {
	
	public OptionListerParCategorie(Dao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas group�es par cat�gorie";
	}

	@Override
	public void execute() {
		dao.listByCat().forEach((key, value) -> System.out.println(key + " : " + value));
	}
	
	

}
