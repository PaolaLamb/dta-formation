package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Client;

/**
 * @author PaolaLamb
 *Action du menu ajouter un client
 */
public class OptionAjouterClient extends OptionMenu {

	/**
	 * @param ihm
	 */
	public OptionAjouterClient(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Ajouter un client";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez entrer le nom du client :");
		String nom = ihm.getScanner().next() ;
		
		System.out.println("Veuillez entrer le prénom du client :");
		String prenom = ihm.getScanner().next() ;
		
		System.out.println("Le client est-il également livreur ? (oui/non) :");
		String livreur = ihm.getScanner().next() ;
		
		if(livreur.equals("oui")) {
			ihm.getiClient().ajouterNouveauClient(new Client(ihm.getiClient().nbClient() + 1, nom, prenom, 0.0), livreur);
		}
		else if(livreur.equals("non")) {
			ihm.getiClient().ajouterNouveauClient(new Client(ihm.getiClient().nbClient() + 1, nom, prenom, 0.0), livreur);
		}
		else { 
			System.out.println("/!\\/!\\ Entrée invalide /!\\/!\\ \nRecommencez :");
			execute();
		}
				
		
		
		
	}

	
	
}
