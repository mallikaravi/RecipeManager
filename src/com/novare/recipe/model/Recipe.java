package com.novare.recipe.model;

import java.util.List;

public class Recipe {
	private int id;
	private String name;
	private List<Ingredient> ingredients;
	private String steps;
	/**
	 * @param id
	 * @param name
	 * @param ingredients
	 * @param steps
	 */
	public Recipe(int id, String name, List<Ingredient> ingredients, String steps) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.steps = steps;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(String steps) {
		this.steps = steps;
	}

	

	
}
