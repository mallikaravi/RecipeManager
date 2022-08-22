package com.novare.recipe.service;

import java.util.List;

public interface IRecipeService {
	List<String> getMenuOptions();

	void handleOption(int selectedOption) throws IndexOutOfBoundsException;
}
