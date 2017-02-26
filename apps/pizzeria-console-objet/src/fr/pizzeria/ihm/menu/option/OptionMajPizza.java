package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionMajPizza extends OptionMenu {

	public OptionMajPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Modifier une Pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza à modifier");
		String code = scan.next() ;
		
		Pizza newPizza = new Pizza() ;
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(scan.next()) ;
		System.out.println("Veuillez saisir le nom");
		newPizza.setNom(scan.next()) ;
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(scan.nextDouble()) ;

		dao.update(code, newPizza);
		
	}
	
}

