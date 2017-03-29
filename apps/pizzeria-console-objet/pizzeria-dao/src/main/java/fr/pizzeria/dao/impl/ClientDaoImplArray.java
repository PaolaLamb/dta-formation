package fr.pizzeria.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

/**
 * @author PaolaLamb Implémentation de l'interface dao client
 */
public class ClientDaoImplArray implements DaoClient {

	private List<Client> clientList = new ArrayList<>();
	private List<Livreur> deliverList = new ArrayList<>();

	/**
	 * Constructeur sans paramètre, création de base
	 */
	public ClientDaoImplArray() {
		this.clientList.add(new Client(1, "Jacques", "Pierre", 100.00));
		this.clientList.add(new Client(2, "Mars", "Roger", 0.00));
		this.clientList.add(new Client(3, "Clark", "Sydney", 55.00));
		this.clientList.add(new Client(4, "Yorv", "Viktor", 150.00));

		this.deliverList.add(new Livreur(1, "Yorv", "Viktor"));

	}

	/**
	 * @param clientList
	 */
	public ClientDaoImplArray(List<Client> clientList) {
		super();
		this.clientList = clientList;
	}

	@Override

	public List<Client> findAll() {
		return clientList;
	}

	@Override
	public List<Livreur> findAllLivreur() {
		return deliverList;
	}

	@Override
	public void ajouterNouveauClient(Client personne) {
		clientList.add(personne);

	}

	@Override
	public void ajouterNouveauLivreur(Livreur livreur) {
		deliverList.add(livreur);
	}

	public void crediterCompteClient(int choix, double montant) {
		clientList.get(choix).crediterCompte(montant);
	}

	@Override
	public void debiterCompteClient(int choix, double montant) {
		clientList.get(choix).debiterCompte(montant);
	}

	@Override
	public void delete(Client client) {
		clientList.remove(client.getId());
	}

	public void delete(Livreur livreur) {
		clientList.remove(livreur.getId());
	}

	public int nbClient() {
		return clientList.size();
	}

	public int nbLivreur() {
		return deliverList.size();
	}

}
