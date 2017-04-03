package fr.pizzeria.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.stock.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient/new")
public class NouvelIngredientController {

	@Autowired
	private IngredientRepository ingreRep;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Ingredient ingredient = new Ingredient();
		model.addAttribute("ingredient", ingredient);
		return "nouvelIngredient";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("ingredient") Ingredient ingredient) {
		ingreRep.save(ingredient);
		return "redirect:/mvc/ingredient";

	}

}
