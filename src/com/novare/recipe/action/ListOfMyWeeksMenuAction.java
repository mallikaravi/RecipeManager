package com.novare.recipe.action;

import com.novare.recipe.controller.UserController;
import com.novare.recipe.service.impl.UserServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

public class ListOfMyWeeksMenuAction extends BaseMenuAction {

	public ListOfMyWeeksMenuAction() throws Exception {
		UserServiceImpl model = new UserServiceImpl();
		UserView view = new UserView("List of my weeks menu options:");
		UserController controller = new UserController(model, view);
		controller.requestUserInput(MenuContext.LIST_MY_WEEKS);

	}

}
