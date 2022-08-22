package com.novare.recipe.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ingredient")
@XmlType(propOrder = { "name", "measurement", "amount" })
public class Ingredient {

	private String name;
	private String measurement;
	private float amount;

	public Ingredient() {
	}

	/**
	 * @param name
	 * @param measurement
	 * @param amount
	 */
	public Ingredient(String name, String measurement, float amount) {
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
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", measurement=" + measurement + ", amount=" + amount + "]";
	}

}
