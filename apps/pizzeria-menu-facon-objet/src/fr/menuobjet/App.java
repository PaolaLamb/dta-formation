package fr.menuobjet;

import java.util.Scanner;

import fr.menuobjet.menu.Menu;
import fr.menuobjet.menu.item.MenuAdd;
import fr.menuobjet.menu.item.MenuItem;
import fr.menuobjet.menu.item.MenuList;

public class App {

	public static void main(String[] args) {
		MenuItem[] menuItems = { new MenuList(), new MenuAdd(), new MenuRemonve() };

		Menu menu = new Menu("*** Application Pizzeria Console ***", menuItems);
		menu.demarrer();

		Scanner scan = new Scanner(System.in);

	}

}
