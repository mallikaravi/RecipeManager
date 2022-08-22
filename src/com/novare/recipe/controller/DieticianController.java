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
	private Recipe recipe;

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

	private Recipe createRecipe() throws Exception {
		recipe = new Recipe();
		if (recipe.getName() == null) {
			getView().askRecipeName();
			String input = getUserTerminal().nextLine();
			if (input.isEmpty()) {
				throw new IllegalArgumentException();
			}
			recipe.setName(input);
		}
		if (recipe.getIngredients().isEmpty()) {
			List<Ingredient> allIngredients = model.getAllIngredients();
			getView().setMenuOptionsInRow(allIngredients);
			getView().askIngredients();
			String input = getUserTerminal().nextLine();
			if (input.isEmpty()) {
				throw new IllegalArgumentException();
			}
			for(String ingredient:input.split(",")) {
				int selection = Integer.parseInt(ingredient);
				recipe.getIngredients().add(allIngredients.get(selection-1));
			}
		}

		return recipe;
	}
}
