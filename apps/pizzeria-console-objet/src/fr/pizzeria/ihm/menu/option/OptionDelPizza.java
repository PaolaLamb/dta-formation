package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;


public class OptionDelPizza extends OptionMenu {

	public OptionDelPizza(IPizzaDao<Pizza, String> dao, Scanner scan) {
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
		
		if (codePizza != "99") {
			try { 
				dao.delete(codePizza);
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		}	
	}	
}

