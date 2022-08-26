package com.novare.recipe.action;

import com.novare.recipe.controller.UserController;
import com.novare.recipe.service.impl.UserServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

/**
 * This class extends BaseMenuAction class
 *
 */
public class ListOfMyWeeksMenuAction extends BaseMenuAction {

	/**
	 * This method instantiates the user view,controller and model.This is the
	 * action of user that prints list of my weeks.
	 * 
	 * @throws Exception
	 */
	public ListOfMyWeeksMenuAction() throws Exception {
		UserServiceImpl model = new UserServiceImpl();
		UserView view = new UserView("List of my weeks menu options:");
		UserController controller = new UserController(model, view);
		controller.requestUserInput(MenuContext.LIST_MY_WEEKS);

	}

}
