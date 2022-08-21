package com.novare.recipe.controller;

import java.util.Scanner;

import com.novare.recipe.form.BaseForm;

public abstract class BaseController {
	private final Scanner scanner;

	public BaseController() {
		this.scanner = new Scanner(System.in);
	}

	protected Scanner getUserTerminal() {
		return scanner;
	}

	public abstract BaseForm requestUserInput();
}
