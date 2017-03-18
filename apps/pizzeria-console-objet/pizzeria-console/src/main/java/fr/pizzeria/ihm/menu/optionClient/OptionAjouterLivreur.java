package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

/**
 * @author PaolaLamb
 *Action du menu ajouter un client
 */
public class OptionAjouterLivreur extends OptionMenu {

	/**
	 * @param ihm
	 */
	public OptionAjouterLivreur(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Ajouter un Livreur (Automatiquement ajouté aux clients)";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez entrer le nom du livreur :");
		String nom = ihm.getScanner().next() ;
		
		System.out.println("Veuillez entrer le prénom du livreur :");
		String prenom = ihm.getScanner().next() ;
		
			
		ihm.getIClient().ajouterNouveauClient(new Client(ihm.getIClient().findAll().size() + 1, nom, prenom, 0.0));
		ihm.getIClient().ajouterNouveauLivreur(new Livreur(ihm.getIClient().findAllLivreur().size() + 1, nom, prenom));
			
	}

	
	
}
