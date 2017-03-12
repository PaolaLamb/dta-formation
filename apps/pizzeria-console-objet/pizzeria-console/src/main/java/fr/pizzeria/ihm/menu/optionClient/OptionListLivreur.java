package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.menu.tools.IhmTools;

public class OptionListLivreur extends OptionMenu{

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
