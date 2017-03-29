package fr.pizzeria.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaMapper;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoImplJdbcTemplate implements DaoPizza<Pizza, String> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoImplJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Pizza> findAll() {
		String sql = "SELECT * FROM pizza";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void saveNew(Pizza p) {
		String sql = "INSERT INTO pizza (libelle, reference, prix, categorie) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, p.getNom(), p.getCode(), p.getPrix(), p.getCategoriePizza().name());
	}

	@Override
	public void update(String codePizza, Pizza p) {
		String sql = "UPDATE pizza SET libelle=?, reference=?, prix =?, categorie=? WHERE reference=? ";
		this.jdbcTemplate.update(sql, p.getNom(), p.getCode(), p.getPrix(), p.getCategoriePizza().name(), codePizza);
	}

	@Override
	public void delete(String codePizza) {
		String sql = "DELETE FROM pizza WHERE reference=?";
		this.jdbcTemplate.update(sql, codePizza);

	}

	@Override
	public Optional<Pizza> obtainOne(String codePizza) {
		for (Pizza pizza : findAll()) {
			if (codePizza.equals(pizza.getCode())) {
				return Optional.of(pizza);
			}
		}

		return Optional.empty();
	}

}
