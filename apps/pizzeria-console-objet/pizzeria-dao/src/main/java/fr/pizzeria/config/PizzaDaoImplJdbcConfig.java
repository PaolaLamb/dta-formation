package fr.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.impl.spring.PizzaDaoImplJdbcTemplate;

@Configuration
@Import(PizzaDaoImplJdbcTemplate.class)
public class PizzaDaoImplJdbcConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("init-schema.sql").build();
	}

}
