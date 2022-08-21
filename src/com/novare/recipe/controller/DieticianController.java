package com.novare.recipe.controller;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.PrintHandler;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController {

	private final IDieticianService model;
	private final DieticianView view;

	public DieticianController(IDieticianService model, DieticianView view) {
		this.model = model;
		this.view = view;
	}

	public BaseForm requestUserInput() {
		view.setMenuOptions(model.getMenuOptions());
		String input = getUserTerminal().nextLine();
		try {
			int selectedOption = PrintHandler.readInput(input);
			return model.handleOption(selectedOption);
		} catch (NumberFormatException exception) {
			view.printInvalidOption();
			view.printRequest();
			return requestUserInput();
		}
	}
}
