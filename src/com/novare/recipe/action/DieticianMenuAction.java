package com.novare.recipe.action;

import com.novare.recipe.controller.DieticianController;
import com.novare.recipe.service.impl.DieticianServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

/**
 * This is a DieticianMenuAction class which extends BaseMenuAction class
 *
 */
public class DieticianMenuAction extends BaseMenuAction {

	/**
	 * This method instantiate the dietician model,controller and view.It prints
	 * the dietician menu actions
	 * 
	 * @throws Exception
	 */
	public DieticianMenuAction() throws Exception {
		DieticianServiceImpl model = new DieticianServiceImpl();
		DieticianView view = new DieticianView("Dietician menu options:");
		DieticianController controller = new DieticianController(model, view);
		controller.requestUserInput(MenuContext.DIETICIAN);

	}

}
