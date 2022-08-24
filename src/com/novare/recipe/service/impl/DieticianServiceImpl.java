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

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * This is the DieticianServiceImpl class which implements IDieticianService
 * interface.It implements all the methods of the interface.
 *
 */
public class DieticianServiceImpl implements IDieticianService {

	@Override
	public Recipe createRecipe(Recipe recipe) throws Exception {
		RecipePool pool = getRecipePool();
		pool.addRecipe(recipe);

		JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Marshal the Recipepool list in file
		jaxbMarshaller.marshal(pool, Paths.get("RecipePool.xml").toFile());
		return recipe;
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
			JAXBContext jaxbContext = JAXBContext.newInstance(IngredientPool.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			IngredientPool ingredientPool = (IngredientPool) jaxbUnmarshaller
					.unmarshal(Paths.get("Ingredients.xml").toFile());
			return ingredientPool.getIngredients();
		} catch (JAXBException e) {
			throw new Exception();
		}

	}

	@Override
	public RecipePool getRecipePool() throws Exception {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RecipePool recipePool = (RecipePool) jaxbUnmarshaller.unmarshal(Paths.get("RecipePool.xml").toFile());
			return recipePool;
		} catch (JAXBException e) {
			throw new Exception();
		}
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("Create Recipe", "View Recipe", "Update Recipe", "All Recipes");
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction().execute();
		}
		case 1 -> {
			new CreateRecipeMenuAction().execute();
		}
		case 2 -> {
			new ViewRecipeMenuAction().execute();
		}
		case 3 -> {
			new UpdateMenuAction().execute();
		}
		case 4 -> {
			new GetAllRecipeMenuAction().execute();
		}

		default -> throw new IndexOutOfBoundsException();
		}

	}

}
