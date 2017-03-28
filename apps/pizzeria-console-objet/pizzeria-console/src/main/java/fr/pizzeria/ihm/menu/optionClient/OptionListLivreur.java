package fr.pizzeria.ihm.menu.optionClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;

/**
 * @author Paola Action du menu afficher la liste des livreurs
 */

@Controller
public class OptionListLivreur extends OptionMenu {

	private DaoClient dao;

	@Autowired
	public OptionListLivreur(DaoClient dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Lister les livreurs";
	}

	@Override
	public void execute() {
		this.dao.findAllLivreur().stream().forEach(System.out::println);
	}

}
