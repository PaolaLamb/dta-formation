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
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		new Pizza().equals(new Pizza());

		IhmTools ihm = new IhmTools();

		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza(0, "PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza(3, "FRO", "La 4 Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(5, "SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));

		ihm.getiPizza().createFiles();
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
