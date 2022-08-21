package com.novare.recipe.model;

import java.util.ArrayList;

public class RecipePool {
    private ArrayList<Recipe> listOfRecipes = new ArrayList<>();

	public RecipePool(ArrayList<Recipe> listOfRecipes) {
		super();
		this.listOfRecipes = listOfRecipes;
	}

	public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}
    

}
