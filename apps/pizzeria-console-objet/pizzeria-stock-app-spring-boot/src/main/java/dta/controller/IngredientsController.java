package dta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ingredients")
public class IngredientsController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "hello world";
	}

}