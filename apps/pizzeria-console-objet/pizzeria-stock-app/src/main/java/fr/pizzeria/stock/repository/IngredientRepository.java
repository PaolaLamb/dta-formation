package fr.pizzeria.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.stock.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
