package fr.pizzeria.ihm.menu.optionPizza;

import java.util.Comparator;

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
public class OptionMostExpensivePizza extends OptionMenu {

	private DaoPizza<Pizza, String> dao;

	@Autowired
	public OptionMostExpensivePizza(DaoPizza<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Afficher la pizza au tarif le plus élevé";
	}

	@Override
	public void execute() {
		this.dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(
				p.getNom() + " est actuellement la plus chère des pizzas disponibles avec " + p.getPrix() + "€ "));
	}

}
