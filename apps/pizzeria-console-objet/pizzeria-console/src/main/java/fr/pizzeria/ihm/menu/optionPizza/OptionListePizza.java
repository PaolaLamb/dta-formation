package fr.pizzeria.ihm.menu.optionPizza;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionListePizza extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionListePizza(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Afficher la liste des pizzas";
	}

	@Override
	public void execute() {
		ihm.getiPizza().findAll().forEach(pizza -> System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
				+ pizza.getPrix() + "€ ) " + pizza.getCategoriePizza()));

		System.out.println(Pizza.getNbPizza() + " ont été créées lors de cette session");
	}
}
