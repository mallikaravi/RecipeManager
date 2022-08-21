package com.novare.recipe.service;

import java.util.List;

public interface IRecipeService {
	void handleOption(int selectedOption);

	List<String> getMenuOptions();
}
