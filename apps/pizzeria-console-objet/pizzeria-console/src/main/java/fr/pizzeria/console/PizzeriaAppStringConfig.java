package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.ClientDaoImplArray;
import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppStringConfig {

	@Bean
	public DaoPizza<Pizza, String> implementationDaoPizza() {
		return new PizzaDaoImplArray();
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
