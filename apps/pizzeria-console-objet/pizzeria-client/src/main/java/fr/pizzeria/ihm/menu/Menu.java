package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.menu.options.Connexion;
import fr.pizzeria.ihm.menu.options.Inscription;
import fr.pizzeria.ihm.tools.IhmTools;

public class Menu {
	private static final String TITLE = "***** Pizzeria Client *****";
	private Map<Integer, OptionMenu> options;
	private IhmTools ihm;

	public Menu(IhmTools ihm) {
		super();
		this.ihm = ihm;

		OptionMenu optionConnexion = new Connexion(ihm);
		OptionMenu optionInscription = new Inscription(ihm);
		Map<Integer, OptionMenu> optionList = new HashMap<>();
		optionList.put(1, optionInscription);
		optionList.put(2, optionConnexion);

		this.options = optionList;
	}

	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}

	public void demarrer() {

		System.out.println(TITLE);

		options.forEach((key, value) -> System.out.println(key + ". " + value.getLibelle()));

		System.out.println(options.size() + 1 + ". Quitter");
	}

	public void executer() {
		int choix = 0;
		while (choix != getOptions().size() + 1) {
			demarrer();
			System.out.println("Veuillez saisir une action : ");
			choix = ihm.getScanner().nextInt();

			if (choix > getOptions().size() + 1) {
				System.out.println("Mauvaise Valeur");
				demarrer();
				choix = ihm.getScanner().nextInt();
			}

			if (choix != getOptions().size() + 1) {
				options.get(choix).execute();
			}
		}
		System.out.println("**** Au revoir ! ****");

	}
}
