package fr.pizzeria.ihm.menu;

import org.springframework.stereotype.Controller;

/**
 * @author PaolaLamb
 *
 */
@Controller
public abstract class OptionMenu {

	/**
	 * @param dao
	 * @param scan
	 */
	public OptionMenu() {

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
