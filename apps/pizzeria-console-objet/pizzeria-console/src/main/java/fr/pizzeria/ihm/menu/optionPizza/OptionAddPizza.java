package fr.pizzeria.ihm.menu.optionPizza;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */

@Controller
public class OptionAddPizza extends OptionMenu {

	private Scanner scanner;
	private DaoPizza<Pizza, String> dao;

	@Autowired
	public OptionAddPizza(Scanner scanner, DaoPizza<Pizza, String> dao) {
		super();
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(this.scanner.next());
		System.out.println("Veuillez saisir le nom");
		newPizza.setNom(this.scanner.next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(this.scanner.nextDouble());

		boolean arg = false;
		while (!arg) {
			System.out.println("Veuillez saisir la catégorie de la pizza (Viande/Poisson/Sans_Viande)");
			String categorie = this.scanner.next();
			try {
				newPizza.setCategoriePizza(CategoriePizza.valueOf(categorie.toUpperCase()));
				arg = true;
			} catch (IllegalArgumentException e) {
				Logger.getAnonymousLogger().log(Level.INFO, "/!\\/!\\ Entrée non valide /!\\/!\\", e);
			}

			try {
				this.dao.saveNew(newPizza);
			} catch (StockageException e) {
				throw new SaveException("Ajout de la nouvelle pizza échoué", e);
			}
		}
	}

}
