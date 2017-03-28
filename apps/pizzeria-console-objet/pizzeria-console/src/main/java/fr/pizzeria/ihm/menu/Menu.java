package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Scanner;

/**
 * @author PaolaLamb
 *
 */
public class Menu {
	private String title = "**** Pizzeria Administration ****";
	private Map<Integer, OptionMenu> options;
	private Scanner scanner;

	/**
	 * @param title
	 * @param options
	 */
	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}

	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}

	public void setOptions(Map<Integer, OptionMenu> options) {
		this.options = options;
	}

	/**
	 * Lancement du menu
	 */
	public void demarrer() {
		System.out.println(title);

		options.forEach((key, value) -> System.out.println(key + ". " + value.getLibelle()));

		System.out.println(options.size() + 1 + ". Quitter");
	}

	/**
	 * @param choix
	 *            Lancement du menu, choix de l'option et execution de l'option
	 *            choisie
	 */
	public void executer() {
		int choix = 0;
		while (choix != getOptions().size() + 1) {
			demarrer();
			System.out.println("Veuillez saisir une action");
			choix = this.scanner.nextInt();

			if (choix > getOptions().size() + 1) {
				System.out.println("Mauvaise Valeur");
				demarrer();
				choix = this.scanner.nextInt();
			}

			if (choix != getOptions().size() + 1) {
				options.get(choix).execute();
			}
		}
		System.out.println("**** Au revoir ! ****");

	}
}
