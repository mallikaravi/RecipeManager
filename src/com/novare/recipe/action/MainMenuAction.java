package com.novare.recipe.action;

import com.novare.recipe.controller.MainController;
import com.novare.recipe.service.impl.MainServiceImpl;
import com.novare.recipe.view.MainView;

public class MainMenuAction extends BaseMenuAction {

	public MainMenuAction() throws Exception {
		MainServiceImpl model = new MainServiceImpl();
		MainView view = new MainView("Main menu options:");
		MainController controller = new MainController(model, view);
		controller.requestUserInput(null);
	}
}
