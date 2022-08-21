package com.novare.recipe.controller;

import java.util.Scanner;

import com.novare.recipe.service.IDieticianService;
import com.novare.recipe.view.DieticianView;

public class DieticianController {

	private final IDieticianService model;
	private final DieticianView view;
	private final Scanner scanner;

	public DieticianController(IDieticianService model, DieticianView view) {
		this.model = model;
		this.view = view;
		this.scanner = new Scanner(System.in);
	}
}
