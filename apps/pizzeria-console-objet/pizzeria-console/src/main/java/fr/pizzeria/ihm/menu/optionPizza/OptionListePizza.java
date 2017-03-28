package fr.pizzeria.ihm.menu.optionPizza;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class OptionListePizza extends OptionMenu {

	private DaoPizza<Pizza, String> dao;

	public OptionListePizza(DaoPizza<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Afficher la liste des pizzas";
	}

	@Override
	public void execute() {
		this.dao.findAll().forEach(pizza -> System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
				+ pizza.getPrix() + "€ ) " + pizza.getCategoriePizza()));

		System.out.println(Pizza.getNbPizza() + " ont été créées lors de cette session");
	}
}
