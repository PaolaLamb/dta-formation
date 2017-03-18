package fr.pizzeria.ihm.menu.tools;

import java.util.Scanner;

import fr.pizzeria.dao.ClientDaoImplArray;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.model.MangeurDePizzas;
import fr.pizzeria.model.Pizza;


/**
 * @author PaolaLamb
 *
 */
public class IhmTools {

	private Scanner scanner = new Scanner(System.in);
	private DaoPizza<Pizza, String> iPizza ;
	private DaoClient iClient = new ClientDaoImplArray();


	/**
	 * @param iPizza
	 * @param iClient
	 */
	public IhmTools(DaoPizza<Pizza, String> iPizza) {
		super();
		this.iPizza = iPizza;
	}

	/**
	 * @return dao pizza
	 */
	public DaoPizza<Pizza, String> getiPizza() {
		return iPizza;
	}

	/**
	 * @return scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * @return dao client
	 */
	public DaoClient getIClient() {
		return iClient;
	}

}