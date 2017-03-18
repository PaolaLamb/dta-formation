package fr.pizzeria.model;

/**
 * @author Paola
 * Création du modèle livreur qui étend la classe abstraite mangeur de pizzas
 */
public class Livreur extends MangeurDePizzas {

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Livreur(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}
	

	@Override
	public String toString() {
		return this.id + " -> " + this.prenom + " " + this.nom ;
	}

	
}
