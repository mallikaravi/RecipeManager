package com.novare.recipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Recipe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "ingredients", "steps" })
public class Recipe {

	private Integer id;
	private String name;
	@XmlElementWrapper(name = "Ingredients")
	@XmlElement(name = "Ingredient")
	private List<Ingredient> ingredients = new ArrayList<>();
	private String steps;

	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param ingredients
	 * @param steps
	 */
	public Recipe(Integer id, String name, List<Ingredient> ingredients, String steps) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.steps = steps;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the steps
	 */
	public String getSteps() {
		return removeMoreSpaces(steps);
	}

	private String removeMoreSpaces(String steps) {
		return steps.replaceAll("\\s{2,}", "\n");
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(String steps) {
		this.steps = steps;
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
		Recipe recipe = (Recipe) obj;
		return this.getName().equals(recipe.getName());
	}

	@Override
	public String toString() {
		return name.toUpperCase();
	}

}
