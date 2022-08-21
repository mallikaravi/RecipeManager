package com.novare.recipe.form;

import java.util.List;

public class UserForm extends BaseForm {

	@Override
	public BaseForm handleOption(int selectedOption) {
		return super.handleOption(selectedOption);
	}
	@Override
	public List<String> getMenuOptions() {
		return List.of("List My Weeks", "List Recipies", "View Recipe", "Generate a new Week");
	}
}
