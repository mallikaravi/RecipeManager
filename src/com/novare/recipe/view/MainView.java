package com.novare.recipe.view;

import java.util.List;

import com.novare.recipe.util.PrintHandler;

public class MainView extends BaseView {

	public MainView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("User", "Dietician");
	}

	public void printNavigationMenu() {
		PrintHandler.optionQuit();
	}

}
