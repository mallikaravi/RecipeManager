package com.novare.recipe.model;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RecipePool")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RecipePool implements Serializable {
	
	private ArrayList<Recipe> listOfRecipes = new ArrayList<>();

	public RecipePool(ArrayList<Recipe> listOfRecipes) {
		super();
		this.listOfRecipes = listOfRecipes;
	}

	@XmlElement
	public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

}
