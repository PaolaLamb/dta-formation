package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Client;
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
	List<Client> findAll() ;
	
	
	/**
	 * @return la liste des livreurs
	 */
	List<Livreur> findAllLivreur() ;
	
	

	/**
	 * @param personne
	 * ajoute un nouveau client
	 */
	void ajouterNouveauClient(Client personne) ;
	
	
	void ajouterNouveauLivreur(Livreur livreur);
	
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
	
	/**
	 * @param client
	 * Supprime le client
	 */
	void delete(Client client) ;

	
}
