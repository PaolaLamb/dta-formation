package fr.pizzeria.ihm.menu.option;
import java.util.Scanner;
import fr.pizzeria.model.*;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;

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
		
		boolean arg = false ;
		while(!arg) {
			System.out.println("Veuillez saisir la cat�gorie de la pizza (Viande/Poisson/Sans_Viande)");
			String categorie = scan.next() ;
			try {
				newPizza.categoriePizza = CategoriePizza.valueOf(categorie.toUpperCase()) ;
				arg = true ;
			} catch (IllegalArgumentException e) {
				System.out.println("/!\\/!\\ Entr�e non valide /!\\/!\\");
			}
			
		}

	
		try {
			dao.saveNew(newPizza) ;
		} catch (StockageException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
