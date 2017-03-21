package fr.pizzeria.dao.admin;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.MangeurDePizzas;

/**
 * @author PaolaLamb Implémentation de l'interface dao client
 */
public class ClientDaoImplJPA implements DaoGestionClient {
	private List<MangeurDePizzas> clientList = new ArrayList<>();
	private List<Livreur> deliverList = new ArrayList<>();

	/**
	 * Constructeur sans paramètre, création de base
	 */
	public ClientDaoImplJPA() {
		this.clientList.add(new Client(1, "Jacques", "Pierre", 100.00));
		this.clientList.add(new Client(2, "Mars", "Roger", 0.00));
		this.clientList.add(new Client(3, "Clark", "Sydney", 55.00));
		this.clientList.add(new Livreur(4, "Yorv", "Viktor", 150.00));

		this.deliverList.add(new Livreur(1, "Yorv", "Viktor", 150.00));
	}

	/**
	 * @param clientList
	 */
	public ClientDaoImplJPA(List<MangeurDePizzas> clientList) {
		super();
		this.clientList = clientList;
	}

	@Override
	public List<MangeurDePizzas> findAll() {
		return clientList;
	}

	@Override
	public List<Livreur> findAllLivreur() {
		return deliverList;
	}

	@Override
	public void ajouterNouveauClient(Client personne, String livreur) {
		if ("oui".equals(livreur)) {
			deliverList.add(
					new Livreur(deliverList.size() + 1, personne.getNom(), personne.getPrenom(), personne.getSolde()));
			clientList.add(
					new Livreur(deliverList.size() + 1, personne.getNom(), personne.getPrenom(), personne.getSolde()));
		} else {
			clientList.add(personne);
		}
	}

	@Override
	public void crediterCompteClient(int choix, double montant) {
		clientList.get(choix).crediterCompte(montant);
	}

	@Override
	public void debiterCompteClient(int choix, double montant) {
		clientList.get(choix).debiterCompte(montant);
	}

	@Override
	public int nbClient() {
		return clientList.size();
	}

}
