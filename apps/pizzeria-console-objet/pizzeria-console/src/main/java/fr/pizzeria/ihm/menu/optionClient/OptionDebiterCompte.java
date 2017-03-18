package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 * Action de l'option du menu débiter client
 */
public class OptionDebiterCompte extends OptionMenu{
	OptionListClient clientList = new OptionListClient(ihm) ;
	double montant ;
	int choix ;
	
	/**
	 * @param ihm
	 */
	public OptionDebiterCompte(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Débiter le compte d'un client" ;
	}

	@Override
	public void execute() {

		clientList.execute() ;
		System.out.println("Veuillez choisir le client à débiter :");
		choix = ihm.getScanner().nextInt() ;
		
		int clientListSize = ihm.getIClient().nbClient() ;
		if(choix>clientListSize) {
			System.out.println("/!\\/!\\ Client introuvable /!\\/!\\ \nVeuillez saisir un client valide :") ;
			choix = ihm.getScanner().nextInt() ;
		}
		
		System.out.println("Veuillez choisir le montant à débiter");
		montant = ihm.getScanner().nextDouble() ;
		
		ihm.getIClient().debiterCompteClient(choix-1, montant);
	}

}
