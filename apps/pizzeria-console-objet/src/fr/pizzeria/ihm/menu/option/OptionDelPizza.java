package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class OptionDelPizza extends OptionMenu {

	public OptionDelPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String codePizza = scan.next();
		
		dao.delete(codePizza);
	}
	
	
	
}
