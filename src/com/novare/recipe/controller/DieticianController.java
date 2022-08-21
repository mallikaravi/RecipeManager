package com.novare.recipe.controller;

import com.novare.recipe.form.BaseForm;
import com.novare.recipe.form.DieticianForm;
import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController {

	private final IDieticianService model;

	public DieticianController(IDieticianService model, DieticianView view) {
		super(new DieticianForm(), view);
		this.model = model;
	}

	@Override
	public BaseForm requestUserInput() {
		BaseForm form = super.requestUserInput();
		return form;
	}
}
