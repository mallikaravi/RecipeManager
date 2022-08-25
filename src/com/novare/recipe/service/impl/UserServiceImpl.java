package com.novare.recipe.service.impl;

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
import com.novare.recipe.util.ServiceUtil;

import jakarta.xml.bind.JAXBException;

/**
 * This is the UserServiceImpl class which implements IUserService interface.It
 * implements all the methods of the interface.
 *
 */
public class UserServiceImpl implements IUserService {

	@Override
	public List<Recipe> getAllRecipes() throws Exception {
		RecipePool recipePool = (RecipePool) ServiceUtil.getUnmarshaller(RecipePool.class)
				.unmarshal(Paths.get("assets/RecipePool.xml").toFile());
		return recipePool.getRecipes();
	}

	@Override
	public WeekPlan createRecipeWeek(WeekPlan weeklyPlan) throws Exception {
		User user = getUser();
		user.addWeekPlan(weeklyPlan);

		ServiceUtil.getMarshaller(User.class).marshal(user, Paths.get("assets/UserPlan.xml").toFile());
		return weeklyPlan;
	}

	@Override
	public List<WeekPlan> getAllWeeks() throws Exception {
		User user = getUser();
		return user.getWeeklyPlan();
	}

	private User getUser() throws JAXBException {
		User user = (User) ServiceUtil.getUnmarshaller(User.class)
				.unmarshal(Paths.get(("assets/UserPlan.xml")).toFile());
		return user;
	}

	@Override
	public void handleOption(int selectedOption) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction();
		}
		case 1 -> {
			new ListOfMyWeeksMenuAction();
		}
		case 2 -> {
			new ViewCurrentWeekRecipieMenuAction();
		}
		case 3 -> {
			new ViewRecipeMenuAction();
		}
		case 4 -> {
			new GenerateNewWeekMenuAction();
		}
		default -> throw new IndexOutOfBoundsException();
		}
	}

}
