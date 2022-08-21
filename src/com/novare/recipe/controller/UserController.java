package com.novare.recipe.controller;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.form.UserForm;
import com.novare.recipe.service.IUserService;
import com.novare.recipe.view.UserView;

public class UserController extends BaseController {

	private final IUserService model;

	public UserController(IUserService model, UserView view) {
		super(new UserForm(), view);
		this.model = model;
	}

	@Override
	public BaseForm requestUserInput() {
		BaseForm form = super.requestUserInput();
		return form;
	}

}
