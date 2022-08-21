package com.novare.recipe.view;

public class DieticianView extends BaseView {
	public DieticianView() {
		super();
		System.out.println("Main menu options:");
	}

	public void printInvalidOption() {
		System.out.println("Invalid option");
	}

	public void printUserRequest() {
		System.out.print("Choose an option press enter: ");
	}
}
