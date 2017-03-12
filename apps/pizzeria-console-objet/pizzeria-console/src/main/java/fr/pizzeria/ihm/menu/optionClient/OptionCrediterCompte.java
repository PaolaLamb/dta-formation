package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 * Action du menu créditer client
 *
 */
public class OptionCrediterCompte extends OptionMenu {
	OptionListClient clientList = new OptionListClient(ihm) ;
	double montant ;
	int choix ;
	
	/**
	 * @param ihm
	 */
	public OptionCrediterCompte(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Créditer le compte d'un client" ;
	}

	@Override
	public void execute() {

		clientList.execute() ;
		System.out.println("Veuillez choisir le client à créditer :");
		choix = ihm.getScanner().nextInt() ;
		
		int clientListSize = ihm.getiClient().nbClient() ;
		if(choix>clientListSize) {
			System.out.println("/!\\/!\\ Client introuvable /!\\/!\\ \nVeuillez saisir un client valide :") ;
			choix = ihm.getScanner().nextInt() ;
		}
		
		System.out.println("Veuillez choisir le montant à créditer");
		montant = ihm.getScanner().nextDouble() ;
		
		ihm.getiClient().crediterCompteClient(choix-1, montant);
	}

}
