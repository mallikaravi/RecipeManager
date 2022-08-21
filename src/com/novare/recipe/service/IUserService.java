/**
 * 
 */
package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.model.Recipe;

/**
 * This is the interface of the User.It has all the actions that user performs
 * in this application
 *
 */
public interface IUserService extends IRecipeService {

	/**
	 * This is the method to view the recipe
	 * 
	 * @return-Recipe
	 */
	Recipe viewRecipe(Recipe recipe);

	/**
	 * This is the method to generate all the recipes
	 * 
	 * @return-List of recipes
	 */
	List<Recipe> getAllrecipes();

	/**
	 * This is the method to view the recipes of the week
	 * 
	 * @return-List of recipes
	 */
	List<Recipe> viewRecipeWeek();

	/**
	 * This is the method to generate the recipes of the week
	 * 
	 * @return-List of recipes
	 */
	List<Recipe> generateRecipeWeek();

}
