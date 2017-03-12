package fr.pizzeria.model;

/**
 * @author PaolaLamb
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String pizzaCategory;
	private String libelle;
	
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

}