package fr.pizzeria.ihm.menu.optionPizza;

import java.util.Comparator;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionMostExpensivePizza extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionMostExpensivePizza(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Afficher la pizza au tarif le plus élevé";
	}

	@Override
	public void execute() {
		ihm.getiPizza().findAll().stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(
				p.getNom() + " est actuellement la plus chère des pizzas disponibles avec " + p.getPrix() + "€ "));
	}

}
