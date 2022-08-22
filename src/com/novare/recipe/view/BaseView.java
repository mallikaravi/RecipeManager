package com.novare.recipe.view;

import java.util.List;
import java.util.Scanner;

import com.novare.recipe.util.PrintHandler;

public abstract class BaseView {
	private final Scanner scanner;

	public BaseView() {
		this.scanner = new Scanner(System.in);
		PrintHandler.clearScreen();
		PrintHandler.appTitle();
	}

	public void setMenuOptions(List<String> menuOptions) {
		PrintHandler.optionList(menuOptions);
		printUserRequest();
	}

	public void setMenuOptionsInRow(List<?> menuOptions) {
		PrintHandler.optionListInRow(menuOptions);
	}

	protected Scanner getUserTerminal() {
		return scanner;
	}

	public abstract void printInvalidOption();

	public abstract void printUserRequest();

}
