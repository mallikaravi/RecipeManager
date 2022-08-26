package com.novare.recipe.action;

import com.novare.recipe.controller.UserController;
import com.novare.recipe.service.impl.UserServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

/**
 * This class extends the base menu action class
 *
 */
public class GenerateNewWeekMenuAction extends BaseMenuAction {

	/**
	 * This method instantiates the user view,controller and model.This is the
	 * action of user that generates new week
	 * 
	 * @throws Exception
	 */
	public GenerateNewWeekMenuAction() throws Exception {
		UserServiceImpl model = new UserServiceImpl();
		UserView view = new UserView("Generate New Week menu options:");
		UserController controller = new UserController(model, view);
		controller.requestUserInput(MenuContext.GENERATE_NEW_WEEK);
	}

}
