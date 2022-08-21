package com.novare.recipe.form;

import java.util.List;

import com.novare.recipe.action.DieticianMenuAction;
import com.novare.recipe.action.UserMenuAction;

public class MainForm extends BaseForm {

	@Override
	public BaseForm handleOption(int selectedOption) {
		switch (selectedOption) {
		case 1 -> {
			setAction(new UserMenuAction());
		}
		case 2 -> {
			setAction(new DieticianMenuAction());
		}
		default -> throw new IndexOutOfBoundsException();
		}
		return this;
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("User", "Dietician");
	}

}
