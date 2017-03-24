package fr.pizzeria.admin.event;

import java.time.LocalDateTime;

import fr.pizzeria.model.Pizza;

public class EventPizza {

	private Pizza pizza;
	private LocalDateTime dateTime;
	private EventType eventType;

	public EventPizza(Pizza pizza, LocalDateTime dateTime, EventType eventType) {
		this.pizza = pizza;
		this.dateTime = dateTime;
		this.eventType = eventType;
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

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

}
