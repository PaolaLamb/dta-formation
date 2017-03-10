package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJPA implements Dao<Pizza, String> {
	private EntityManagerFactory entityMF;
	private static final String PERSISTENCE_UNIT = "pizzeria-console";
	EntityManager em;

	public PizzaDaoImplJPA() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.entityMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		this.em = entityMF.createEntityManager();

	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> listPizzas = new ArrayList<>();
		Query query = em.createQuery("SELECT p FROM Pizza p");
		for (Object obj : query.getResultList()) {
			listPizzas.add((Pizza) obj);

		}
		Pizza.setNbPizza(listPizzas.size());
		return listPizzas;
	}

	@Override
	public void saveNew(Pizza pizza) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(pizza);
			et.commit();
		} catch (Exception up) {
			et.rollback();
			throw up;
		}
	}

	@Override
	public void update(String codePlat, Pizza plat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String codePlat) {
		// TODO Auto-generated method stub

	}
}
