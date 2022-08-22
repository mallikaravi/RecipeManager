package com.novare.recipe.view;

public class DieticianView extends BaseView {
	public DieticianView() {
		super();
	}

	public void printMenuTitle(String title) {
		System.out.println(title);
	}

	public void printInvalidOption() {
		System.out.println("Invalid option");
	}

	public void printUserRequest() {
		System.out.print("Choose an option press enter: ");
	}

	public void askRecipeName() {
		System.out.print("Enter Recipe Name press enter: ");
	}

	public void askIngredients() {
		System.out.print("Choose an mulitple options press enter [e.g, 1,2]: ");
	}

}
