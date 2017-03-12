package fr.pizzeria.ihm.menu.optionPizza;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionAddPizza extends OptionMenu {
	
	/**
	 * @param dao
	 * @param scan
	 */
	public OptionAddPizza(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {	
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(ihm.getScanner().next());
		System.out.println("Veuillez saisir le nom");
		newPizza.setNom(ihm.getScanner().next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(ihm.getScanner().nextDouble());

		boolean arg = false;
		while (!arg) {
			System.out.println("Veuillez saisir la catégorie de la pizza (Viande/Poisson/Sans_Viande)");
			String categorie = ihm.getScanner().next();
			try {
				newPizza.setCategoriePizza(CategoriePizza.valueOf(categorie.toUpperCase()));
				arg = true;
			} catch (IllegalArgumentException e) {
				Logger.getAnonymousLogger().log(Level.INFO,"/!\\/!\\ Entrée non valide /!\\/!\\", e );
			}

			try {
				ihm.getiPizza().saveNew(newPizza);
			} catch (StockageException e) {
				throw new SavePizzaException("Ajout de la nouvelle pizza échoué",e);
			}
		}
	}
}
