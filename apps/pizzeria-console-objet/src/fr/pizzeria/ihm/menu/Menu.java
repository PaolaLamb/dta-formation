package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Map.Entry;

import fr.pizzeria.ihm.menu.option.OptionMenu;

public class Menu {
	private String titre;
	private Map<Integer, OptionMenu> options ;
	
	public Menu(String titre, Map<Integer, OptionMenu> actions) { //constructeur
		this.titre = titre ;
		this.options = actions ;
	}
	
	public void demarrer() {							//afficher menu
		System.out.println(titre);
		System.out.println("Veuillez choisir une action (99 pour abandonner)") ;
		for(Entry<Integer, OptionMenu> entrySet : options.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getLibelle()) ;
		}
		System.out.println("5 : quitter");
	}
	
	public void executer(int choix) {
		options.get(choix).execute() ;
	}

}
