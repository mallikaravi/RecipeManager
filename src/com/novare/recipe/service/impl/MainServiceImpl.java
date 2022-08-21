package com.novare.recipe.service.impl;

import java.util.List;

import com.novare.recipe.action.DieticianMenuAction;
import com.novare.recipe.action.UserMenuAction;
import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.IRecipeService;

public class MainServiceImpl implements IRecipeService {

	@Override
	public BaseForm handleOption(int selectedOption) {
		BaseForm returnData = new BaseForm();
		switch (selectedOption) {
		case 1 -> {
			returnData.setAction(new UserMenuAction());
		}
		case 2 -> {
			returnData.setAction(new DieticianMenuAction());
		}
		default -> throw new IndexOutOfBoundsException();
		}
		return returnData;
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("User", "Dietician");
	}

}
