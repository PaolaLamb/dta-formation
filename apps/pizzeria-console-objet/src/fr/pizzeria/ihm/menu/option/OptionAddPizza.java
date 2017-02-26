package fr.pizzeria.ihm.menu.option;
import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionAddPizza extends OptionMenu {
	public OptionAddPizza(IPizzaDao<Pizza, String> dao, Scanner scan) {
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
				
		boolean arg = false ;
		while(!arg) {
			System.out.println("Veuillez saisir la catégorie de la pizza (Viande/Poisson/Sans_Viande)");
			String categorie = scan.next() ;
			try {
				newPizza.categoriePizza = CategoriePizza.valueOf(categorie.toUpperCase()) ;
				arg = true ;
			} catch (IllegalArgumentException e) {
				System.out.println("/!\\/!\\ Entrée non valide /!\\/!\\");
			}
		
		
		try {
			dao.saveNew(newPizza) ;
		} catch (StockageException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
