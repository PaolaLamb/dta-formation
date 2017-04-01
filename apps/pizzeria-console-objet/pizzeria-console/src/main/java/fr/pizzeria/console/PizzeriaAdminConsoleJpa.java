package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.impl.spring.PizzaDaoImplDataJpa;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAdminConsoleJpa {

	@Bean
	public DaoPizza<Pizza, String> implementationDaoPizza() {
		return new PizzaDaoImplDataJpa();
	}

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

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppJdbcConsole.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.executer();
		}
	}
}
