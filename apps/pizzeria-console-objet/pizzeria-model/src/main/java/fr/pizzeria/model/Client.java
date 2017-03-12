package fr.pizzeria.model;

/**
 * @author PaolaLamb 
 * Création du modèle client qui étend la classe abstraite mangeur de pizzas
 */
public class Client extends MangeurDePizzas {

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(int id, String nom, String prenom, Double solde) {
		super(id, nom, prenom, solde);
	}


}
