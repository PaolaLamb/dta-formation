package fr.pizzeria.ihm.menu.optionClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;

/**
 * @author PaolaLamb Action du menu Afficher la liste des clients
 *
 */

@Controller
public class OptionListClient extends OptionMenu {

	private DaoClient dao;

	@Autowired
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
