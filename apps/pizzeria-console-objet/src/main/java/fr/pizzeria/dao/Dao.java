package fr.pizzeria.dao;

import java.util.List;
import java.util.Map;

public interface Dao<S, C, CP> {
	List<S> findAll();

	void saveNew(S plat);

	void update(C codePlat, S pizza);

	void delete(C codePizza);

	Map<CP, List<S>> listByCat();

	void showMostExp();

	void createFiles();

}
