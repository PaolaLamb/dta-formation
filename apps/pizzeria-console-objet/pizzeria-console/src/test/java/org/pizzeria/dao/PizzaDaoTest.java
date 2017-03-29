package org.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaAppStringConfig;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppStringConfig.class)
public class PizzaDaoTest {

	@Autowired
	private DaoPizza<Pizza, String> pizzaDao;

	@Test
	public void testFindAll() {
		List<Pizza> pizzaList = pizzaDao.findAll();
		assertTrue(pizzaList.size() > 0);
	}

}
