package dta.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.stock.repository.IngredientRepository;

@RestController
@RequestMapping("/rest/ingredients")
@EnableJpaRepositories("fr.pizzeria.stock.repository")
public class IngredientRest {

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
