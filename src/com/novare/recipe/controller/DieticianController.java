package com.novare.recipe.controller;

import java.util.Scanner;

import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.util.PrintHandler;
import com.novare.recipe.view.DieticianView;

public class DieticianController extends BaseController{

	private final IDieticianService model;
	private final DieticianView view;
	private final Scanner scanner;

	public DieticianController(IDieticianService model, DieticianView view) {
		this.model = model;
		this.view = view;
		this.scanner = new Scanner(System.in);
	}

	public void requestUserInput() {
		String input = scanner.nextLine();
		try {
			int selectedOption = PrintHandler.readInput(input);
			model.handleOption(selectedOption);
		} catch (NumberFormatException exception) {
			view.printInvalidOption();
			view.printRequest();
			requestUserInput();
		}
	}
}
