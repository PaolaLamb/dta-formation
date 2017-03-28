package fr.pizzeria.ihm.menu.optionPizza;

import java.util.Scanner;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionDelPizza extends OptionMenu {

	private Scanner scanner;
	private DaoPizza<Pizza, String> dao;

	public OptionDelPizza(Scanner scanner, DaoPizza<Pizza, String> dao) {
		super();
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";

	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza à supprimer (99 pour abandonner)");
		String codePizza = this.scanner.next();

		if (codePizza != "99") {
			try {
				this.dao.delete(codePizza);
			} catch (StockageException e) {
				throw new DeletePizzaException("Modification(s) de la pizza échouée(s)", e);
			}
		}
	}
}
