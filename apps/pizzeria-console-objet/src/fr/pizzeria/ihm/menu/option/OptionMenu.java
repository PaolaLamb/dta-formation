package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	protected IDao dao ;
	public Scanner scan ;
	
	public OptionMenu(IDao dao, Scanner scan) {
		this.dao = dao ;
		this.scan = scan ; 
	}
	
	public abstract String getLibelle();
	public abstract void execute() ;

}
