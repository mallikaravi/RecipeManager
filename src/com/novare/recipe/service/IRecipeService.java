package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.form.BaseForm;

public interface IRecipeService {
	BaseForm handleOption(int selectedOption);

	List<String> getMenuOptions();
}
