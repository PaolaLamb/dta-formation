package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class OptionAddPizza extends OptionMenu {
	public OptionAddPizza(Dao<Pizza, String> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(scan.next());
		System.out.println("Veuillez saisir le nom");
		newPizza.setNom(scan.next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(scan.nextDouble());

		boolean arg = false;
		while (!arg) {
			System.out.println("Veuillez saisir la catégorie de la pizza (Viande/Poisson/Sans_Viande)");
			String categorie = scan.next();
			try {
				newPizza.setCategoriePizza(CategoriePizza.valueOf(categorie.toUpperCase()));
				arg = true;
			} catch (IllegalArgumentException e) {
				Logger.getAnonymousLogger().log(Level.INFO,"/!\\/!\\ Entrée non valide /!\\/!\\" );
			}

			try {
				dao.saveNew(newPizza);
			} catch (StockageException e) {
				throw new SavePizzaException("Ajout de la nouvelle pizza échoué",e);
			}
		}
	}
}
