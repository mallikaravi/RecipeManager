package com.novare.recipe.action;

import com.novare.recipe.controller.DieticianController;
import com.novare.recipe.service.impl.DieticianServiceImpl;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.DieticianView;

/**
 * This class extends BaseMenuAction Class
 *
 */
public class CreateRecipeMenuAction extends BaseMenuAction {

	/**
	 * This method throws an exception and it instantiates the DieticianServiceImpl
	 * model,Dieticianview and controller.Here we are calling requestuserInput method
	 * by passing enum createRecipe into it.
	 * 
	 * @throws Exception
	 */
	public CreateRecipeMenuAction() throws Exception {
		DieticianServiceImpl model = new DieticianServiceImpl();
		DieticianView view = new DieticianView("Create Recipe menu options:");
		DieticianController controller = new DieticianController(model, view);
		controller.requestUserInput(MenuContext.CREATE_RECIPE);
	}
}
