package fr.pizzeria.aspect;

import java.time.LocalDate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;
import fr.pizzeria.repository.PerfRepository;

@Component
@Aspect
public class AspectPizzaPerformances {
	@Autowired
	private PerfRepository perfRep;

	@Around("execution(* fr.pizzeria.dao.impl.spring.PizzaDaoImplDataJpa.*(..))")
	public Object logDateDebutSet(ProceedingJoinPoint pjp) throws Throwable {
		LocalDate begin = LocalDate.now();
		long before = System.currentTimeMillis();

		Object valeurRetournee = pjp.proceed();

		long after = System.currentTimeMillis();

		perfRep.save(new Performance(pjp.getSignature().toString(), begin, after - before));

		return valeurRetournee;
	}
}
