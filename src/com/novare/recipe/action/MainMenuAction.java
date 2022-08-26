package com.novare.recipe.action;

import com.novare.recipe.controller.MainController;
import com.novare.recipe.service.impl.MainServiceImpl;
import com.novare.recipe.view.MainView;

/**
 * This class extends BaseMenuAction class
 *
 */
public class MainMenuAction extends BaseMenuAction {

	/**
	 * This method instantiates the mainserviceimpl model, view,controller and
	 * model.Here We are passing model and view to the controller.
	 * 
	 * 
	 * @throws Exception
	 */
	public MainMenuAction() throws Exception {
		MainServiceImpl model = new MainServiceImpl();
		MainView view = new MainView("Main menu options:");
		MainController controller = new MainController(model, view);
		controller.requestUserInput(null);
	}
}
