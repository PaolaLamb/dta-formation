package dta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page/ingredients")
public class IngredientsController {

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {
		return "ingredients";
	}

}