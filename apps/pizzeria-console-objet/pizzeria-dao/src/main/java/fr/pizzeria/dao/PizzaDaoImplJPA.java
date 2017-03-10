package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
		} catch (RollbackException e) {
			et.rollback();
			throw new SavePizzaException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		List<Pizza> listPizzas = new ArrayList<>();
		Query query = em.createQuery("SELECT p FROM Pizza p	WHERE p.code=:codePizza").setParameter("codePizza",
				codePizza);
		for (Object obj : query.getResultList()) {
			listPizzas.add((Pizza) obj);
		}
		Pizza p = listPizzas.get(0);

		if (p != null) {

			listPizzas.get(0).setCode(newPizza.getCode());
			listPizzas.get(0).setNom(newPizza.getNom());
			listPizzas.get(0).setPrix(newPizza.getPrix());
			listPizzas.get(0).setCategoriePizza(newPizza.getCategoriePizza());

		}

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(listPizzas.get(0));
			et.commit();
		} catch (RollbackException e) {
			et.rollback();
			throw new UpdatePizzaException(e);
		}
	}

	@Override
	public void delete(String codePizza) {
		// TODO Auto-generated method stub

	}
}
