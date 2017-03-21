package fr.pizzeria.ihm.menu.options;

import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class Connexion extends OptionMenu {

	public Connexion(IhmTools ihm) {
		super(ihm);
	}

	@Override
	public String getLibelle() {
		return "Se connecter";
	}

	@Override
	public void execute() {

	}

}
