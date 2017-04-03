package fr.pizzeria.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	
	Ingredient findIngredientById(Integer id) ;
	
	int findIdByNom(String reference) ;
}
