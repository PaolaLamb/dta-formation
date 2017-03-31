package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.aspect.AspectPizzaCodeInsertion;
import fr.pizzeria.aspect.AspectPizzaPerformances;
import fr.pizzeria.dao.impl.spring.PizzaDaoImplDataJpa;

@Configuration
@EnableJpaRepositories("fr.pizzeria.repository")
@EnableAspectJAutoProxy
@Import({ PizzaDaoImplDataJpa.class, AspectPizzaCodeInsertion.class, AspectPizzaPerformances.class })
public class PizzaDaoImplDataJpaConfig {

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-pu");
		return emf;
	}
}
