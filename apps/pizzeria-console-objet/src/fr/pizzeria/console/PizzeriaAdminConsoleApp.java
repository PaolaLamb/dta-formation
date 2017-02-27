package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.*;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.CategoriePizza;


public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in) ;
		
		List<Pizza> pizzaList = new ArrayList<>() ;
		pizzaList.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)) ;
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON)) ;
		pizzaList.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.SANS_VIANDE)) ;
		pizzaList.add(new Pizza(3, "FRO", "La 4 Fromage", 12.00, CategoriePizza.SANS_VIANDE)) ;
		pizzaList.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE)) ;
		pizzaList.add(new Pizza(5, "SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE)) ;
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON)) ;
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE)) ;
		
		IPizzaDao<Pizza, String, CategoriePizza> dao = new PizzaDaoImpl(pizzaList) ;
		
		OptionListePizza optionListe = new OptionListePizza(dao, scan) ;
		OptionAddPizza optionAdd = new OptionAddPizza(dao, scan) ;
		OptionMajPizza optionMaj = new OptionMajPizza(dao, scan) ;
		OptionDelPizza optionDel = new OptionDelPizza(dao, scan) ;
		OptionListerParCategorie optionCat = new OptionListerParCategorie(dao, scan) ;
		OptionMostExpensivePizza optionExp = new OptionMostExpensivePizza(dao, scan) ;
		
		Map<Integer, OptionMenu> options = new HashMap<>() ;
		options.put(1, optionListe) ;
		options.put(2, optionAdd) ;
		options.put(3, optionMaj) ;
		options.put(4, optionDel) ;
		options.put(5, optionCat) ;
		options.put(6, optionExp) ;
		
		
	
		Menu menu = new Menu("**** Pizzeria Administration ****", options) ;
		
		Integer choix = 0 ;

		while(choix != options.size()+1) {
			menu.demarrer();
			System.out.println("Veuillez saisir une action");
			choix = scan.nextInt() ;
			
			if(choix > options.size() + 1) {
				System.out.println("Mauvaise Valeur");
				menu.demarrer();
				choix = scan.nextInt() ;
			}
			
			if(choix!= options.size()+1) {
				menu.executer(choix);
			}
		}
		System.out.println("**** Au revoir ! ****");
		
		
		scan.close();
	}

}
