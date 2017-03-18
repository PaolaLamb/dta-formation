package fr.pizzeria.model;

import fr.pizzeria.exception.CrediterException;
import fr.pizzeria.exception.DebiterException;

/**
 * @author PaolaLamb 
 * Création du modèle client qui étend la classe abstraite mangeur de pizzas
 */
public class Client extends MangeurDePizzas {
	private Double solde ;
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(int id, String nom, String prenom, Double solde) {
		super(id, nom, prenom);
		this.solde = solde ;
	}

	/**
	 * @param montant
	 * @throws CrediterException
	 *  Crédit du solde d'un client
	 */
	public void crediterCompte(double montant) throws CrediterException {
		double newSolde = this.solde + montant;
		if (newSolde <= MONTANT_MAX) {
		this.solde = newSolde ;
		} else {
			throw new CrediterException("Montant maximum dépassé");
		}
	}
	
	/**
	 * @param montant
	 * @throws DebiterException
	 * 	Débit du solde d'un client
	 */
	public void debiterCompte(double montant) throws DebiterException {
		double newSolde = this.solde - montant;
		if(newSolde<MONTANT_MIN) {
			throw new DebiterException("Solde trop faible pour effectuer cette action") ;
		} else {
			this.solde = newSolde ;
		}	
	}
	

	@Override
	public String toString() {
		return this.id + " -> " + this.prenom + " " + this.nom + " (" + this.solde + " €)" ;
	}



}
