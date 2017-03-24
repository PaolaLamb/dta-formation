package fr.pizzeria.admin.event;

import java.time.LocalDateTime;

import fr.pizzeria.model.Pizza;

public class SuppressionPizzaEvent extends EventPizza {
	private Pizza pizza;
	private LocalDateTime dateTime;

	public SuppressionPizzaEvent(Pizza pizza, LocalDateTime dateTime) {
		this.pizza = pizza;
		this.dateTime = dateTime;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
