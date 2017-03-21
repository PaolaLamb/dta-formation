package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.Client;

public class ConsoleClientDaoImplJPA implements DaoConsoleClient {
	private EntityManagerFactory entityMF;
	private static final String PERSISTENCE_UNIT = "pu-pizzeria-console";
	EntityManager em;

	/**
	 * Constructeur sans paramètre
	 */
	public ConsoleClientDaoImplJPA() {
		this.entityMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Override
	public void enregistrementCoordonnees(Client client) {
		this.em = entityMF.createEntityManager();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(client);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SaveException(e);
		}
		em.close();

	}

	@Override
	public void connexionClient() {

	}

	@Override
	public void commanderPizzas() {

	}

	@Override
	public void listerCommandes() {

	}

}
