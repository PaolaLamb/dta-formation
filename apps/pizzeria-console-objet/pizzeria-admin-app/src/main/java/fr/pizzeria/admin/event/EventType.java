package fr.pizzeria.admin.event;

import org.apache.commons.lang3.text.WordUtils;

public enum EventType {
	CREATION("creation"), MODIFICATION("modif"), SUPPRESSION("suppr");

	private String type;

	private EventType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

	/**
	 * @return a good looking name
	 */
	public String getNiceName() {
		return WordUtils.capitalize(name().toLowerCase());
	}

}
