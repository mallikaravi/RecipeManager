package com.novare.recipe.view;

import java.util.List;
import java.util.Scanner;

import com.novare.recipe.util.PrintHandler;

public abstract class BaseView {
	private final Scanner scanner;

	public BaseView(String title) {
		this.scanner = new Scanner(System.in);
		PrintHandler.clearScreen();
		PrintHandler.appTitle();
		setTitle(title);
	}

	public abstract List<String> getMenuOptions();

	public abstract void printNavigationMenu();

	public void setTitle(String title) {
		System.out.println(title);
	}

	public void setMenuOptions(List<?> menuOptions) {
		PrintHandler.optionList(menuOptions);
		printNavigationMenu();

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
		printUserRequest();
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
		printMessage("");
		printMessage("Options:");
		printMessage("[C] Continue");
		printMessage("[Q] Quit");
		boolean wait = false;
		while (!wait) {
			String input = getUserTerminal().nextLine();
			wait = input.equalsIgnoreCase("C") || input.equalsIgnoreCase("Q");
			if (input.equalsIgnoreCase("Q")) {
				printMessage("BYE !");
				System.exit(0);
			}
		}

	}

	public int getUserInput() {
		String input = getUserTerminal().nextLine();
		try {
			int selection = Integer.parseInt(input);
			return selection;
		} catch (Exception exception) {
			printInvalidOption();
			printUserRequest();
			return getUserInput();
		}
	}

	public int getSelectedOptionFromMenu(int menuItems) {
		try {
			int selection = askUserToChooseIndexFromList();
			if (selection < 0 || selection > menuItems) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return selection;
		} catch (Exception exception) {
			printInvalidOption();
			return getSelectedOptionFromMenu(menuItems);
		}
	}
}
