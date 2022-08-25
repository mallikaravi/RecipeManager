package com.novare.recipe.view;

public class UserView extends BaseView {

	public UserView() {
		super();
		System.out.println("Main menu options:");
	}

	public int askUserToChooseWeek() {
//		System.out.print("Choose a Week and press enter [e.g, 1]:");
		return askUserToChooseIndexFromList();
	}

	public int askUserToChooseDayPlan() {
//		System.out.print("Choose a day plan and press enter [e.g, 1]:");
		return askUserToChooseIndexFromList();
	}

	public boolean askGenerateNewWeek() {
		System.out.print("Want to Generate a New week [Yes/No]:");
		return askConfirmationYesOrNo();
	}
}
