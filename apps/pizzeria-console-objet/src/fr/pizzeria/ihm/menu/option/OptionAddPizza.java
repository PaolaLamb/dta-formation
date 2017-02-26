package fr.pizzeria.ihm.menu.option;
import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionAddPizza extends OptionMenu {
	public OptionAddPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza" ;
	}

	@Override
	public void execute() {
		Pizza newPizza = new Pizza() ;
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(scan.next());
		System.out.println("Veuillez saisir le nom");
		newPizza.setNom(scan.next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(scan.nextDouble());
				
		
		dao.saveNew(newPizza);
	}
	
	
	
}
