package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	protected IPizzaDao dao ;
	public Scanner scan ;
	
	public OptionMenu(IPizzaDao dao, Scanner scan) {
		this.dao = dao ;
		this.scan = scan ; 
	}
	
	public abstract String getLibelle();
	public abstract void execute() ;

}
