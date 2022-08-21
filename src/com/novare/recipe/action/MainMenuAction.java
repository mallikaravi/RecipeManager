package com.novare.recipe.action;

import com.novare.recipe.controller.MainController;
import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.impl.MainServiceImpl;
import com.novare.recipe.view.MainView;

public class MainMenuAction extends BaseMenuAction {

	@Override
	public void execute() {
		MainServiceImpl model = new MainServiceImpl();
		MainView view = new MainView();
		MainController controller = new MainController(model, view);
		BaseForm returnData = controller.requestUserInput();
		returnData.getAction().execute();
	}
}
