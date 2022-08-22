package com.novare.recipe.form;

import java.util.List;

import com.novare.recipe.util.MenuContext;

public class DieticianForm extends BaseForm {

	public DieticianForm() {
		super();
		setMenuOptions(List.of("Create Recipe", "View Recipe", "All Recipes"));
	}

	@Override
	public BaseForm handleOption(int selectedOption) {
		switch (selectedOption) {
		case 1 -> {
			setContext(MenuContext.CREATE_RECIPE);
		}
		case 2 -> {
			setContext(MenuContext.VIEW_RECIPE);
		}
		case 3 -> {
			setContext(MenuContext.ALL_RECIPIES);
		}
		default -> throw new IndexOutOfBoundsException();
		}
		return this;
	}

}
