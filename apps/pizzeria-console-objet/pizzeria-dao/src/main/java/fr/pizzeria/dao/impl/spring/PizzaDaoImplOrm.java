package fr.pizzeria.dao.impl.spring;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoImplOrm implements DaoPizza<Pizza, String> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Pizza> findAll() {
		return em.createNamedQuery("Pizza.findAll", Pizza.class).getResultList();
	}

	@Override
	@Transactional
	public void saveNew(Pizza pizza) throws SaveException {
		em.persist(pizza);
	}

	@Override
	@Transactional
	public void update(String codePizza, Pizza newPizza) throws UpdateException {

		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza)
				.getSingleResult();

		if (pizza != null) {

			pizza.setCode(newPizza.getCode());
			pizza.setNom(newPizza.getNom());
			pizza.setPrix(newPizza.getPrix());
			pizza.setCategoriePizza(newPizza.getCategoriePizza());

		}

		em.merge(pizza);
	}

	@Override
	@Transactional
	public void delete(String codePizza) throws DeletePizzaException {

		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza)
				.getSingleResult();
		em.remove(pizza);
	}

	@Override

	public Optional<Pizza> obtainOne(String codePizza) {
		for (Pizza pizza : findAll()) {
			if (codePizza.equals(pizza.getCode())) {
				return Optional.of(pizza);
			}
		}

		return Optional.empty();
	}
}
