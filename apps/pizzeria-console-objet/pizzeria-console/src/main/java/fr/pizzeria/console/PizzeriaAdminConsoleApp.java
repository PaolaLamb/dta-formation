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
		
	
		new Menu(ihm).executer();


	}

}
