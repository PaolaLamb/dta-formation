package fr.pizzeria.model;

public class Pizza {
	public int id ;
	public String code ;
	public String nom ;
	public double prix ;
	public static int nbPizzas ;
	
	public Pizza() {
		
	}

	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++ ;
	}
		

}
