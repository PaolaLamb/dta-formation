package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class OptionDelPizza extends OptionMenu {
	public OptionDelPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Supprimez une pizza";
	}

	@Override
	public boolean execute() {
		System.out.println("Veuillez choisir le code de la pizza à supprimer (99 pour quitter)");
		String pizzaPick = scan.nextLine() ;
		if (pizzaPick != "99") {
			boolean result = dao.deletePizza(pizzaPick) ;
			if (!result) {
				System.out.println(dao.deletePizza(pizzaPick));
				return false ;
			}
			return true ;
		}
		return false ;
	}	
}
