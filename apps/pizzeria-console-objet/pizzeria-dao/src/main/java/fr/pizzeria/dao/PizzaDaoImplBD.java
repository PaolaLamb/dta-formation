package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplBD implements Dao<Pizza, String, CategoriePizza> {
	private String url;
	private String user;
	private String password;
	ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	Connection co;

	public Connection initializeConnection() {

		try {
			Class.forName(bundle.getString("driver"));
			co = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Connexion exception", e);

		}
		return co;
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> listPizzas = new ArrayList<>();
		try (Connection connection = initializeConnection();
				Statement statement = connection.createStatement();
				ResultSet resultats = statement.executeQuery("SELECT * FROM pizza");) {
			while (resultats.next()) {
				Integer id = resultats.getInt("id");
				String nom = resultats.getString("libelle");
				String code = resultats.getString("reference");
				double prix = resultats.getDouble("prix");
				String categorie = resultats.getString("categorie");
				Pizza pizza = new Pizza(code, nom, prix) ;
				pizza.setCategoriePizza(CategoriePizza.valueOf(categorie))
				listPizzas.add(pizza) ;
			}
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "findAll exception", e);
		}
		return listPizzas;
	}

	@Override
	public void saveNew(Pizza pizza) throws SavePizzaException {
		try (Connection connection = initializeConnection();
				PreparedStatement prepStatement = connection.prepareStatement(
						"INSERT INTO pizza (libelle, reference, prix,  categorie) VALUES (null, ?, ?, ?, ?)");) {
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, pizza.getCategoriePizza().name());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SavePizzaException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdatePizzaException {
		try (Connection connection = initializeConnection();
				PreparedStatement prepStatement = connection.prepareStatement(
						"UPDATE pizza SET libelle=?, reference=?, prix=?, categorie=? WHERE reference=?");) {
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, pizza.getCategoriePizza().name());
			prepStatement.setString(5, codePizza);
			prepStatement.executeUpdate();
			prepStatement.close();
		} catch (SQLException e) {
			throw new UpdatePizzaException(e);
		}
	}

	@Override
	public void delete(String codePizza) throws DeletePizzaException {

		try (Connection connection = initializeConnection();
				PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM pizza WHERE reference=?");) {
			prepStatement.setString(1, codePizza);
			prepStatement.executeUpdate();
			prepStatement.close();
		} catch (SQLException e) {
			throw new DeletePizzaException(e);
		}

	}
}
