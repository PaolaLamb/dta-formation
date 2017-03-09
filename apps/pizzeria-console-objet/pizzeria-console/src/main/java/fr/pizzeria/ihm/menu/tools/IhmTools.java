package fr.pizzeria.ihm.menu.tools;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoImplBD;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class IhmTools {

	Scanner scanner = new Scanner(System.in);
	Dao<Pizza, String, CategoriePizza> iPizza = new PizzaDaoImplBD();

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String, CategoriePizza> getiPizza() {
		return iPizza;
	}

}