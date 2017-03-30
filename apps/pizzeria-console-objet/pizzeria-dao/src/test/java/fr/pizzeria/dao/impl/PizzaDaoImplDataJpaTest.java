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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoImplDataJpaConfig.class)
public class PizzaDaoImplDataJpaTest {

	@Autowired
	private DaoPizza<Pizza, String> pizzaDao;

	@Test
	public void findAllTest() {
		pizzaDao.saveNew(new Pizza(0, "TEST", "test", 12.50, CategoriePizza.VIANDE));
		List<Pizza> pizzaList = pizzaDao.findAll();

		assertTrue(pizzaList.size() > 0);

		Pizza newPizza = new Pizza("TESTNEW", "testnew", 12.0, CategoriePizza.SANS_VIANDE);
		pizzaDao.update("TEST", newPizza);

		pizzaList = pizzaDao.findAll();
		assertTrue(pizzaList.stream().anyMatch(p -> "TESTNEW".equals(p.getCode())));
		assertFalse(pizzaList.stream().anyMatch(p -> "TEST".equals(p.getCode())));

		pizzaDao.delete("TESTNEW");
		pizzaList = pizzaDao.findAll();
		assertFalse(pizzaList.contains(newPizza));
	}
}
