package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;

public class OptionMajPizza extends OptionMenu {

	public OptionMajPizza(Dao<Pizza, String, CategoriePizza> dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza" ;
	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir le code de la pizza � modifier");
		String codePizza = scan.next() ;
		
		if (codePizza != "99") {
			Pizza newPizza = new Pizza() ;
			System.out.println("Veuillez saisir le code");
			newPizza.setCode(scan.next()) ;
			System.out.println("Veuillez saisir le nom");
			newPizza.setNom(scan.next()) ;
			System.out.println("Veuillez saisir le prix");
			newPizza.setPrix(scan.nextDouble()) ;
			
			boolean arg = false ;
			while(!arg) {
				System.out.println("Veuillez saisir la cat�gorie de la pizza (Viande/Poisson/Sans_Viande)");
				String categorie = scan.next() ;
				try {
					newPizza.setCategoriePizza(CategoriePizza.valueOf(categorie.toUpperCase())) ;
					arg = true ;
				} catch (IllegalArgumentException e) {
					System.out.println("/!\\/!\\ Entr�e non valide /!\\/!\\");
				}
				
			}
			
			try {
				dao.update(codePizza, newPizza);
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

