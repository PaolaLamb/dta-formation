package fr.pizzeria.ihm.menu.optionPizza;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 *
 */
public class OptionDelPizza extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionDelPizza(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";

	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza à supprimer (99 pour abandonner)");
		String codePizza = ihm.getScanner().next();

		if (codePizza != "99") {
			try {
				ihm.getiPizza().delete(codePizza);
			} catch (StockageException e) {
				throw new DeletePizzaException("Modification(s) de la pizza échouée(s)",e);
			}
		}
	}
}
