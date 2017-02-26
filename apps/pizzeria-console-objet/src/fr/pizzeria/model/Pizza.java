package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	private Integer id ;
	@ToString
	private String code ;
	@ToString
	private String nom ;
	@ToString
	private Double prix ;
	public CategoriePizza categoriePizza ;
	private static Integer nbPizza = 0 ;

	
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public static Integer getNbPizza() {
		return nbPizza;
	}
	public static void setNbPizza(Integer nbPizza) {
		Pizza.nbPizza = nbPizza;
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

