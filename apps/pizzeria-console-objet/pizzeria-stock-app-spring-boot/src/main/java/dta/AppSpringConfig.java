package dta;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("fr.pizzeria.spring.mvc.controller")
public class AppSpringConfig {

}
