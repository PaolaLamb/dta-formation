package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.MangeurDePizzas;

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
	List<MangeurDePizzas> findAll() ;
	
	
	/**
	 * @return la liste des livreurs
	 */
	List<Livreur> findAllLivreur() ;
	
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
