package fr.pizzeria.admin.event;

import org.apache.commons.lang3.text.WordUtils;

public enum EventType {
	CREATION("creation"), MODIFICATION("modif"), SUPPRESSION("suppr");

	private String eventType;

	private EventType(String eventType) {
		this.eventType = eventType;
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
