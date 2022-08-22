package com.novare.recipe.controller;

import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.form.BaseForm;
import com.novare.recipe.form.DieticianForm;
import com.novare.recipe.form.MainForm;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController {

	private final IDieticianService model;

	public DieticianController(IDieticianService model, DieticianView view) {
		super(new DieticianForm(), view);
		this.model = model;
	}

	@Override
	public BaseForm requestUserInput() throws Exception {
		BaseForm form = super.requestUserInput();
		model.handleOption(0);
//		switch (form.getContext()) {
//		case CREATE_RECIPE -> {
//			model.createRecipe(buildRecipe());
//			form = new MainForm(new MainMenuAction());
//		}
//		case VIEW_RECIPE -> {
//			model.viewRecipe(null);
//			form.setContext(null);
//		}
//		case ALL_RECIPIES -> {
//			model.getAllRecipes();
//			form.setContext(null);
//		}
//		default -> throw new IllegalArgumentException("Unexpected value: " + form.getContext());
//		}
		return form;
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
