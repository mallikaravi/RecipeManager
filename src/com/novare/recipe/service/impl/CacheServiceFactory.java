package com.novare.recipe.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.IngredientPool;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.RecipePool;
import com.novare.recipe.service.ICacheService;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class CacheServiceFactory implements ICacheService {

	@Override
	public List<Recipe> getAllRecipes() throws Exception {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RecipePool recipePool = (RecipePool) jaxbUnmarshaller.unmarshal(new File("RecipePool.xml"));
			return recipePool.getRecipes();
		} catch (JAXBException e) {
			throw new Exception();
		}
	}

	@Override
	public List<Ingredient> getAllIngredients() throws Exception {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(IngredientPool.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			IngredientPool ingredientPool = (IngredientPool) jaxbUnmarshaller.unmarshal(new File("Ingredients.xml"));
			return ingredientPool.getIngredients();
		} catch (JAXBException e) {
			throw new Exception();
		}
	}

}
