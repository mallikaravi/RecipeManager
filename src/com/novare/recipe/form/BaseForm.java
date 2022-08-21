package com.novare.recipe.form;

import java.util.List;

import com.novare.recipe.action.BaseMenuAction;

public class BaseForm {
	private BaseMenuAction action;
	private List<String> menuOptions;

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
}
