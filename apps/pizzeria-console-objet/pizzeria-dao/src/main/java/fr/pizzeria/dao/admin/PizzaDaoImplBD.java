package fr.pizzeria.dao.admin;

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
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class PizzaDaoImplBD implements DaoGestionPizza<Pizza, String> {
	ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

	Connection co;

	/**
	 * @return une connexion à la base de données
	 */
	public Connection initializeConnection() {

		try {
			Class.forName(bundle.getString("driver"));
			co = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("password"));
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
				String nom = resultats.getString("libelle");
				String code = resultats.getString("reference");
				double prix = resultats.getDouble("prix");
				String categorie = resultats.getString("categorie");
				Pizza pizza = new Pizza(code, nom, prix);
				pizza.setCategoriePizza(CategoriePizza.valueOf(categorie));
				listPizzas.add(pizza);
			}
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "findAll exception", e);
		}
		return listPizzas;
	}

	@Override
	public void saveNew(Pizza pizza) {
		try (Connection connection = initializeConnection();
				PreparedStatement prepStatement = connection.prepareStatement(
						"INSERT INTO pizza (id, libelle, reference, prix,  categorie) VALUES (null, ?, ?, ?, ?)");) {
			prepStatement.setString(1, pizza.getNom());
			prepStatement.setString(2, pizza.getCode());
			prepStatement.setDouble(3, pizza.getPrix());
			prepStatement.setString(4, pizza.getCategoriePizza().name());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SaveException(e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza)  {
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
	public void delete(String codePizza)  {

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
