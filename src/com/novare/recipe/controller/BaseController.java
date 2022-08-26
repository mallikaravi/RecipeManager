package com.novare.recipe.controller;

import java.util.List;

import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IRecipeService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.BaseView;

/**
 * This is a abstract class which holds final view and model boolean .
 *
 */
public abstract class BaseController {
	private final BaseView view;
	private final IRecipeService model;
	private boolean menuVisible;

	/**
	 * this is constructor where we are passing model and view
	 * 
	 * @param model
	 * @param view
	 */
	public BaseController(IRecipeService model, BaseView view) {
		this.view = view;
		this.model = model;
		setMenuVisible(true);
	}

	/**
	 * this is the method for requesting user input.
	 * 
	 * @param context
	 * @throws Exception
	 */
	public void requestUserInput(MenuContext context) throws Exception {
		if (isMenuVisible()) {
			getView().setMenuOptions(getView().getMenuOptions());
			getView().printUserRequest();
		}
	}

	/**
	 * @return the menuVisible
	 */
	public boolean isMenuVisible() {
		return menuVisible;
	}

	/**
	 * @param menuVisible the menuVisible to set
	 */
	public void setMenuVisible(boolean menuVisible) {
		this.menuVisible = menuVisible;
	}

	public BaseView getView() {
		return view;
	}

	public IRecipeService getModel() {
		return model;
	}

	protected void gotoMainMenu(int option) throws Exception {
		if (option == 0) {
			getModel().handleOption(option);
		}
	}

	/**
	 * this method displays all the recipes.Here we are also calling another method
	 * to display the options in a row.
	 * 
	 * @return
	 * @throws Exception
	 */
	protected List<Recipe> displayAllRecipes() throws Exception {
		List<Recipe> allRecipes = getModel().getAllRecipes();
		getView().setMenuOptionsInRow(allRecipes);
		return allRecipes;
	}
}
