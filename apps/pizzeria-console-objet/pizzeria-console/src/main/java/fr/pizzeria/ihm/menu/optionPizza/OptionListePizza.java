package fr.pizzeria.ihm.menu.optionPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */

@Controller
public class OptionListePizza extends OptionMenu {

	private DaoPizza<Pizza, String> dao;

	@Autowired
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
