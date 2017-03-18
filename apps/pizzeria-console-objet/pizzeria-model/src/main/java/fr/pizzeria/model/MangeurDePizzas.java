package fr.pizzeria.model;

public abstract class MangeurDePizzas {
		protected int id;
		protected String nom;
		protected String prenom;
		protected final double MONTANT_MAX = 5000.00 ;
		protected final double MONTANT_MIN = 0.00 ;


		/**
		 * @param id
		 * @param nom
		 * @param prenom
		 * @param solde
		 */
		public MangeurDePizzas(int id, String nom, String prenom) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			
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
		

}

