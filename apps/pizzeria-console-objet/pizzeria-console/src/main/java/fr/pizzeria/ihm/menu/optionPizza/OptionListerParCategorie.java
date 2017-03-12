package fr.pizzeria.ihm.menu.optionPizza;

import java.util.stream.Collectors;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionListerParCategorie extends OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionListerParCategorie(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas groupées par catégorie";
	}

	@Override
	public void execute() {
		ihm.getiPizza().findAll().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((key, value) -> System.out.println(key + " : " + value));
	}

}
