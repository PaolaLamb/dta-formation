package fr.pizzeria.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Component
@Aspect
public class AspectPizzaCodeInsertion {

	@Before("execution(* fr.pizzeria.dao.impl.spring.PizzaDaoImplDataJpa.saveNew(..))")
	public void logDateDebutSet(JoinPoint jp) {
		Pizza pizza = (Pizza) jp.getArgs()[0];
		if ("".equals(pizza.getCode())) {
			pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());
		}
	}
}
