package com.novare.recipe.model;

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
