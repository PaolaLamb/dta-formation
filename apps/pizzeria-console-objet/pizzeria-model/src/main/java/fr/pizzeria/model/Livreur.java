package fr.pizzeria.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * @author Paola Création du modèle livreur qui étend la classe abstraite
 *         mangeur de pizzas
 */
@Entity
public class Livreur extends MangeurDePizzas {

	@OneToMany(mappedBy = "livreur")
	private Set<Commande> commandes;

	public Livreur() {
		commandes = new HashSet<>();
	}


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

	
