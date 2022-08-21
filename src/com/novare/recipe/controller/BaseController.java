package com.novare.recipe.controller;

import java.util.Scanner;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.view.BaseView;

public abstract class BaseController {
	private final Scanner scanner;
	private final BaseForm form;
	private final BaseView view;

	public BaseController(BaseForm form, BaseView view) {
		this.scanner = new Scanner(System.in);
		this.form = form;
		this.view = view;
	}

	protected Scanner getUserTerminal() {
		return scanner;
	}

	public BaseForm requestUserInput() {
		view.setMenuOptions(form.getMenuOptions());
		String input = getUserTerminal().nextLine();
		try {
			int selectedOption = Integer.parseInt(input);
			return form.handleOption(selectedOption);
		} catch (NumberFormatException | IndexOutOfBoundsException exception) {
			view.printInvalidOption();
			view.printUserRequest();
			return requestUserInput();
		}

	}
}
