package fr.pizzeria.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.dao.impl.PizzaDaoImplJdbcTemplate;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.dao")
public class DaoConfigJdbcTemplate {

	@Bean
	public DaoPizza<Pizza, String> implementationPizzaDao() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/pizzeria?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return new PizzaDaoImplJdbcTemplate(dataSource);
	}

}
