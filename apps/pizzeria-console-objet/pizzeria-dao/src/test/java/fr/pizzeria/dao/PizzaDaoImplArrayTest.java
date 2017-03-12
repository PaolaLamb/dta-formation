package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplArrayTest {

	private PizzaDaoImplArray pizzaDao;

	@Before
	public void setUp() {
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza(3, "FRO", "La 4 Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(5, "SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzaList.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));

		pizzaDao = new PizzaDaoImplArray(pizzaList);
	}

	@Test
	public void test_find_all() { // ou public void testFindAll()
		List<Pizza> pizzas = pizzaDao.findAll();
		assertEquals(8, pizzas.size());
	}

	@Test(expected = StockageException.class)
	public void test_save_new_invalide_data() throws DaoException {
		Pizza pizza = new Pizza(0, null, null, null, null);
		pizzaDao.saveNew(pizza);
		List<Pizza> all = pizzaDao.findAll();
		assertEquals(8, all.size());
		assertThat(all.size(), is(8));

	}

	@Test
	public void test_save_new_valid_data() throws DaoException {
		Pizza pizza = new Pizza(0, "TES", "test", 12.00, CategoriePizza.VIANDE);
		pizzaDao.saveNew(pizza);
		List<Pizza> all = pizzaDao.findAll();
		assertEquals(9, all.size());

	}

}
