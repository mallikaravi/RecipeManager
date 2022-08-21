package com.novare.recipe.form;

import java.util.List;

public class DieticianForm extends BaseForm {

	public DieticianForm() {
		super();
		setMenuOptions(List.of("Create Recipe", "View Recipe", "All Recipes"));
	}

	@Override
	public BaseForm handleOption(int selectedOption) {
		switch (selectedOption) {
		case 1 -> {
		}
		case 2 -> {
		}
		default -> throw new IndexOutOfBoundsException();
		}
		return this;
	}

}
