package com.novare.recipe.model;

import java.util.Date;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Dayplan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "date", "recipe" })
public class DayPlan {

	private String name;
	

	private Date date;
	@XmlElement(name = "Recipe")
	private Recipe recipe;

	public DayPlan() {
		// TODO Auto-generated constructor stub
	}

	public DayPlan(String name, Date date, Recipe recipe) {
		super();
		this.name = name;
		this.date = date;
		this.recipe = recipe;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof String) {
			String name = (String) obj;
			return this.name.equals(name);
		}
		DayPlan dayPlan = (DayPlan) obj;
		return this.getName().equals(dayPlan.getName());
	}

	@Override
	public String toString() {
		return String.format("%-10s %s", name.toUpperCase(), recipe);

	}

}
