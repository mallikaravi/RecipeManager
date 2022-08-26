package com.novare.recipe.controller;

import com.novare.recipe.service.IRecipeService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.MainView;

/**
 * This class extends base controller class
 *
 */
public class MainController extends BaseController {

	public MainController(IRecipeService model, MainView view) {
		super(model, view);
	}

	/**
	 * This method is used for requesting user input.If the user selects an option
	 * out of range,we will get an exception
	 *
	 */
	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		super.requestUserInput(context);
		try {
			int selectedOption = getView().getUserInput();
			getModel().handleOption(selectedOption);
		} catch (NumberFormatException | IndexOutOfBoundsException exception) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context);
		}

	}

}
