package com.novare.recipe.view;

public class UserView extends BaseView {

	public UserView() {
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
