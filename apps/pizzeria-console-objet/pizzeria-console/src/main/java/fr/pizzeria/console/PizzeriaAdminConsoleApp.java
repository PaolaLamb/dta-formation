package fr.pizzeria.console;

import fr.pizzeria.dao.PizzaDaoImplArray;

import fr.pizzeria.dao.admin.PizzaDaoImplJPA;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

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
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		IhmTools ihm = new IhmTools(new PizzaDaoImplJPA());

		new Menu(ihm).executer();

	}

}
