package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Client;

/**
 * @author PaolaLamb
 * Interface dao Client
 */
public interface DaoClient {
	/**
	 * @return le nombre de client
	 */ 
	int nbClient() ;
	
	/**
	 * @return la liste des clients
	 */
	List<Client> findAll() ;
	
	/**
	 * @param choix
	 * @param montant
	 * crédite le compte du client
	 */
	void crediterCompteClient(int choix, double montant) ;
	
	/**
	 * @param choix
	 * @param montant
	 * débite le compte du client
	 */
	void debiterCompteClient(int choix, double montant) ;
}
