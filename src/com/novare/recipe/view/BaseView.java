package com.novare.recipe.view;

import java.util.List;

import com.novare.recipe.util.PrintHandler;

public abstract class BaseView {

	public BaseView() {
		PrintHandler.clearScreen();
		PrintHandler.appTitle();
	}

	public void setMenuOptions(List<String> menuOptions) {
		PrintHandler.optionList(menuOptions);
		printRequest();
	}

	public abstract void printInvalidOption();

	public abstract void printRequest();
}
