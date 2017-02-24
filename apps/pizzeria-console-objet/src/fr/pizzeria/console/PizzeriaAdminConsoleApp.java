package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.OptionAddPizza;
import fr.pizzeria.ihm.menu.option.OptionDelPizza;
import fr.pizzeria.ihm.menu.option.OptionListePizza;
import fr.pizzeria.ihm.menu.option.OptionMajPizza;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
				
		List<Pizza> listePizzas = new ArrayList<>();
		listePizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		listePizzas.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza(3, "FRO", "La 4 fromage", 12.00, CategoriePizza.SANS_VIANDE));
		listePizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON ));
		listePizzas.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.POISSON));
				
		IDao<Pizza, String> dao = new PizzaDaoImpl(listePizzas) ;
		
		OptionMenu optionList = new OptionListePizza(dao, scan) ;
		OptionMenu optionAdd = new OptionAddPizza(dao, scan) ;
		OptionMenu optionChange = new OptionMajPizza(dao, scan) ;
		OptionMenu optionDel = new OptionDelPizza(dao, scan) ;
		Map<Integer, OptionMenu> options = new HashMap<>() ;
		options.put(1, optionList) ;
		options.put(2, optionAdd) ;
		options.put(3, optionChange) ;
		options.put(4, optionDel) ;
		
		
		Menu menu = new Menu("**** Pizzeria Administration ****", options) ;
		
		
		int choix = 0 ;
		while (choix != 5) {
			menu.demarrer();			//réaffiche menu tant qu'entrée != 5
			choix = scan.nextInt() ;
			scan.nextLine() ;
			
			while (choix > options.size() + 1) {
				System.out.println("\n!!! Valeur non autorisée !!!\n");
				menu.demarrer();
				choix = scan.nextInt() ;
				scan.nextLine() ;
			}
			if (choix!=5) {
				menu.executer(choix);
			}
		}
		System.out.println("Au revoir !");
		scan.close() ;
	}

}
