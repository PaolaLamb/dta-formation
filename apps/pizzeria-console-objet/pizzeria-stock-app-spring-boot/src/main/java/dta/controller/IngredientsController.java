package dta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class IngredientsController {

	@RequestMapping(path = "/ingredients", method = RequestMethod.GET)
	public String helloWorld() {
		return "ingredients";
	}

}