package fr.pizzeria.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoImplDataJpaConfig;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repository.PerfRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoImplDataJpaConfig.class)
public class PizzaDaoImplDataJpaTest {

	@Autowired
	private DaoPizza<Pizza, String> pizzaDao;

	@Autowired
	private PerfRepository perfRep;

	@Test
	public void findAllTest() {
		pizzaDao.saveNew(new Pizza("", "test", 12.50, CategoriePizza.VIANDE)); // 1
		pizzaDao.saveNew(new Pizza("TEST2", "test2", 14.50, CategoriePizza.POISSON)); // 2
		List<Pizza> pizzaList = pizzaDao.findAll(); // 3
		assertTrue(pizzaList.size() > 0);

		Pizza newPizza = new Pizza("TESTNEW", "testnew", 12.0, CategoriePizza.SANS_VIANDE); // 4
		pizzaDao.update("TES", newPizza);

		pizzaList = pizzaDao.findAll(); // 5
		assertTrue(pizzaList.stream().anyMatch(p -> "TESTNEW".equals(p.getCode())));
		assertFalse(pizzaList.stream().anyMatch(p -> "TEST".equals(p.getCode())));

		pizzaDao.delete("TESTNEW"); // 6
		pizzaList = pizzaDao.findAll(); // 7
		assertFalse(pizzaList.contains(newPizza));

		assertTrue(perfRep.findAll().size() == 7);

	}
}
