package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.model.Recipe;

public interface IRecipeService {

	void handleOption(int selectedOption) throws Exception;

	/**
	 * This is the method to generate all the recipes
	 * 
	 * @throws Exception
	 * 
	 * @return-List of recipes
	 */
	List<Recipe> getAllRecipes() throws Exception;

}
