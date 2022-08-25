package com.novare.recipe.service.impl;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import com.novare.recipe.action.GenerateNewWeekMenuAction;
import com.novare.recipe.action.ListOfMyWeeksMenuAction;
import com.novare.recipe.action.MainMenuAction;
import com.novare.recipe.action.ViewCurrentWeekRecipieMenuAction;
import com.novare.recipe.action.ViewRecipeMenuAction;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.RecipePool;
import com.novare.recipe.model.User;
import com.novare.recipe.model.WeekPlan;
import com.novare.recipe.service.IUserService;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * This is the UserServiceImpl class which implements IUserService interface.It
 * implements all the methods of the interface.
 *
 */
public class UserServiceImpl implements IUserService {

	@Override
	public Recipe viewRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getAllRecipes() throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(RecipePool.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		RecipePool recipePool = (RecipePool) jaxbUnmarshaller.unmarshal(Paths.get("RecipePool.xml").toFile());
		return recipePool.getRecipes();
	}

	@Override
	public List<Recipe> viewRecipeWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeekPlan createRecipeWeek(WeekPlan weeklyPlan) throws Exception {
		User user = getUser();
		user.addWeekPlan(weeklyPlan);

		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Marshal the Recipepool list in file
		jaxbMarshaller.marshal(user, Paths.get("UserPlan.xml").toFile());
		return weeklyPlan;
	}

	@Override
	public List<WeekPlan> getAllWeeks() throws Exception {
		User user = getUser();
		return user.getWeekPlan();
	}

	private User getUser() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		User user = (User) jaxbUnmarshaller.unmarshal(new File("UserPlan.xml"));
		return user;
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("List Of My Weeks", "View Current Week Recipies", "View Recipes", "Generate New Week");
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction().execute();
		}
		case 1 -> {
			new ListOfMyWeeksMenuAction().execute();
		}
		case 2 -> {
			new ViewCurrentWeekRecipieMenuAction().execute();
		}
		case 3 -> {
			new ViewRecipeMenuAction().execute();
		}
		case 4 -> {
			new GenerateNewWeekMenuAction().execute();
		}
		default -> throw new IndexOutOfBoundsException();
		}
	}

}
