package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public abstract class OptionMenu {
	protected Dao<Pizza, String> dao;
	protected Scanner scan;

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionMenu(Dao<Pizza, String> dao, Scanner scan) {
		super();
		this.dao = dao;
		this.scan = scan;
	}

	/**
	 * @return le libellé de l'option choisie
	 */
	public abstract String getLibelle();

	/**
	 * exécute l'option choisie
	 */
	public abstract void execute();
}
