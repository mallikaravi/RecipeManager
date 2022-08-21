package com.novare.recipe.controller;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.form.MainForm;
import com.novare.recipe.service.IRecipeService;
import com.novare.recipe.view.MainView;

public class MainController extends BaseController {

	@SuppressWarnings("unused")
	private final IRecipeService model;

	public MainController(IRecipeService model, MainView view) {
		super(new MainForm(), view);
		this.model = model;
	}

	@Override
	public BaseForm requestUserInput() {
		BaseForm requestUserInput = super.requestUserInput();
		return requestUserInput;
	}

}
