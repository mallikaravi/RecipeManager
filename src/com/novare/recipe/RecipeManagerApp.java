package com.novare.recipe;

import java.io.File;
import java.util.List;

import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.model.Ingredient;
import com.novare.recipe.model.Measurement;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.RecipePool;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class RecipeManagerApp {

	public static void main(String[] args) {
		try {
//			marshalingExample();
//			unMarshalingExample();
			new MainMenuAction().execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void marshalingExample() throws JAXBException {
		RecipePool pool = new RecipePool();
		List<Ingredient> ingredients = List.of(new Ingredient("ABX", Measurement.Kilogram.getMeasurement(), 2),
				new Ingredient("ABX", Measurement.Kilogram.getMeasurement(), 2));
		pool.addRecipe(new Recipe(1, "ABC", ingredients, "Steps"));
		pool.addRecipe(new Recipe(1, "ABC", ingredients, "Steps"));
		JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Marshal the employees list in file
		jaxbMarshaller.marshal(pool, new File("RecipePool.xml"));
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		// We had written this file in marshalling example
		RecipePool pool = (RecipePool) jaxbUnmarshaller.unmarshal(new File("RecipePool.xml"));

		for (Recipe recipe : pool.getRecipes()) {
			System.out.println(recipe.getId());
			System.out.println(recipe.getIngredients());
		}
	}
}
