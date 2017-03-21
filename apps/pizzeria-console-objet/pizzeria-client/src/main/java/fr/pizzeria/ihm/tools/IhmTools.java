package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.client.ConsoleClientDaoImplJPA;
import fr.pizzeria.dao.client.DaoConsoleClient;

public class IhmTools {
	private Scanner scan = new Scanner(System.in);
	private DaoConsoleClient daoClient = new ConsoleClientDaoImplJPA();

	public Scanner getScan() {
		return scan;
	}

	public DaoConsoleClient getDaoClient() {
		return daoClient;
	}

	public IhmTools() {
		super();
	}

	public Scanner getScanner() {
		return scan;
	}

}
