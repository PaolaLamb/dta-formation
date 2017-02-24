package fr.pizzeria.dao;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface IDao<S, C> {
	S[] findAll() ;
	void saveNew(S plat) throws StockageException ;
	void update(C codePlat, S plat) throws StockageException;
	void delete(C codePlat) throws StockageException;
	
}
