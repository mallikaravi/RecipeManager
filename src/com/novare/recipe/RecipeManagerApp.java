package com.novare.recipe;

import com.novare.recipe.action.MainMenuAction;

/**
 * This {@code RecipeMangerApp} is the main class of this application.
 *
 */
public class RecipeManagerApp {

	public static void main(String[] args) {
		try {
			new MainMenuAction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
