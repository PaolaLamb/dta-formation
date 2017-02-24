package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class OptionMajPizza extends OptionMenu {
	public OptionMajPizza(IDao<Pizza, String> dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza" ;
	}

	@Override
	public void execute() {
		Pizza newPizza = new Pizza() ;
		System.out.println("Veuillez choisir le code de la pizza � modifier (99 pour quitter)");
		String pizzaPick = scan.nextLine() ;
		if (pizzaPick != "99") {
			System.out.println("Veuillez saisir le code");
			newPizza.code = scan.nextLine() ;
			
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
				dao.update(pizzaPick, newPizza) ;
			} catch (StockageException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
}

