package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.Recipe;

public interface ICacheService {
	List<Recipe> getAllRecipes() throws Exception;

	List<Ingredient> getAllIngredients() throws Exception;
}
