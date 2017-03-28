package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

/**
 * @author PaolaLamb
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml",
				"dao-memoire-config.xml")) {
			Menu menu = (Menu) context.getBean("menu");
			menu.executer();
		}

		/*
		 * java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.
		 * SEVERE); IhmTools ihm = new IhmTools(new PizzaDaoImplJPA());
		 * 
		 * new Menu(ihm).executer();
		 * 
		 */}

}
