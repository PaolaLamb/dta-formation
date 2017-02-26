package fr.pizzeria.dao;

import java.util.List;
import fr.pizzeria.model.*;

public interface IPizzaDao<S, C> {
	List<S> findAll() ;
	void saveNew(S plat) ;
	void update(C codePlat, S pizza) ;
	void delete(C codePizza) ;
	
}
