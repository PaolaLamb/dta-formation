package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author Paola
 * Action du menu afficher la liste des livreurs
 */
public class OptionListLivreur extends OptionMenu{

	/**
	 * @param ihm
	 */
	public OptionListLivreur(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Lister les livreurs";
	}

	@Override
	public void execute() {
		ihm.getiClient().findAllLivreur().stream().forEach(System.out::println) ;
	}
	
	

}
