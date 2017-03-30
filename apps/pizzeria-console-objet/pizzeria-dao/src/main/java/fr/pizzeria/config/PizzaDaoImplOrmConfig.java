package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.impl.spring.PizzaDaoImplOrm;

@Configuration
@Import(PizzaDaoImplOrm.class)
@EnableTransactionManagement
public class PizzaDaoImplOrmConfig {

	@Bean
	public LocalEntityManagerFactoryBean emf() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-pu");
		return emf;
	}

	@Bean
	PlatformTransactionManager txManager() {
		return new JpaTransactionManager();
	}

}
