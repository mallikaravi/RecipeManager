package com.novare.recipe.controller;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.IUserService;
import com.novare.recipe.view.UserView;

public class UserController extends BaseController {

	private final IUserService model;
	private final UserView view;

	public UserController(IUserService model, UserView view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public BaseForm requestUserInput() {
		view.setMenuOptions(model.getMenuOptions());
		String input = getUserTerminal().nextLine();
		try {
			int selectedOption = Integer.parseInt(input);
			return model.handleOption(selectedOption);
		} catch (NumberFormatException | IndexOutOfBoundsException exception) {
			view.printInvalidOption();
			view.printRequest();
			return requestUserInput();
		}
	}

}
