package fr.pizzeria.ihm.menu;

import fr.pizzeria.ihm.tools.IhmTools;

public abstract class OptionMenu {
	protected IhmTools ihm;

	public OptionMenu(IhmTools ihm) {
		super();
		this.ihm = ihm;
	}

	public abstract String getLibelle();

	public abstract void execute();
}
