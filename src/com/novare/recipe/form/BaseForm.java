package com.novare.recipe.form;

import java.util.List;

import com.novare.recipe.action.BaseMenuAction;

public abstract class BaseForm {

	private BaseMenuAction action;
	private List<String> menuOptions;
	private Integer selectedOption;

	public BaseMenuAction getAction() {
		return action;
	}

	public void setAction(BaseMenuAction action) {
		this.action = action;
	}

	public List<String> getMenuOptions() {
		return menuOptions;
	}

	public void setMenuOptions(List<String> menuOptions) {
		this.menuOptions = menuOptions;
	}

	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Integer getSelectedOption() {
		return selectedOption;
	}

	public BaseForm handleOption(int selectedOption) {
		return null;
	}
}
