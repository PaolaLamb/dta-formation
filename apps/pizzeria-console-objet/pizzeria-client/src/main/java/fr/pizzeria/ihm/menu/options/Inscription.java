package fr.pizzeria.ihm.menu.options;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

public class Inscription extends OptionMenu {

	public Inscription(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "S'inscrire";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez entrer votre nom :");
		String nom = ihm.getScanner().next();

		System.out.println("Veuillez entrer votre prénom :");
		String prenom = ihm.getScanner().next();

		System.out.println("Veuillez entrer votre adresse mail :");
		String email = ihm.getScanner().next();

		System.out.println("Veuillez entrer votre mot de passe :");
		String password = ihm.getScanner().next();

		ihm.getDaoClient().enregistrementCoordonnees(new Client(nom, prenom, email, password));
	}

}
