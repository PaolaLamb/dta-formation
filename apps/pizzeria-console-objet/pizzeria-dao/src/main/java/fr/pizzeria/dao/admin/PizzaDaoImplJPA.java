package fr.pizzeria.dao.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


import javax.persistence.RollbackException;

import javax.persistence.TypedQuery;

import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class PizzaDaoImplJPA implements DaoGestionPizza<Pizza, String> {
	private EntityManagerFactory entityMF;
	private static final String PERSISTENCE_UNIT = "pu-pizzeria-console";
	EntityManager em;

	/**
	 * Constructeur sans paramètre
	 */
	public PizzaDaoImplJPA() {
		this.entityMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Override
	public List<Pizza> findAll() {

		this.em = entityMF.createEntityManager();
		TypedQuery<Pizza> pizzas = em.createNamedQuery("Pizza.findAll", Pizza.class) ;
		em.close();
		return pizzas.getResultList();
	}

	@Override
	public void saveNew(Pizza pizza) {

		this.em = entityMF.createEntityManager();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(pizza);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SaveException(e);
		}
		em.close();
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {

		this.em = entityMF.createEntityManager();

		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza)
				.getSingleResult();

		if (pizza != null) {

			pizza.setCode(newPizza.getCode());
			pizza.setNom(newPizza.getNom());
			pizza.setPrix(newPizza.getPrix());
			pizza.setCategoriePizza(newPizza.getCategoriePizza());

		}

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(pizza);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new UpdatePizzaException(e);
		}
		em.close();
	}

	@Override
	public void delete(String codePizza) {
		this.em = entityMF.createEntityManager();

		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza)
				.getSingleResult();


		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(pizza);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SaveException(e);
		}
		em.close();

	}
}
