package fr.pizzeria.ihm.menu.option;
import java.util.Scanner;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionAddPizza extends OptionMenu {
	public OptionAddPizza(IDao<Pizza, String> dao, Scanner scan) {
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
		newPizza.code = scan.nextLine();
		
		System.out.println("Veuillez saisir le nom");
		newPizza.nom = scan.nextLine() ;
		
		System.out.println("Veuillez saisir le prix");
		newPizza.prix = scan.nextDouble() ;
		
		try {
			dao.saveNew(newPizza) ;
		} catch (StockageException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
