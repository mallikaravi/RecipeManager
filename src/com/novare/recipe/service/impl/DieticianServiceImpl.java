package com.novare.recipe.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.novare.recipe.action.CreateRecipeMenuAction;
import com.novare.recipe.action.GetAllRecipeMenuAction;
import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.action.ViewRecipeMenuAction;
import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.IngredientPool;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IDieticianService;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * This is the DieticianServiceImpl class which implements IDieticianService
 * interface.It implements all the methods of the interface.
 *
 */
public class DieticianServiceImpl implements IDieticianService {

	@Override
	public Recipe createRecipe(Recipe recipe) {
		return null;
	}

	@Override
	public Recipe viewRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("Create Recipe", "View Recipe", "All Recipes");
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {
		switch (selectedOption) {
		case 1 -> {
			new CreateRecipeMenuAction().execute();
		}
		case 2 -> {
			new ViewRecipeMenuAction().execute();
		}
		case 3 -> {
			new GetAllRecipeMenuAction().execute();
		}
		case 0 -> {
			new MainMenuAction().execute();
		}
		default -> throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public List<Ingredient> getAllIngredients() throws Exception {
		
		return null;
	}

}
