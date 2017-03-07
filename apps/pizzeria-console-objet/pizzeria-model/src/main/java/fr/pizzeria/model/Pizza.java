package fr.pizzeria.model;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza {
	private Integer id;
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private Double prix;
	private CategoriePizza categoriePizza;
	private static Integer nbPizzas = 0;

	public Pizza() {
	}

	public Pizza(Integer id, String code, String nom, Double prix, CategoriePizza categoriePizza) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		nbPizzas++;
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
		return nbPizzas;
	}

	public static void setNbPizza(Integer nbPizza) {
		Pizza.nbPizzas = nbPizza;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
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

		return sb.toString();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(code).toHashCode();

	}

	@Override
	public boolean equals(Object objet) {
		if (objet == null) {
			return false;
		}
		if (objet == this) {
			return true;
		}
		if (objet.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) objet;
		return new EqualsBuilder().append(id, rhs.getId()).append(code, rhs.getCode()).isEquals();
	}

}