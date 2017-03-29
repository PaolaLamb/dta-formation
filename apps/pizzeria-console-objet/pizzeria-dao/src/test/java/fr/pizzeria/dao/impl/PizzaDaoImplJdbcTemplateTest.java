package fr.pizzeria.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.DaoConfigJdbcTemplate;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfigJdbcTemplate.class)
public class PizzaDaoImplJdbcTemplateTest {

	@Autowired
	private DaoPizza<Pizza, String> pizzaDao;

	@Test
	public void test_findAll_saveNew() {
		pizzaDao.saveNew(new Pizza(0, "TEST", "test", 12.50, CategoriePizza.VIANDE));
		List<Pizza> pizzaList = pizzaDao.findAll();
		assertTrue(pizzaList.size() > 0);
		assertTrue(pizzaList.stream().anyMatch(p -> "TEST".equals(p.getCode())));

		Pizza pizza = new Pizza(1, "TESTNEW", "testnew", 12.0, CategoriePizza.SANS_VIANDE);
		pizzaDao.update("TEST", pizza);
		pizzaList = pizzaDao.findAll();
		assertTrue(pizzaList.stream().anyMatch(p -> "TESTNEW".equals(p.getCode())));

		pizzaDao.delete("TESTNEW");
		pizzaList = pizzaDao.findAll();
		assertFalse(pizzaList.contains(pizza));
	}

}
