package fr.pizzeria.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */
public class PizzaDaoImplFiles implements DaoPizza<Pizza, String> {



	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzaList = new ArrayList<>();
		try {
			Files.list(Paths.get("data")).forEach(path -> pizzaList.add(extractPizzasFromFile(path)));
		} catch (IOException e) {
			throw new StockageException(e);
		}
		return pizzaList;
	}

	private Pizza extractPizzasFromFile(Path path) {
		try {
			String[] pizzaIteration = Files.readAllLines(path).get(0).split(";");
			return new Pizza(pizzaIteration[0], pizzaIteration[1], Double.parseDouble(pizzaIteration[2]),
					CategoriePizza.valueOf(pizzaIteration[3].toUpperCase()));
		} catch (IOException e) {
			throw new StockageException(e);
		}
	}

	@Override
	public void saveNew(Pizza newPizza) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", newPizza.getCode() + ".txt"))) {
			writer.write(newPizza.getCode() + ";" + newPizza.getNom() + ";" + newPizza.getPrix() + ";" + newPizza.getCategoriePizza().toString());
		} catch (IOException e) {
			throw new SavePizzaException(e);
		}

	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		delete(codePizza);
		saveNew(newPizza);
	}

	@Override
	public void delete(String codePizza) {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeletePizzaException(e);
		}

	}




}
