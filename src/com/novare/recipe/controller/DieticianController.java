package com.novare.recipe.controller;

import java.util.List;

import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController {

	private final IDieticianService model;
	private final DieticianView view;
	private Recipe recipeCache = new Recipe();;

	public DieticianController(IDieticianService model, DieticianView view) {
		super(model, view);
		this.model = model;
		this.view = view;
	}

	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		try {
			if (context == MenuContext.CREATE_RECIPE) {
				createRecipe();
				getModel().handleOption(0);
			} else if (context == MenuContext.VIEW_RECIPE) {
				viewRecipe();
				getModel().handleOption(0);
			} else if (context == MenuContext.UPDATE_RECIPE) {
				updateRecipe();
				getModel().handleOption(0);
			} else {
				super.requestUserInput(context);
				String input = getUserTerminal().nextLine();
				int selectedOption = Integer.parseInt(input);
				getModel().handleOption(selectedOption);
			}
		} catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
			getView().printInvalidOption();
			requestUserInput(context);
		}
		getView().printUserRequest();

	}

	@Override
	public IDieticianService getModel() {
		return this.model;
	}

	@Override
	public DieticianView getView() {
		return this.view;
	}

	private void createRecipe() throws Exception {
		if (recipeCache.getName() == null) {
			recipeCache.setName(getView().askRecipeName());
		}
		if (recipeCache.getIngredients().isEmpty()) {
			addIngredientsToRecipe();
		}
		if (recipeCache.getSteps() == null) {
			recipeCache.setSteps(getView().askRecipeSteps());
		}
		getModel().createRecipe(recipeCache);
		getView().printSaveMessage();
	}

	private void addIngredientsToRecipe() throws Exception {
		List<Ingredient> allIngredients = getModel().getAllIngredients();
		getView().setMenuOptionsInRow(allIngredients);
		for (Integer selection : getView().askIngredients()) {
			if (selection > allIngredients.size()) {
				throw new IndexOutOfBoundsException();
			}
			recipeCache.getIngredients().add(allIngredients.get(selection - 1));
		}
	}

	private void viewRecipe() throws Exception {
		List<Recipe> allRecipes = getModel().getAllRecipes();
		getView().setMenuOptionsInRow(allRecipes);
		int selection = getView().askUserToChooseRecipe();
		if (selection > allRecipes.size()) {
			throw new IndexOutOfBoundsException();
		}
		recipeCache = allRecipes.get(selection - 1);
		getView().printMessage("Recipe Name:" + recipeCache.getName() + "\n\nIngredients:"
				+ recipeCache.getIngredients() + "\n\nSteps:" + recipeCache.getSteps());

	}

	private void updateRecipe() throws Exception {
		List<Recipe> allRecipes = getModel().getAllRecipes();
		getView().setMenuOptionsInRow(allRecipes);
		int selection = getView().askUserToChooseRecipe();
		if (selection > allRecipes.size()) {
			throw new IndexOutOfBoundsException();
		}
		recipeCache = allRecipes.get(selection - 1);
		if (!getView().askRecipeNameChange().isEmpty()) {
			recipeCache.setName(getView().askRecipeNameChange());
		}
		updateRecipeIngredients();
		if (!getView().askRecipeStepChange().isEmpty()) {
			recipeCache.setName(getView().askRecipeNameChange());
		}
		getModel().updateRecipe(recipeCache);
	}

	private void updateRecipeIngredients() throws Exception {
		List<Ingredient> ingredients = recipeCache.getIngredients();
		List<Integer> askIngredientChange = getView().askIngredientChange(ingredients);
		if (askIngredientChange.isEmpty()) {
			if (getView().askIngredientAddition()) {
				addIngredientsToRecipe();
			}
		} else {
			for (Integer ingredient : askIngredientChange) {
				if (ingredient > ingredients.size()) {
					throw new IndexOutOfBoundsException();
				}
				recipeCache.getIngredients().remove(ingredients.get(ingredient - 1));
			}
			updateRecipeIngredients();
		}
	}

}
