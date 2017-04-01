package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.impl.ClientDaoImplArray;
import fr.pizzeria.dao.impl.spring.PizzaDaoImplJdbcTemplate;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppJdbcConsole {

	@Bean
	public DaoPizza<Pizza, String> implementationPizzaDao() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/pizzeria?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
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
				PizzeriaAppJdbcConsole.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.executer();
		}
	}
}
