package com.novare.recipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RecipePool")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecipePool implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Recipe")
	private List<Recipe> pool = new ArrayList<>();

	public RecipePool() {
	}

	public List<Recipe> getRecipes() {
		return pool;
	}

	public void addRecipe(Recipe recipe) {
		this.pool.add(recipe);
	}

	public void removeRecipe(Recipe recipe) {
		this.pool.remove(recipe);
	}

	@Override
	public String toString() {
		return "RecipePool [listOfRecipes=" + pool + "]";
	}

}
