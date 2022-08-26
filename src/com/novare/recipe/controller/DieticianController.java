package com.novare.recipe.controller;

import java.util.List;

import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

/**
 * This class extends BaseController class.
 *
 */
public class DieticianController extends BaseController {

	private Recipe recipeCache;

	/**
	 * this is the constructor where we are passing mpdel and view as arguments
	 * 
	 * @param model
	 * @param view
	 */
	public DieticianController(IDieticianService model, DieticianView view) {
		super(model, view);
		this.recipeCache = new Recipe();
	}

	/**
	 * This method is used to display the dietician actions in the menu.If we enter
	 * the correct option,we are going to handle the action,otherwise it gives an
	 * exception.
	 *
	 */
	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		try {
			int selectedOption = 0;
			switch (context) {
			case CREATE_RECIPE -> createRecipe();
			case VIEW_RECIPE -> displayRecipe();
			case UPDATE_RECIPE -> updateRecipe();
			case ALL_RECIPIES -> {
				displayAllRecipes();
				getView().waitForDecision();
			}
			default -> {
				super.requestUserInput(context);
				selectedOption = getView().getUserInput();
			}
			}
			getModel().handleOption(selectedOption);
		} catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context);
		}
	}

	@Override
	public IDieticianService getModel() {
		return (IDieticianService) super.getModel();
	}

	@Override
	public DieticianView getView() {
		return (DieticianView) super.getView();
	}

	/**
	 * This is the create recipe,where we can create the recipe with the
	 * name,ingredients and steps.
	 * 
	 * @throws Exception
	 */
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
		getView().waitForDecision();
	}

	/**
	 * This method is used to add ingredients to the recipe.
	 * 
	 * @throws Exception
	 */
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

	/**
	 * This method is used to build the recipe menu in a row we can view the recipe.
	 * @throws Exception
	 */
	private void buildRecipeMenu() throws Exception {
		List<Recipe> allRecipes = getModel().getAllRecipes();
		getView().setMenuOptionsInRow(allRecipes);
		int selection = getView().getSelectedOptionFromMenu(allRecipes.size());
		gotoMainMenu(selection);
		recipeCache = allRecipes.get(selection - 1);
	}

	/**
	 * This method displays the recipe
	 * @throws Exception
	 */
	private void displayRecipe() throws Exception {
		buildRecipeMenu();

		StringBuilder builder = new StringBuilder();
		builder.append("Recipe Name: " + recipeCache.getName()).append("\n");
		builder.append("Ingredients: " + recipeCache.getIngredients()).append("\n");
		builder.append("Steps:\n" + recipeCache.getSteps());
		getView().printMessage(builder.toString());
		getView().waitForDecision();

	}

	/**
	 * this method is used to update the recipe in the recipe pool.
	 * @throws Exception
	 */
	private void updateRecipe() throws Exception {
		buildRecipeMenu();

		String askRecipeNameChange = getView().askRecipeNameChange();
		if (!askRecipeNameChange.isEmpty()) {
			recipeCache.setName(askRecipeNameChange);
		}
		updateRecipeIngredients();
		String askRecipeStepChange = getView().askRecipeStepChange();
		if (!askRecipeStepChange.isEmpty()) {
			recipeCache.setSteps(askRecipeStepChange);
		}
		getModel().updateRecipe(recipeCache);
		getView().printSaveMessage();
		getView().waitForDecision();

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
