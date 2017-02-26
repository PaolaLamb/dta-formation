package fr.pizzeria.model;

public class Pizza {
	private Integer id ;
	private String code ;
	private String nom ;
	private Double prix ;
	private static Integer nbPizza = 0 ;
	
	
	public Pizza() {
	}

	public Pizza(Integer id, String code, String nom, Double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizza++ ;
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
	
	
		

}
