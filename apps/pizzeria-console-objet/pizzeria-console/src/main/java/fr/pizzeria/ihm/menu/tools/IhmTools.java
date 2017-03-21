package fr.pizzeria.ihm.menu.tools;

import java.util.Scanner;

import fr.pizzeria.dao.ClientDaoImplArray;
import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoPizza;

import fr.pizzeria.model.Pizza;


/**
 * @author PaolaLamb
 *
 */
public class IhmTools {

	private Scanner scanner = new Scanner(System.in);
	private DaoGestionPizza<Pizza, String> iPizza ;
	private DaoGestionClient iClient = new ClientDaoImplArray();


	/**
	 * @param iPizza
	 * @param iClient
	 */
	public IhmTools(DaoGestionPizza<Pizza, String> iPizza) {
		super();
		this.iPizza = iPizza;
	}

	/**
	 * @return dao pizza
	 */
	public DaoGestionPizza<Pizza, String> getiPizza() {
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