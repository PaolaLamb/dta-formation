package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.menu.option.OptionAddPizza;
import fr.pizzeria.ihm.menu.option.OptionDelPizza;
import fr.pizzeria.ihm.menu.option.OptionListePizza;
import fr.pizzeria.ihm.menu.option.OptionListerParCategorie;
import fr.pizzeria.ihm.menu.option.OptionMajPizza;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.OptionMostExpensivePizza;
import fr.pizzeria.ihm.menu.tools.IhmTools;

public class Menu {
	private String title = "**** Pizzeria Administration ****";
	private Map<Integer, OptionMenu> options;
	IhmTools ihm = new IhmTools();

	public Menu(String title, Map<Integer, OptionMenu> options) {
		this.title = title;
		this.options = options;

	}

	public Menu() {

		OptionListePizza optionListe = new OptionListePizza(ihm.getiPizza(), ihm.getScanner());
		OptionAddPizza optionAdd = new OptionAddPizza(ihm.getiPizza(), ihm.getScanner());
		OptionMajPizza optionMaj = new OptionMajPizza(ihm.getiPizza(), ihm.getScanner());
		OptionDelPizza optionDel = new OptionDelPizza(ihm.getiPizza(), ihm.getScanner());
		OptionListerParCategorie optionCat = new OptionListerParCategorie(ihm.getiPizza(), ihm.getScanner());
		OptionMostExpensivePizza optionExp = new OptionMostExpensivePizza(ihm.getiPizza(), ihm.getScanner());

		Map<Integer, OptionMenu> option = new HashMap<>();
		options.put(1, optionListe);
		options.put(2, optionAdd);
		options.put(3, optionMaj);
		options.put(4, optionDel);
		options.put(5, optionCat);
		options.put(6, optionExp);
		this.options = option;

	}

	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}

	public void demarrer() {
		System.out.println(title);

		options.forEach((key, value) -> System.out.println(key + ". " + value.getLibelle()));

		System.out.println(options.size() + 1 + ". Quitter");
	}

	public void executer(int choix) {
		options.get(choix).execute();
	}
}
