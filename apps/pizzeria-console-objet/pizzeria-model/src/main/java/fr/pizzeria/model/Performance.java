package fr.pizzeria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ToString
	@Column(name = "service", length = 255, nullable = false)
	private String service;

	@ToString
	@Column(name = "date", nullable = false)
	private LocalDate date;

	@ToString
	@Column(name = "tempsExcecution")
	private long tempsExecution;

	public Performance() {
	}

	public Performance(String service, LocalDate date, long tempsExecution) {
		super();
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	public Performance(int i, String string, LocalDate begin, long l) {
		super();
		this.id = i;
		this.service = string;
		this.date = begin;
		this.tempsExecution = l;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
