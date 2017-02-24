package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class OptionListePizza extends OptionMenu {
	public OptionListePizza(IDao<Pizza, String> dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Liste des pizzas" ;
	}

	@Override
	public void execute() {
		Pizza[] listPizza = (Pizza[]) dao.findAll() ;
		for (int i = 0; i < listPizza.length; i++) {
			System.out.println(listPizza[i].code + " -> " + listPizza[i].nom + " (" + listPizza[i].prix + "€) ");
		}
		System.out.println(Pizza.nbPizzas + " pizzas ont été créées\n");
	}
	
}
