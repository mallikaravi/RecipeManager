package com.novare.recipe.action;

import com.novare.recipe.controller.DieticianController;
import com.novare.recipe.form.BaseForm;
import com.novare.recipe.service.impl.DieticianServiceImpl;
import com.novare.recipe.view.DieticianView;

public class DieticianMenuAction extends BaseMenuAction {

	@Override
	public void execute() {

		DieticianServiceImpl model = new DieticianServiceImpl();
		DieticianView view = new DieticianView();
		DieticianController controller = new DieticianController(model, view);
		BaseForm returnData = controller.requestUserInput();
		returnData.getAction().execute();
	}

}
