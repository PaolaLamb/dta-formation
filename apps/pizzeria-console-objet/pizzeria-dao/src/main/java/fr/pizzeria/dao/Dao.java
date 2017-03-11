package fr.pizzeria.dao;

import java.util.List;

public interface Dao<S, C> {
	List<S> findAll();

	void saveNew(S plat);

	void update(C codePlat, S plat);

	void delete(C codePlat);

}
