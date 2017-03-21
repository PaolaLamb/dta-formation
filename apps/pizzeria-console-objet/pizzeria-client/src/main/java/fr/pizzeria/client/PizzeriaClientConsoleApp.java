package fr.pizzeria.client;

import java.util.logging.Level;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaClientConsoleApp {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		IhmTools ihm = new IhmTools();

		new Menu(ihm).executer();
	}

}
