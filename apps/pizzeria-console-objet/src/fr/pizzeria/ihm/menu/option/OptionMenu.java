package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	protected IPizzaDao dao ;
	public Scanner scan ;
	
	
	public OptionMenu(IPizzaDao<Pizza, String> dao, Scanner scan) {
		super();
		this.dao = dao;
		this.scan = scan;
	}
	
	public abstract String getLibelle() ;
	public abstract void execute() ;
}
