package com.novare.recipe.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.novare.recipe.model.DayPlan;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.WeekPlan;
import com.novare.recipe.service.IUserService;
import com.novare.recipe.util.DateUtil;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

/**
 * This class extends base controller class
 *
 */
/**
 * @author malli
 *
 */
/**
 * @author malli
 *
 */
public class UserController extends BaseController {

	private final WeekPlan weekPlan;

	public UserController(IUserService model, UserView view) {
		super(model, view);
		this.weekPlan = new WeekPlan();
	}

	public IUserService getModel() {
		return (IUserService) super.getModel();
	}

	public UserView getView() {
		return (UserView) super.getView();
	}

	/**
	 * this method is used to display all the options of the user
	 *
	 */
	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		try {
			int selectedOption = 0;
			switch (context) {
			case LIST_MY_WEEKS -> displayMyWeeks();
			case VIEW_RECIPE -> displaySelectedRecipe();
			case VIEW_CURRENT_WEEK_RECIPIE -> displayCurrentWeekRecipies();
			case GENERATE_NEW_WEEK -> generateNewWeek();
			default -> {
				super.requestUserInput(context);
				selectedOption = getView().getUserInput();
			}
			}
			getModel().handleOption(selectedOption);
		} catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context);
		}

	}

	/**
	 * this method displays the current Week recipies
	 * @throws Exception
	 */
	private void displayCurrentWeekRecipies() throws Exception {
		int currentWeek = DateUtil.getWeekNumberNow();
		List<WeekPlan> allWeeks = getModel().getAllWeeks();
		for (WeekPlan weekPlan : allWeeks) {
			if (weekPlan.getWeekName().contains("WEEK " + currentWeek)) {
				List<DayPlan> dailyPlan = weekPlan.getDailyPlan();
				for (DayPlan dayPlan : dailyPlan) {
					String today = DateUtil.getDayString(LocalDate.now());
					if (dayPlan.getName().contains(today)) {
						dayPlan.setName("Today **");
					}
				}
				displayDailyPlan(dailyPlan);
				break;
			}
		}
	}

	/**
	 * this displays all the weeks in the recipe pool
	 * @throws Exception
	 */
	private void displayMyWeeks() throws Exception {
		List<WeekPlan> allWeeks = getModel().getAllWeeks();
		getView().setMenuOptions(allWeeks);
		int selection = getView().getSelectedOptionFromMenu(allWeeks.size());
		gotoMainMenu(selection);
		WeekPlan weekPlan = allWeeks.get(selection-1);
		displayDailyPlan(weekPlan.getDailyPlan());
	}

	/**
	 * This is used to display daily plan
	 * @param dailyPlan
	 * @throws Exception
	 */
	private void displayDailyPlan(List<DayPlan> dailyPlan) throws Exception {
		getView().setMenuOptions(dailyPlan);
		int selection = getView().getSelectedOptionFromMenu(dailyPlan.size());
		gotoMainMenu(selection);
		DayPlan dayPlan = dailyPlan.get(selection-1);
		StringBuilder builder = new StringBuilder();
		builder.append("Name: " + dayPlan.getName()).append("\n").append("Recipes:" + dayPlan.getRecipe());
		builder.append("\n");
		builder.append("Ingredients: " + dayPlan.getRecipe().getIngredients());
		builder.append("\n");
		builder.append("Steps:\n" + dayPlan.getRecipe().getSteps());
		getView().printMessage(builder.toString());
		getView().waitForDecision();
	}

	/**
	 * This method is used to display the selected recipe
	 * @throws Exception
	 */
	private void displaySelectedRecipe() throws Exception {
		List<Recipe> viewAllRecipes = displayAllRecipes();
		int selection = getView().getSelectedOptionFromMenu(viewAllRecipes.size());
		gotoMainMenu(selection);
		Recipe recipe = viewAllRecipes.get(selection - 1);
		StringBuilder builder = new StringBuilder();
		builder.append("Recipes: " + recipe);
		builder.append("\n");
		builder.append("Ingredients:  " + recipe.getIngredients());
		builder.append("\n");
		builder.append("Step:\n" + recipe.getSteps());
		getView().printMessage(builder.toString());
		getView().waitForDecision();
	}

	/**
	 * This method is used to generate a new week.
	 * @throws Exception
	 */
	private void generateNewWeek() throws Exception {
		DayPlan dayPlan = new DayPlan();
		List<String> weekDays = new ArrayList<>();
		for (String day : DateUtil.getWeekDays()) {
			LocalDate date = DateUtil.toDateWithDay(day.replaceAll(" +", " "));
			String recipeStatus = "**********";
			for (DayPlan plan : weekPlan.getDailyPlan()) {
				if (plan.getName().contains(DateUtil.getDayString(date))) {
					recipeStatus = plan.getRecipe().toString();
					break;
				}
			}
			day += String.format("%25s", recipeStatus);
			weekDays.add(day);
		}
		getView().setMenuOptions(weekDays);
		int selection = getView().getSelectedOptionFromMenu(weekDays.size());
		gotoMainMenu(selection);
		String selectedDay = DateUtil.getWeekDays().get(selection - 1);
		LocalDate selectedDate = DateUtil.toDateWithDay(selectedDay.replaceAll(" +", " "));
		dayPlan.setName(DateUtil.getDayString(selectedDate));
		dayPlan.setDate(DateUtil.toDate(selectedDate));
		getView().printMessage("Day Name: " + dayPlan.getName() + "\nDate: " + dayPlan.getDate());

		List<Recipe> viewAllRecipes = displayAllRecipes();
		selection = getView().getSelectedOptionFromMenu(viewAllRecipes.size());
		gotoMainMenu(selection);

		Recipe recipe = viewAllRecipes.get(selection - 1);
		dayPlan.setRecipe(recipe);
		weekPlan.addDailyPlan(dayPlan);
		boolean confirm = getView().askGenerateNewWeek();
		if (confirm) {
			generateNewWeek();
		} else {
			weekPlan.setWeekName("WEEK " + DateUtil.getWeekNumberNow());
			getModel().createRecipeWeek(weekPlan);
			getView().printSaveMessage();
			getView().waitForDecision();
		}
	}
}
