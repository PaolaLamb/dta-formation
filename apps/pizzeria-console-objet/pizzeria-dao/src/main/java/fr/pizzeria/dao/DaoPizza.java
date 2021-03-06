package fr.pizzeria.dao;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 * @param <S>
 * @param <C>
 */
public interface DaoPizza<S, C> {
	/**
	 * @return la liste des pizzas
	 */
	List<S> findAll();

	/**
	 * @param plat
	 */
	void saveNew(S plat);

	/**
	 * @param codePlat
	 * @param plat
	 */
	void update(C codePlat, S plat);

	/**
	 * @param codePlat
	 */
	void delete(C codePlat);

	default Optional<Pizza> obtainOne(String codePizza) {
		return Optional.empty();
	}
}
