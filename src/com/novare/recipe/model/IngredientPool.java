package com.novare.recipe.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="IngredientPool")
@XmlAccessorType(XmlAccessType.FIELD)
public class IngredientPool {
	
	
	@XmlElement(name="Ingredient")
	private List<Ingredient> ingredientPool=new ArrayList<>();

	public IngredientPool() {
	}

	public List<Ingredient> getIngredients() {
		return ingredientPool;
	}

	public void addIngredient(Ingredient ingredient) {
		this.ingredientPool.add(ingredient);
	}

	@Override
	public String toString() {
		return "IngredientPool [ingredientPool=" + ingredientPool + "]";
	}
	

	
	
	

}
