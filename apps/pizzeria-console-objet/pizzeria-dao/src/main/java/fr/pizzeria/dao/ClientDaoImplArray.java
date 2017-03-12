package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Client;

/**
 * @author PaolaLamb
 * Implémentation de l'interface dao client
 */
public class ClientDaoImplArray implements DaoClient{
	private List<Client> clientList = new ArrayList<>() ;
	
	

	/**
	 * Constructeur sans paramètre, création de base
	 */
	public ClientDaoImplArray() {
		this.clientList.add(new Client(1, "Jacques", "Pierre", 100.00)) ;
		this.clientList.add(new Client(2, "Mars", "Roger", 0.00)) ;
		this.clientList.add(new Client(3, "Clark", "Sydney", 55.00)) ;
		this.clientList.add(new Client(4, "Yorv", "Viktor", 150.00)) ;
	}



	public ClientDaoImplArray(List<Client> clientList) {
		super();
		this.clientList = clientList;
	}



	@Override
	public List<Client> findAll() {
		return clientList ;		
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
		return clientList.size() ;
	}
	

}
