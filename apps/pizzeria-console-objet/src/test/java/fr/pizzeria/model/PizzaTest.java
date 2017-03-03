package fr.pizzeria.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PizzaTest {
	@Test
	public void testHashCode() {
		Set<Pizza> sets = new HashSet<>();
		Pizza p1 = new Pizza(0, "A", "B", 12.0, CategoriePizza.VIANDE);
		Pizza p2 = new Pizza(0, "A", "C", 14.0, CategoriePizza.VIANDE);

		sets.add(p1);

		assertThat(sets.contains(p1), is(true));
		assertThat(sets.contains(p2), is(true));

	}

	@Test
	public void testEquals() {
		Pizza p1 = new Pizza(0, "A", "B", 12.0, CategoriePizza.VIANDE);
		Pizza p2 = new Pizza(0, "A", "C", 14.0, CategoriePizza.VIANDE);

		assertThat(p1, is(p2));
	}

}
