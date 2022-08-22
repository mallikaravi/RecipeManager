package com.novare.recipe.controller;

import com.novare.recipe.service.IRecipeService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.MainView;

public class MainController extends BaseController {

	public MainController(IRecipeService model, MainView view) {
		super(model, view);
	}

	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		super.requestUserInput(context);

        String input = getUserTerminal().nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            getModel().handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            getView().printInvalidOption();
            getView().printUserRequest();
            requestUserInput(context);
        }
    
	}

}
