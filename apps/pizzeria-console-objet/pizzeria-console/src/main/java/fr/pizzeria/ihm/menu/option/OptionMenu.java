package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	protected Dao<Pizza, String> dao;
	public Scanner scan;

	public OptionMenu(Dao<Pizza, String> dao, Scanner scan) {
		super();
		this.dao = dao;
		this.scan = scan;
	}

	public abstract String getLibelle();

	public abstract void execute();
}
