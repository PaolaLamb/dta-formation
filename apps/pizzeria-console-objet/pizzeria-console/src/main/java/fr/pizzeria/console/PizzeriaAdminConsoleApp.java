package fr.pizzeria.console;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		IhmTools ihm = new IhmTools();

		Menu menu = new Menu();

		Integer choix = 0;

		while (choix != menu.getOptions().size() + 1) {
			menu.demarrer();
			System.out.println("Veuillez saisir une action");
			choix = ihm.getScanner().nextInt();

			if (choix > menu.getOptions().size() + 1) {
				System.out.println("Mauvaise Valeur");
				menu.demarrer();
				choix = ihm.getScanner().nextInt();
			}

			if (choix != menu.getOptions().size() + 1) {
				menu.executer(choix);
			}
		}
		System.out.println("**** Au revoir ! ****");

		ihm.getScanner().close();
	}

}
