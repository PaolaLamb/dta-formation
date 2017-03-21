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
public class PizzaDaoImplJPAGenerics<T> implements DaoGestionPizza<T, String> {
	private EntityManagerFactory entityMF;
	private static final String PERSISTENCE_UNIT = "pu-pizzeria-console";
	EntityManager em;

	/**
	 * Constructeur sans paramètre
	 */
	public PizzaDaoImplJPAGenerics() {
		this.entityMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Override
	public List<T> findAll() {
		this.em = entityMF.createEntityManager();

		TypedQuery<T> pizzas = em.createNamedQuery("Pizza.findAll", T.class);
		List<T> pizzaList = pizzas.getResultList();
		Pizza.setNbPizza(Pizza.getNbPizza() + 1);

		em.close();
		return pizzaList;
	}

	@Override
	public void saveNew(T newT) {
		this.em = entityMF.createEntityManager();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(newT);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SaveException(e);
		}
		em.close();

	}

	@Override
	public void update(String codeT, T newT) {
		this.em = entityMF.createEntityManager();

		TypedQuery<T> pizza = em.createNamedQuery("Pizza.findByCode", T.class).setParameter("codePizza", codeT)
				.getSingleResult();

		if (pizza != null) {

			pizza.setCode(newT.getCode());
			pizza.setNom(newT.getNom());
			pizza.setPrix(newT.getPrix());
			pizza.setCategoriePizza(newT.getCategoriePizza());

		}

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(pizza);
			et.commit();
		} catch (RollbackException e) {
			et.rollback();
			throw new UpdatePizzaException(e);
		}
		em.close();

	}

	@Override
	public void delete(String codeT) {
		this.em = entityMF.createEntityManager();

		TypedQuery<T> oldT = em.createNamedQuery("Pizza.findByCode", T.class).setParameter("codePizza", codeT)
				.getSingleResult();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(oldT);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SaveException(e);
		}
		em.close();

	}
}
