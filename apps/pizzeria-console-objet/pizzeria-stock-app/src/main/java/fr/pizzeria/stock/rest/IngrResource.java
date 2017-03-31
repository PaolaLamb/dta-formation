package fr.pizzeria.stock.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.stock.Ingredient;
import fr.pizzeria.stock.repository.IngredientRepository;

@RestController
@RequestMapping("/rest/ingredient")
public class IngrResource {

	@Autowired
	private IngredientRepository ingreRep;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> getList() {
		return ingreRep.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void putNewI(@RequestBody Ingredient ingredient) {
		ingreRep.save(ingredient);
	}
}
