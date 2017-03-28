package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import fr.pizzeria.ihm.menu.optionClient.OptionAjouterClient;
import fr.pizzeria.ihm.menu.optionClient.OptionAjouterLivreur;
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

/**
 * @author PaolaLamb
 *
 */
@Controller
public class Menu {
	private String title = "**** Pizzeria Administration ****";
	private Map<Integer, OptionMenu> options;
	private Scanner scanner;

	/**
	 * @param title
	 * @param options
	 */
	@Autowired
	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}

	public Map<Integer, OptionMenu> getOptions() {
		return options;
	}

	public void setOptions(Map<Integer, OptionMenu> options) {
		this.options = options;
	}

	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		this.options = new HashMap<Integer, OptionMenu>();
		options.put(1, context.getBean(OptionListePizza.class));
		options.put(2, context.getBean(OptionAddPizza.class));
		options.put(3, context.getBean(OptionMajPizza.class));
		options.put(4, context.getBean(OptionDelPizza.class));
		options.put(5, context.getBean(OptionListerParCategorie.class));
		options.put(6, context.getBean(OptionMostExpensivePizza.class));
		options.put(7, context.getBean(OptionListClient.class));
		options.put(8, context.getBean(OptionAjouterClient.class));
		options.put(9, context.getBean(OptionCrediterCompte.class));
		options.put(10, context.getBean(OptionDebiterCompte.class));
		options.put(11, context.getBean(OptionListLivreur.class));
		options.put(12, context.getBean(OptionAjouterLivreur.class));
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
	 *            Lancement du menu, choix de l'option et execution de l'option
	 *            choisie
	 */
	public void executer() {
		int choix = 0;
		while (choix != getOptions().size() + 1) {
			demarrer();
			System.out.println("Veuillez saisir une action");
			choix = this.scanner.nextInt();

			if (choix > getOptions().size() + 1) {
				System.out.println("Mauvaise Valeur");
				demarrer();
				choix = this.scanner.nextInt();
			}

			if (choix != getOptions().size() + 1) {
				options.get(choix).execute();
			}
		}
		System.out.println("**** Au revoir ! ****");

	}
}
