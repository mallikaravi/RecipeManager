package com.novare.recipe.controller;

import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController {

	private final IDieticianService model;

	public DieticianController(IDieticianService model, DieticianView view) {
		super(model, view);
		this.model = model;
	}

	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		String input = getUserTerminal().nextLine();

		try {
			int selectedOption = Integer.parseInt(input);

			model.handleOption(selectedOption);
		} catch (IndexOutOfBoundsException | NumberFormatException exception) {
			getView().printInvalidOption();
		}

		// request new songs indefinitely on purpose! (Infinity scanner)
		getView().printUserRequest();

	}

	private Recipe buildRecipe() throws Exception {
		Recipe recipe = new Recipe();
		System.out.println("Enter repie Name:");
		String input = getUserTerminal().nextLine();
		if (input.isEmpty()) {
			throw new Exception();
		}
		recipe.setName(input);
		System.out.println("Select Ingrediants:");
		input = getUserTerminal().nextLine();
		if (input.isEmpty()) {
			throw new Exception();
		}

		recipe.setName(input);
		return recipe;
	}
}
