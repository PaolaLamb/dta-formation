package fr.pizzeria.ihm.menu;

import java.util.Map;
// import java.util.Map.Entry;

import fr.pizzeria.ihm.menu.option.OptionMenu;

public class Menu {
	private String title;
	private Map<Integer, OptionMenu> options;

	public Menu(String title, Map<Integer, OptionMenu> options) {
		this.title = title;
		this.options = options;
	}

	public void demarrer() {
		System.out.println(title);
		System.out.println("Veuillez choisir une action (99 pour abandonner)");

		options.forEach((key, value) -> System.out.println(key + ". " + value.getLibelle()));

		System.out.println(options.size() + 1 + ". Quitter");
	}

	public void executer(int choix) {
		options.get(choix).execute();
	}
}
