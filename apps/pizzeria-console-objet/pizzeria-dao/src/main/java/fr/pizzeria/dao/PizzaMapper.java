package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	@Override
	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pizza p = new Pizza();

		p.setNom(rs.getString("libelle"));
		p.setCode(rs.getString("reference"));
		p.setPrix(Double.parseDouble(rs.getString("prix")));
		p.setCategoriePizza(CategoriePizza.valueOf(rs.getString("categorie").toUpperCase()));

		return p;

	}

}