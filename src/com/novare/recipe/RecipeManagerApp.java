package com.novare.recipe;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.model.User;
import com.novare.recipe.util.DateUtil;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class RecipeManagerApp {

	public static void main(String[] args) {
		try {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE yyyy-MM-dd");
			System.out.println(date.format(formatter));
			String text = date.format(formatter);
//			LocalDate parsedDate = LocalDate.parse("Tuesday   2022-08-23", formatter);
			System.out.println(date);
			System.out.println(DateUtil.toDateWithDay("Tuesday         2022-08-23".replaceAll(" +"," ")));
//			unMarshalingExample();
//			User user = unMarshalingExample();
//			IngredientPool ingredientPool = unMarshalingExample();
//			System.out.println(ingredientPool.getIngredients());
//			PrintHandler.optionListInRow(ingredientPool.getIngredients());
			new MainMenuAction().execute();
//			Recipe recipe = new Recipe();
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Please Enter Recipe Name:");
//			String input = scanner.nextLine();
//			recipe.setName(input);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private static void marshalingExample() throws JAXBException { RecipePool
	 * pool = new RecipePool(); List<Ingredient> ingredients = List.of(new
	 * Ingredient("ABX", Measurement.Kilogram.getMeasurement(), 2), new
	 * Ingredient("ABX", Measurement.Kilogram.getMeasurement(), 2));
	 * pool.addRecipe(new Recipe(1, "ABC", ingredients, "Steps"));
	 * pool.addRecipe(new Recipe(1, "ABC", ingredients, "Steps")); JAXBContext
	 * jaxbContext = JAXBContext.newInstance(RecipePool.class); Marshaller
	 * jaxbMarshaller = jaxbContext.createMarshaller();
	 * 
	 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 * 
	 * // Marshal the Recipepool list in file jaxbMarshaller.marshal(pool, new
	 * File("RecipePool.xml")); }
	 */

	/*
	 * private static RecipePool unMarshalingExample() throws JAXBException {
	 * JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
	 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 * 
	 * // We had written this file in marshalling example RecipePool pool =
	 * (RecipePool) jaxbUnmarshaller.unmarshal(new File("RecipePool.xml"));
	 * 
	 * for (Recipe recipe : pool.getRecipes()) { System.out.println(recipe.getId());
	 * System.out.println(recipe.getIngredients()); } return pool; }
	 */

	/*
	 * private static IngredientPool unMarshalingExample() throws JAXBException {
	 * JAXBContext jaxbContext = JAXBContext.newInstance(IngredientPool.class);
	 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 * 
	 * // We had written this file in marshalling example IngredientPool
	 * ingredientPool = (IngredientPool) jaxbUnmarshaller.unmarshal(new
	 * File("ingredients.xml"));
	 * 
	 * // for (Ingredient ingredient : ingredientPool.getIngredients()) { //
	 * System.out.println(ingredient.getName()); //
	 * System.out.println(ingredient.getMeasurement()); //
	 * System.out.println(ingredient.getAmount()); // } return ingredientPool;
	 * 
	 * }
	 */

	/*
	 * private static void marshalingExample() throws JAXBException { List<DayPlan>
	 * dayplan = List .of(new DayPlan( "Monday", new Date(), List .of(new Recipe(1,
	 * "ABC", List.of(new Ingredient("ABX", Measurement.Kilogram.getMeasurement(),
	 * 2), new Ingredient("ABX", Measurement.Kilogram.getMeasurement(), 2)),
	 * "Steps")))); User user2 = new User(1, "XYZ", List.of(new WeekPlan("WEEK 21",
	 * dayplan)));
	 * 
	 * JAXBContext jaxbContext = JAXBContext.newInstance(User.class); Marshaller
	 * jaxbMarshaller = jaxbContext.createMarshaller();
	 * 
	 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 * 
	 * // Marshal the Recipepool list in file jaxbMarshaller.marshal(user2, new
	 * File("UserPlan.xml")); }
	 */

	private static User unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		User user = (User) jaxbUnmarshaller.unmarshal(new File("UserPlan.xml"));

		return user;
	}

}
