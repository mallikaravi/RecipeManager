package com.novare.recipe.action;

import com.novare.recipe.controller.DieticianController;
import com.novare.recipe.service.impl.DieticianServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

public class ViewRecipeMenuAction extends BaseMenuAction {

	@Override
	public void execute() throws Exception {

		DieticianServiceImpl model = new DieticianServiceImpl();
		DieticianView view = new DieticianView();
		DieticianController controller = new DieticianController(model, view);
		controller.requestUserInput(MenuContext.VIEW_RECIPE);

	}

}
