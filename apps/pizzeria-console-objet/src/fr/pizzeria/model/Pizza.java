package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	
	public Integer id ;
	@ToString
	public String code ;
	@ToString
	public String nom ;
	@ToString
	public Double prix ;
	@ToString
	public CategoriePizza categoriePizza ;
	public static int nbPizzas ;
	
	public Pizza() {
	}

	public Pizza(Integer id, String code, String nom, Double prix, CategoriePizza categoriePizza) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza ;
		nbPizzas++ ;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder() ;
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {
				ToString annotationTrouve = champ.getAnnotation(ToString.class);
				if (annotationTrouve != null) {

					sb.append(champ.get(this).toString() + " ");

				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return sb.toString() ;
		
		// return categoriePizza.getCategorie() ;
	}

}

