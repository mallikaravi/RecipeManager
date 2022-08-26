package com.novare.recipe.view;

import java.util.List;

import com.novare.recipe.util.PrintHandler;

public class UserView extends BaseView {

	public UserView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("List Of My Weeks", "View Current Week Recipies", "View Recipies", "Generate New Week");
	}

	public void printNavigationMenu() {
		PrintHandler.optionBackToMainMenu();
	}

	public boolean askGenerateNewWeek() {
		System.out.print("Want to Generate a New week [Yes/No]:");
		return askConfirmationYesOrNo();
	}
}
