package fr.pizzeria.ihm.menu.optionClient;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Client;

/**
 * @author PaolaLamb Action du menu ajouter un client
 */

@Controller
public class OptionAjouterClient extends OptionMenu {

	private Scanner scanner;
	private DaoClient dao;

	@Autowired
	public OptionAjouterClient(Scanner scanner, DaoClient dao) {
		super();
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Ajouter un client";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez entrer le nom du client :");
		String nom = this.scanner.next();

		System.out.println("Veuillez entrer le prénom du client :");
		String prenom = this.scanner.next();

		dao.ajouterNouveauClient(new Client(dao.nbClient() + 1, nom, prenom, 0.0));

	}

}
