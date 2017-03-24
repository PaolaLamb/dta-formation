package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizza-db")
	private EntityManager em;

	public List<Pizza> findAll() {
		TypedQuery<Pizza> pizzas = em.createNamedQuery("Pizza.findAll", Pizza.class);
		return pizzas.getResultList();
	}

	public void saveNew(Pizza pizza) {
		em.persist(pizza);

	}

	public void update(String codePizza, Pizza newPizza) {

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

	public void delete(String codePizza) {

		Pizza pizza = (Pizza) em.createNamedQuery("Pizza.findByCode").setParameter("codePizza", codePizza)
				.getSingleResult();
		em.remove(pizza);
	}

	public Optional<Pizza> obtainOne(String codePizza) {
		for (Pizza pizza : findAll()) {
			if (codePizza.equals(pizza.getCode())) {
				return Optional.of(pizza);
			}
		}

		return Optional.empty();
	}

}
