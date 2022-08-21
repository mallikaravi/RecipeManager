package com.novare.recipe.execute;

import com.novare.recipe.controller.BaseController;
import com.novare.recipe.controller.MainController;

public class MainMenuAction extends BaseMenuAction {

	@Override
	public void execute() {
		BaseController controller = (BaseController) new MainController();
		controller.requestUserInput();
	}
}
