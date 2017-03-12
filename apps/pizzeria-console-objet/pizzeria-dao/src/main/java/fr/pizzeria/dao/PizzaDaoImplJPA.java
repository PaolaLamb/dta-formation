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
		List<Pizza> pizzaList = new ArrayList<>() ;
		Query pizzas = em.createNamedQuery("Pizza.findAll") ;
		for(Object obj : pizzas.getResultList()) {
			pizzaList.add((Pizza) obj) ;
		}
		Pizza.setNbPizza(Pizza.getNbPizza()+1);
		return pizzaList ;
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
		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza).getSingleResult();
		
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
		} catch (RollbackException e) {
			et.rollback();
			throw new UpdatePizzaException(e);
		}
	}

	@Override
	public void delete(String codePizza) {
		List<Pizza> listPizzas = new ArrayList<>();
		Query query = em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza);
		for (Object obj : query.getResultList()) {
			listPizzas.add((Pizza) obj);
		}
		Pizza p = listPizzas.get(0);

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(p);
			et.commit();
		} catch (RollbackException e) {
			et.rollback();
			throw new SavePizzaException(e);
		}
	}
}
