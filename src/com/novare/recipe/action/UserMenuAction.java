package com.novare.recipe.action;

import com.novare.recipe.controller.UserController;
import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.impl.UserServiceImpl;
import com.novare.recipe.view.UserView;

public class UserMenuAction extends BaseMenuAction {

	@Override
	public void execute() {

		UserServiceImpl model = new UserServiceImpl();
		UserView view = new UserView();
		UserController controller = new UserController(model, view);
		BaseForm returnData = controller.requestUserInput();
		returnData.getAction().execute();

	}

}
