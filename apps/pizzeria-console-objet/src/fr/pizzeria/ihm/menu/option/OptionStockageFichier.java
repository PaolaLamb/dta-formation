package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoFichier;

public class OptionStockageFichier extends OptionMenu {

	public OptionStockageFichier(PizzaDaoFichier dao, Scanner scan) {
		super(dao, scan);
	}

	@Override
	public String getLibelle() {
		return "Créer un fichier pour chaque pizza";
	}

	@Override
	public void execute() {
		dao.createFiles();
	}

}
