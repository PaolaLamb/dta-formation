package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.*;

public class OptionMostExpensivePizza extends OptionMenu {

	public OptionMostExpensivePizza(IPizzaDao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Afficher la pizza au tarif le plus élevé" ;
	}

	@Override
	public void execute() {
		dao.showMostExp();
	}
	
	
	
}
