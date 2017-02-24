package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.OptionAddPizza;
import fr.pizzeria.ihm.menu.option.OptionDelPizza;
import fr.pizzeria.ihm.menu.option.OptionListePizza;
import fr.pizzeria.ihm.menu.option.OptionMajPizza;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Pizza pep = new Pizza(0, "PEP", "Pépéroni", 12.50);
		Pizza mar = new Pizza(1, "MAR", "Margherita", 14.00);
		Pizza rei = new Pizza(2, "REI", "La Reine", 11.50);
		Pizza fro = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		Pizza can = new Pizza(4, "CAN", "La cannibale", 12.50);
		Pizza sav = new Pizza(5, "SAV", "La savoyarde", 13.00);
		Pizza ori = new Pizza(6, "ORI", "L'orientale", 13.50);
		Pizza ind = new Pizza(7, "IND", "L'indienne", 14.00);
		Pizza[] listePizzas = { pep, mar, rei, fro, can, sav, ori, ind };
		
		IDao<Pizza, String> dao = new PizzaDaoImpl(listePizzas) ;
		
		
		OptionMenu optionList = new OptionListePizza(dao, scan) ;
		OptionMenu optionAdd = new OptionAddPizza(dao, scan) ;
		OptionMenu optionChange = new OptionMajPizza(dao, scan) ;
		OptionMenu optionDel = new OptionDelPizza(dao, scan) ;
				OptionMenu[] options = {optionList, optionAdd, optionChange, optionDel} ; //le choix de l'option permettra l'execute() approprié
		Menu menu = new Menu("**** Pizzeria Administration ****", options) ;
		
		int choix = 0 ;
		while (choix != 5) {
			menu.demarrer();			//réaffiche menu tant qu'entrée != 5
			choix = scan.nextInt() ;
			scan.nextLine() ;
			
			while (choix > options.length + 1) {
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
