package fr.pizzeria.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.stock")
public class PizzeriaSpringConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewR = new InternalResourceViewResolver();
		viewR.setPrefix("/WEB-INF/views/");
		viewR.setSuffix(".jsp");

		return viewR;
	}
}
