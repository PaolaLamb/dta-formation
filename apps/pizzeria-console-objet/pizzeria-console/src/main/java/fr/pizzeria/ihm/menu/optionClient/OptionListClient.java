package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 * Action du menu Afficher la liste des clients
 *
 */
public class OptionListClient extends OptionMenu {

	/**
	 * @param ihm
	 */
	public OptionListClient(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Lister les clients" ;
	}

	@Override
	public void execute() {
		ihm.getiClient().findAll().stream().forEach(System.out::println) ;
	}

}
