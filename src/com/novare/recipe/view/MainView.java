package com.novare.recipe.view;

import java.util.List;

import com.novare.recipe.util.PrintHandler;

public class MainView {
	public MainView(List<String> menuOptions) {
		PrintHandler.clearScreen();
		PrintHandler.appTitle();
		System.out.println("Main menu options:");
		PrintHandler.optionList(menuOptions);
		printRequest();
	}

	public void printInvalidOption() {
		System.out.println("Invalid option");
	}

	public void printRequest() {
		System.out.print("Choose an option press enter: ");
	}
}
