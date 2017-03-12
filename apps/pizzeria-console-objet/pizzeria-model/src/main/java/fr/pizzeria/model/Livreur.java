package fr.pizzeria.model;

import fr.pizzeria.exception.CrediterException;
import fr.pizzeria.exception.DebiterException;

/**
 * @author Paola
 * Création du modèle livreur qui étend la classe abstraite mangeur de pizzas
 */
public class Livreur extends MangeurDePizzas {
	private double decouvertAutorise = 200.00 ;


	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Livreur(int id, String nom, String prenom, Double solde) {
		super(id, nom, prenom, solde);
	}
	

	/**
	 * @return le découvert autorisé du livreur
	 */
	public double getDECOUVERT() {
		return decouvertAutorise;
	}

	/**
	 * @param decouvert
	 * change le découvert autorisé du livreur
	 */
	public void setDECOUVERT(double decouvert) {
		this.decouvertAutorise = decouvert;
	}

	
	@Override
	public void crediterCompte(double montant) throws CrediterException {
		double newSolde = this.solde + montant;
		if (newSolde <= MONTANT_MAX) {
		this.solde = newSolde ;
		} else {
			throw new CrediterException("Montant maximum dépassé");
		}
	}


	@Override
	public void debiterCompte(double montant) throws DebiterException {
		double newSolde = this.solde - montant;
		if(newSolde< (MONTANT_MIN+decouvertAutorise)) {
			throw new DebiterException("Solde trop faible pour effectuer cette action") ;
		} else {
			this.solde = newSolde ;
		}	
	}
	
}
