package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionDelPizza extends OptionMenu {

	public OptionDelPizza(Dao<Pizza, String> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";

	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza à supprimer (99 pour abandonner)");
		String codePizza = scan.next();

		if (codePizza != "99") {
			try {
				dao.delete(codePizza);
			} catch (StockageException e) {
				throw new DeletePizzaException("Modification(s) de la pizza échouée(s)",e);
			}
		}
	}
}
