package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	private PizzaDaoImpl pizzaDao;

	@Before
	public void setUp() {
		pizzaDao = new PizzaDaoImpl();
	}

	@Test
	public void test_find_all() { // ou public void testFindAll()
		List<Pizza> pizzas = pizzaDao.findAll();
		assertEquals(0, pizzas.size());
	}

	@Test(expected = DaoException.class)
	public void test_save_new_invalide_data() throws DaoException {
		Pizza pizza = new Pizza(0, null, null, null, null);
		pizzaDao.saveNew(pizza);
		List<Pizza> all = pizzaDao.findAll();
		assertEquals(8, all.size());
		assertThat(all.size(), is(8));

	}

	@Test(expected = DaoException.class)
	public void test_save_new_valid_data() throws DaoException {
		Pizza pizza = new Pizza(0, "TES", "test", 12.00, CategoriePizza.VIANDE);
		pizzaDao.saveNew(pizza);
		List<Pizza> all = pizzaDao.findAll();
		assertEquals(9, all.size());

	}

}
