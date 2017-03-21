package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.ClientDaoImplArray;
import fr.pizzeria.dao.DaoClient;

public class IhmTools {
	private Scanner scan = new Scanner(System.in);
	private DaoClient daoClient = new ClientDaoImplArray();

	public Scanner getScan() {
		return scan;
	}

	public DaoClient getDaoClient() {
		return daoClient;
	}

	public IhmTools() {
		super();
	}

	public Scanner getScanner() {
		return scan;
	}

}
