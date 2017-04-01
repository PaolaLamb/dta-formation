package fr.pizzeria.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.stock.Ingredient;
import fr.pizzeria.stock.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient/id")
public class SupprimerIngredientController {

	@Autowired
	private IngredientRepository ingreRep;


	@RequestMapping(method = RequestMethod.GET)
	public String submitForm(@ModelAttribute("ingredient") Ingredient newIngredient, @PathVariable("id") Integer id) {
		Ingredient oldIngredient = ingreRep.findIngredientById(id) ;
		newIngredient.setId(oldIngredient.getId());
		ingreRep.delete(newIngredient);
		
		return "redirect:/mvc/ingredient";

	}


}
