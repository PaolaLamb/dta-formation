package fr.pizzeria.ihm.menu;

import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 *
 */
public abstract class OptionMenu {
	protected IhmTools ihm ;

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionMenu(IhmTools ihm) {
		super();
		this.ihm = ihm ;
	}
	
	

	/**
	 * @return le libellé de l'option choisie
	 */
	public abstract String getLibelle();

	/**
	 * exécute l'option choisie
	 */
	public abstract void execute();
}
