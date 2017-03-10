package fr.pizzeria.ihm.menu.tools;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoImplJPA;
import fr.pizzeria.model.Pizza;

public class IhmTools {

	Scanner scanner = new Scanner(System.in);
	Dao<Pizza, String> iPizza = new PizzaDaoImplJPA();

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String> getiPizza() {
		return iPizza;
	}

}