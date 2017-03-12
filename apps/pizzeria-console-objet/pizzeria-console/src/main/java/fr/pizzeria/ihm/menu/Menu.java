package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.menu.optionClient.OptionAjouterClient;
import fr.pizzeria.ihm.menu.optionClient.OptionCrediterCompte;
import fr.pizzeria.ihm.menu.optionClient.OptionDebiterCompte;
import fr.pizzeria.ihm.menu.optionClient.OptionListClient;
import fr.pizzeria.ihm.menu.optionClient.OptionListLivreur;
import fr.pizzeria.ihm.menu.optionPizza.OptionAddPizza;
import fr.pizzeria.ihm.menu.optionPizza.OptionDelPizza;
import fr.pizzeria.ihm.menu.optionPizza.OptionListePizza;
import fr.pizzeria.ihm.menu.optionPizza.OptionListerParCategorie;
import fr.pizzeria.ihm.menu.optionPizza.OptionMajPizza;
import fr.pizzeria.ihm.menu.optionPizza.OptionMostExpensivePizza;
import fr.pizzeria.ihm.menu.tools.IhmTools;

/**
 * @author PaolaLamb
 *
 */
public class Menu {
	private String title = "**** Pizzeria Administration ****";
	private Map<Integer, OptionMenu> options;
	private IhmTools ihm ;

	/**
	 * @param title
	 * @param options
	 */
	public Menu(IhmTools ihmTool) {
		this.ihm = ihmTool ;
		
		OptionMenu optionListe = new OptionListePizza(ihm);
		OptionMenu optionAdd = new OptionAddPizza(ihm);
		OptionMenu optionMaj = new OptionMajPizza(ihm);
		OptionMenu optionDel = new OptionDelPizza(ihm);
		OptionMenu optionCat = new OptionListerParCategorie(ihm);
		OptionMenu optionExp = new OptionMostExpensivePizza(ihm);
		OptionMenu optionListeClient = new OptionListClient(ihm) ;
		OptionMenu optionAjouterClient = new OptionAjouterClient(ihm) ;
		OptionMenu optionCrediter = new OptionCrediterCompte(ihm) ;
		OptionMenu optionDebiter = new OptionDebiterCompte(ihm) ;
		OptionMenu optionListeLivreur = new OptionListLivreur(ihm) ;
		Map<Integer, OptionMenu> option = new HashMap<>();
		option.put(1, optionListe);
		option.put(2, optionAdd);
		option.put(3, optionMaj);
		option.put(4, optionDel);
		option.put(5, optionCat);
		option.put(6, optionExp);
		option.put(7, optionListeClient) ;
		option.put(8, optionAjouterClient) ;
		option.put(9, optionCrediter) ;
		option.put(10, optionDebiter) ;
		option.put(11, optionListeLivreur) ;
		this.options = option;

	}

	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}

	/**
	 * Lancement du menu
	 */
	public void demarrer() {
		System.out.println(title);

		options.forEach((key, value) -> System.out.println(key + ". " + value.getLibelle()));

		System.out.println(options.size() + 1 + ". Quitter");
	}

	/**
	 * @param choix
	 * Lancement du menu, choix de l'option et execution de l'option choisie
	 */
	public void executer() {
		int choix = 0 ;
		while (choix != getOptions().size() + 1) {
			demarrer();
			System.out.println("Veuillez saisir une action");
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
