package fr.pizzeria.admin.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public DaoPizza<Pizza, String> getDao() {
		return new PizzaDaoImplArray();
	}

}
