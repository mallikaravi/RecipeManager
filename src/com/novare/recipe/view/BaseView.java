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

	public void setMenuOptions(List<?> menuOptions, boolean... index) {
		if (index.length > 0) {
			PrintHandler.optionListWithoutIndex(menuOptions);
		} else {
			PrintHandler.optionList(menuOptions);
		}
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

	public int askUserToChooseIndexFromList() {
		String input = getUserTerminal().nextLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException();
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	public void waitForDecision() {
		setMenuOptions(List.of("[C] Continue", "[Q] Quit"), false);
		String input = getUserTerminal().nextLine();
		boolean isValid = input.equalsIgnoreCase("C") || input.equalsIgnoreCase("Q");
		if (input.isEmpty() || !isValid) {
			throw new IllegalArgumentException();
		}
		if (input.equalsIgnoreCase("Q")) {
			printMessage("BYE !");
			System.exit(0);
		}
	}

	public int askUserToChooseRecipe() {
		System.out.print("Choose a Recipe and press enter [e.g, 1]:");
		return askUserToChooseIndexFromList();
	}
}
