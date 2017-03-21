package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MangeurDePizzas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "nom", length = 20, nullable = false, unique = false)
	protected String nom;

	@Column(name = "prenom", length = 20, nullable = false, unique = false)
	protected String prenom;
	protected final double MONTANT_MAX = 5000.00;
	protected final double MONTANT_MIN = 0.00;

	public MangeurDePizzas() {
		super();
	}

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

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

}
