package fr.pizzeria.admin.tool;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.model.Pizza;

public interface PizzaTool {
	DaoPizza<Pizza, String> DAO_PIZZA = new PizzaDaoImplArray();

}
