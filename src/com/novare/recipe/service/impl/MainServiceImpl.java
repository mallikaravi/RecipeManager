package com.novare.recipe.service.impl;

import java.util.List;

import com.novare.recipe.action.DieticianMenuAction;
import com.novare.recipe.action.UserMenuAction;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.service.IRecipeService;

public class MainServiceImpl implements IRecipeService {

	@Override
	public List<String> getMenuOptions() {
		return List.of("User", "Dietician");
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {

		switch (selectedOption) {
		case 1 -> {
			new UserMenuAction().execute();
		}
		case 2 -> {
			new DieticianMenuAction().execute();
		}

		default -> throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public List<Recipe> getAllRecipes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
