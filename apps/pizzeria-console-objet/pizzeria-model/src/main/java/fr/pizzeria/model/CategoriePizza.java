package fr.pizzeria.model;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author PaolaLamb
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String pizzaCategory;
	private String libelle;
	private String niceName;

	private CategoriePizza(String categoriePizza) {
		this.pizzaCategory = categoriePizza;
	}

	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return pizzaCategory;
	}

	/**
	 * @param value
	 * @return la catégorie de la pizza
	 */
	public static CategoriePizza getEnum(String value) {
		for (CategoriePizza v : values())
			if (v.getLibelle().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();

	}

	/**
	 * @return a good looking name
	 */
	public String getNiceName() {
		return WordUtils.capitalize(name().toLowerCase().replace("_", " "));
	}

}