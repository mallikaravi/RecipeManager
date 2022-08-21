package com.novare.recipe.model;

public class Ingredient {

	private String name;
	private String measurement;
	private String amount;

	/**
	 * @param name
	 * @param measurement
	 * @param amount
	 */
	public Ingredient(String name, String measurement, String amount) {
		super();
		this.name = name;
		this.measurement = measurement;
		this.amount = amount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the measurement
	 */
	public String getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
