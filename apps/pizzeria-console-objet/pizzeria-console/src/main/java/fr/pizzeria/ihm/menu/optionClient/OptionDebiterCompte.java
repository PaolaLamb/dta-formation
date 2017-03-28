package fr.pizzeria.ihm.menu.optionClient;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;

/**
 * @author PaolaLamb Action de l'option du menu débiter client
 */

@Controller
public class OptionDebiterCompte extends OptionMenu {

	private Scanner scanner;
	private DaoClient dao;
	OptionListClient clientList;
	double montant;
	int choix;

	@Autowired
	public OptionDebiterCompte(Scanner scanner, DaoClient dao, OptionListClient clientList) {
		super();
		this.scanner = scanner;
		this.dao = dao;
		this.clientList = clientList;
	}

	@Override
	public String getLibelle() {
		return "Débiter le compte d'un client";
	}

	@Override
	public void execute() {

		clientList.execute();
		System.out.println("Veuillez choisir le client à débiter :");
		choix = this.scanner.nextInt();

		int clientListSize = this.dao.nbClient();
		if (choix > clientListSize) {
			System.out.println("/!\\/!\\ Client introuvable /!\\/!\\ \nVeuillez saisir un client valide :");
			choix = this.scanner.nextInt();
		}

		System.out.println("Veuillez choisir le montant à débiter");
		montant = this.scanner.nextDouble();

		this.dao.debiterCompteClient(choix - 1, montant);
	}

	public OptionDebiterCompte(DaoClient dao) {
		super();
		this.dao = dao;
	}

}
