package fr.pizzeria.ihm.menu.optionClient;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;

/**
 * @author PaolaLamb Action du menu Afficher la liste des clients
 *
 */
public class OptionListClient extends OptionMenu {

	private DaoClient dao;

	public OptionListClient(DaoClient dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Lister les clients";
	}

	@Override
	public void execute() {
		this.dao.findAll().stream().forEach(System.out::println);
	}

}
