package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.impl.ClientDaoImplArray;
import fr.pizzeria.dao.impl.spring.PizzaDaoImplJdbcTemplate;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppStringConfig {

	/*
	 * @Bean public DaoPizza<Pizza, String> implementationDaoPizza() { return
	 * new PizzaDaoImplArray(); }
	 */

	@Bean
	public DaoPizza<Pizza, String> implementationPizzaDao() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("init-schema.sql").build();

		return new PizzaDaoImplJdbcTemplate(dataSource);
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public DaoClient implementationDaoClient() {
		return new ClientDaoImplArray();
	}

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppStringConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.executer();
		}
	}
}
