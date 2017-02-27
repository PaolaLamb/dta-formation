package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements Dao<Pizza, String, CategoriePizza> {

	@Override
	public List<Pizza> findAll() {
		try (Stream<Path> files = Files.list(Paths.get("data"))) {

			return files.map(chemin -> {

				Pizza p = new Pizza();

				p.setCode(chemin.getFileName().toFile().getName().replaceFirst(".txt", ""));
				try {
					String[] contenuFichier = Files.lines(chemin).findFirst().get().split(";");
					p.setNom(contenuFichier[0]);
					p.setPrix(Double.valueOf(contenuFichier[1]));
				} catch (IOException e) {
					// throw new DaoException(e);
					System.out.println("marchepas");
				}

				return p;
			}).collect((Collectors.toList()));

		} catch (IOException e) {
			// throw new DaoException(e);
			System.out.println("marchepas2");

		}
	}

	@Override
	public void saveNew(Pizza plat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String codePlat, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<CategoriePizza, List<Pizza>> listByCat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMostExp() {
		// TODO Auto-generated method stub

	}

	public void createFiles() {
		List<Pizza> list = findAll();
		list.stream().forEach(pizza -> {
			try {
				Files.write(Paths.get("data" + pizza.getCode() + ".txt"), pizza.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
