package com.novare.recipe.controller;

import com.novare.recipe.service.IUserService;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

public class UserController extends BaseController {

	private final IUserService model;

	public UserController(IUserService model, UserView view) {
		super(model, view);
		this.model = model;
	}

	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		super.requestUserInput(context);
	}

}
