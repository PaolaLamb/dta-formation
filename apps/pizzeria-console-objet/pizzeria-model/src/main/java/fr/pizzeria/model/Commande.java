package fr.pizzeria.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "numero_commande", length = 20, nullable = false, unique = true)
	private int numeroCommande;

	@Column(name = "statut", nullable = false, unique = false)
	private int statut;

	@Column(name = "date_commande", nullable = false, unique = false)
	private LocalDate dateCommande;

	@Column(name = "livreur_ID", length = 20, nullable = false, unique = true, insertable = false, updatable = false)
	private int livreurID;

	@Column(name = "client_ID", length = 20, nullable = false, unique = true, insertable = false, updatable = false)
	private int clientID;

	@ManyToOne
	@JoinColumn(name = "livreur_ID")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_ID")
	private Client client;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Set<Pizza> pizzas;
}
