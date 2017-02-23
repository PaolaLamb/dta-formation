package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class OptionDelPizza extends OptionMenu {
	public OptionDelPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Supprimez une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir le code de la pizza à supprimer (99 pour quitter)");
		String pizzaPick = scan.nextLine() ;
		if (pizzaPick != "99") {
			try {
				dao.deletePizza(pizzaPick) ;
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
			
			}
	}
}	
