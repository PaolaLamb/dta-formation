package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Client;

/**
 * @author PaolaLamb
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * constructor to hide the implicit public one.
	 */
	private PizzeriaAdminConsoleApp() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IhmTools ihm = new IhmTools(new PizzaDaoImplArray());
		
	

		Menu menu = new Menu(ihm);

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
