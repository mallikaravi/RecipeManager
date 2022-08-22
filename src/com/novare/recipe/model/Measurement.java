package com.novare.recipe.model;

/**
 * This is the enum used for the measurement of ingredients
 *
 */
public enum Measurement {

	Quantity("PC"), Liters("LTR"), Kilogram("KG");

	private String measurement;

	private Measurement(String measurement) {
		this.measurement = measurement;
	}

	public String getMeasurement() {
		return measurement;
	}
	
	
}
