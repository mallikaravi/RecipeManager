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

	public void printSaveMessage() {
		System.out.println("Data successfully Saved/Updated");
	}

	public void printInvalidOption() {
		System.out.println("Invalid option");
	}

	public void printUserRequest() {
		System.out.print("Choose an option and press enter: ");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public boolean askConfirmationYesOrNo() {
		String input = getUserTerminal().nextLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException();
		}

		return input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y");
	}

}
