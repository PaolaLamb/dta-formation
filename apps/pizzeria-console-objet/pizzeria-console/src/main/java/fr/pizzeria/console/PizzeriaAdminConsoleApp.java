package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.OptionAddPizza;
import fr.pizzeria.ihm.menu.option.OptionDelPizza;
import fr.pizzeria.ihm.menu.option.OptionListePizza;
import fr.pizzeria.ihm.menu.option.OptionListerParCategorie;
import fr.pizzeria.ihm.menu.option.OptionMajPizza;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.OptionMostExpensivePizza;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		IhmTools ihm = new IhmTools();

		List<Pizza> pizzasList = new ArrayList<>();

		OptionListePizza optionListe = new OptionListePizza(ihm.getiPizza(), ihm.getScanner());
		OptionAddPizza optionAdd = new OptionAddPizza(ihm.getiPizza(), ihm.getScanner());
		OptionMajPizza optionMaj = new OptionMajPizza(ihm.getiPizza(), ihm.getScanner());
		OptionDelPizza optionDel = new OptionDelPizza(ihm.getiPizza(), ihm.getScanner());
		OptionListerParCategorie optionCat = new OptionListerParCategorie(ihm.getiPizza(), ihm.getScanner());
		OptionMostExpensivePizza optionExp = new OptionMostExpensivePizza(ihm.getiPizza(), ihm.getScanner());

		Map<Integer, OptionMenu> options = new HashMap<>();
		options.put(1, optionListe);
		options.put(2, optionAdd);
		options.put(3, optionMaj);
		options.put(4, optionDel);
		options.put(5, optionCat);
		options.put(6, optionExp);

		Menu menu = new Menu("**** Pizzeria Administration ****", options);

		Integer choix = 0;

		while (choix != options.size() + 1) {
			menu.demarrer();
			System.out.println("Veuillez saisir une action");
			choix = ihm.getScanner().nextInt();

			if (choix > options.size() + 1) {
				System.out.println("Mauvaise Valeur");
				menu.demarrer();
				choix = ihm.getScanner().nextInt();
			}

			if (choix != options.size() + 1) {
				menu.executer(choix);
			}
		}
		System.out.println("**** Au revoir ! ****");

		ihm.getScanner().close();
	}

}
