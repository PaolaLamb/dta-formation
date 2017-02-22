package fr.pizzeria.ihm;
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
	public boolean execute() {
		Pizza newPizza = new Pizza() ;
		System.out.println("Veuillez saisir le code");
		newPizza.code = scan.nextLine();
		
		System.out.println("Veuillez saisir le nom");
		newPizza.nom = scan.nextLine() ;
		
		System.out.println("Veuillez saisir le prix");
		newPizza.prix = scan.nextDouble() ;
		
		return dao.saveNewPizza(newPizza) ;
	}
	
	
	
	
	
}
