package fr.pizzeria.admin.event;

import org.apache.commons.lang3.text.WordUtils;

public enum EventType {
	CREATION("creation"), MODIFICATION("modif"), SUPPRESSION("suppr");

	private String eventType;
	private String libelle;

	private EventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return eventType;
	}

	/**
	 * @return a good looking name
	 */
	public String getNiceName() {
		return WordUtils.capitalize(name().toLowerCase());
	}

}
