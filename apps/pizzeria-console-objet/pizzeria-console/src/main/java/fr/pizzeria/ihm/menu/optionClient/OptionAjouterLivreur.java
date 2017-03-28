package fr.pizzeria.ihm.menu.optionClient;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

/**
 * @author PaolaLamb Action du menu ajouter un client
 */

@Controller
public class OptionAjouterLivreur extends OptionMenu {

	private Scanner scanner;
	private DaoClient dao;

	@Autowired
	public OptionAjouterLivreur(Scanner scanner, DaoClient dao) {
		super();
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Ajouter un Livreur (Automatiquement ajouté aux clients)";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez entrer le nom du livreur :");
		String nom = this.scanner.next();

		System.out.println("Veuillez entrer le prénom du livreur :");
		String prenom = this.scanner.next();

		this.dao.ajouterNouveauClient(new Client(this.dao.findAll().size() + 1, nom, prenom, 0.0));
		this.dao.ajouterNouveauLivreur(new Livreur(this.dao.findAllLivreur().size() + 1, nom, prenom));

	}

}
