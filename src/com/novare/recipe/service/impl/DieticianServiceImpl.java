package com.novare.recipe.service.impl;

import java.nio.file.Paths;
import java.util.List;

import com.novare.recipe.action.CreateRecipeMenuAction;
import com.novare.recipe.action.GetAllRecipeMenuAction;
import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.action.UpdateMenuAction;
import com.novare.recipe.action.ViewRecipeMenuAction;
import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.IngredientPool;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.RecipePool;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.ServiceUtil;

import jakarta.xml.bind.JAXBException;

/**
 * This is the DieticianServiceImpl class which implements IDieticianService
 * interface.It implements all the methods of the interface.
 *
 */
public class DieticianServiceImpl implements IDieticianService {

	@Override
	public Recipe createRecipe(Recipe recipe) throws Exception {
		RecipePool pool = getRecipePool();
		recipe.setId(pool.getRecipes().size());
		pool.addRecipe(recipe);

		ServiceUtil.getMarshaller(RecipePool.class).marshal(pool, Paths.get("assets/RecipePool.xml").toFile());
		return recipe;
	}

	@Override
	public Recipe updateRecipe(Recipe recipe) throws Exception {
		RecipePool pool = getRecipePool();
		pool.removeRecipe(recipe);
		pool.addRecipe(recipe);

		ServiceUtil.getMarshaller(RecipePool.class).marshal(pool, Paths.get("assets/RecipePool.xml").toFile());
		return recipe;
	}

	@Override
	public List<Recipe> getAllRecipes() throws Exception {
		try {
			return getRecipePool().getRecipes();
		} catch (JAXBException e) {
			throw new Exception();
		}
	}

	@Override
	public List<Ingredient> getAllIngredients() throws Exception {
		try {
			IngredientPool ingredientPool = (IngredientPool) ServiceUtil.getUnmarshaller(IngredientPool.class)
					.unmarshal(Paths.get("assets/Ingredients.xml").toFile());
			return ingredientPool.getIngredients();
		} catch (JAXBException e) {
			throw new Exception();
		}

	}

	@Override
	public RecipePool getRecipePool() throws Exception {
		try {
			RecipePool recipePool = (RecipePool) ServiceUtil.getUnmarshaller(RecipePool.class)
					.unmarshal(Paths.get("assets/RecipePool.xml").toFile());
			return recipePool;
		} catch (JAXBException e) {
			throw new Exception();
		}
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction();
		}
		case 1 -> {
			new CreateRecipeMenuAction();
		}
		case 2 -> {
			new ViewRecipeMenuAction();
		}
		case 3 -> {
			new UpdateMenuAction();
		}
		case 4 -> {
			new GetAllRecipeMenuAction();
		}

		default -> throw new IndexOutOfBoundsException();
		}

	}

}
