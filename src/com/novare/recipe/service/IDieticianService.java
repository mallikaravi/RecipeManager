package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.RecipePool;

/**
 * This is the interface of the Dietician.It has all the actions that dietician
 * performs in this application
 *
 */
public interface IDieticianService extends IRecipeService {
	/**
	 * This is the method used to create the recipe in the application
	 * 
	 * @return-Recipe
	 */
	Recipe createRecipe(Recipe recipe) throws Exception;

	/**
	 * This is the method used to edit or update the recipe in the application
	 * 
	 * @return-recipe
	 */
	Recipe updateRecipe(Recipe recipe);

	/**
	 * This is the method used to delete the recipe in the application
	 * 
	 * @return-true
	 */
	boolean deleteRecipe(Recipe recipe);

	/**
	 * This method is used to generate all the recipes
	 * 
	 * @return-list of recipes
	 */
	List<Recipe> getAllRecipes() throws Exception;

	List<Ingredient> getAllIngredients() throws Exception;

	RecipePool getRecipePool() throws Exception;

}
