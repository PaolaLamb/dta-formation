package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionDelPizza extends OptionMenu {
	public OptionDelPizza(IDao<Pizza, String> dao, Scanner scan) {
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
				dao.delete(pizzaPick) ;
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
			
			}
	}
}	
