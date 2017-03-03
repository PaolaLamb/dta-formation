package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class IhmTools {

	Scanner scanner = new Scanner(System.in);
	Dao<Pizza, String, CategoriePizza> iPizza = new PizzaDaoImpl();

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String, CategoriePizza> getiPizza() {
		return iPizza;
	}

}