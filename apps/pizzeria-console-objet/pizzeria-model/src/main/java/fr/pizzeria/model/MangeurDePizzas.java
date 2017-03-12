package fr.pizzeria.model;

import fr.pizzeria.exception.CrediterException;
import fr.pizzeria.exception.DebiterException;

public abstract class MangeurDePizzas {
		protected int id;
		protected String nom;
		protected String prenom;
		protected Double solde;
		protected final double MONTANT_MAX = 5000.00 ;
		protected final double MONTANT_MIN = 0.00 ;


		/**
		 * @param id
		 * @param nom
		 * @param prenom
		 * @param solde
		 */
		public MangeurDePizzas(int id, String nom, String prenom, Double solde) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.solde = solde;
		}
		
		
		public int getId() {
			return id;
		}

		public String getNom() {
			return nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public Double getSolde() {
			return solde;
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

