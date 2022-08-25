package com.novare.recipe.controller;

import java.util.List;
import java.util.Scanner;

import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IRecipeService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.BaseView;

public abstract class BaseController {
	private final Scanner scanner;
	private final BaseView view;
	private final IRecipeService model;

	public BaseController(IRecipeService model, BaseView view) {
		this.scanner = new Scanner(System.in);
		this.view = view;
		this.model = model;
	}

	protected Scanner getUserTerminal() {
		return scanner;
	}

	public BaseView getView() {
		return view;
	}

	public IRecipeService getModel() {
		return model;
	}

	public void requestUserInput(MenuContext context) throws Exception {
		view.setMenuOptions(model.getMenuOptions());

	}

	protected List<Recipe> viewAllRecipes() throws Exception {
		List<Recipe> allRecipes = getModel().getAllRecipes();
		getView().setMenuOptionsInRow(allRecipes);

		return allRecipes;
	}
}
