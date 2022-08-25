package com.novare.recipe.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.novare.recipe.model.DayPlan;
import com.novare.recipe.model.Recipe;
import com.novare.recipe.model.User;
import com.novare.recipe.model.WeekPlan;
import com.novare.recipe.service.IUserService;
import com.novare.recipe.util.DateUtil;
import com.novare.recipe.util.MenuContext;
import com.novare.recipe.view.UserView;

public class UserController extends BaseController {

	private final IUserService model;
	private final UserView view;

	public UserController(IUserService model, UserView view) {
		super(model, view);
		this.model = model;
		this.view = view;
	}

	public IUserService getModel() {
		return this.model;
	}

	public UserView getView() {
		return this.view;
	}

	@Override
	public void requestUserInput(MenuContext context) throws Exception {
		try {
			if (context == MenuContext.LIST_MY_WEEKS) {
				listMyWeeks();
				getModel().handleOption(0);

			} else if (context == MenuContext.VIEW_RECIPE) {
				viewSelectedRecipe();
				getModel().handleOption(0);

			} else if (context == MenuContext.VIEW_CURRENT_WEEK_RECIPIE) {
				viewCurrentWeekRecipies();
				getModel().handleOption(0);

			} else if (context == MenuContext.GENERATE_NEW_WEEK) {
				generateNewWeek();
				getModel().handleOption(0);
			} else {
				super.requestUserInput(context);
				String input = getUserTerminal().nextLine();
				int selectedOption = Integer.parseInt(input);
				getModel().handleOption(selectedOption);
			}
		} catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
			getView().printInvalidOption();
			requestUserInput(context);
		}
		getView().printUserRequest();

	}

	private void viewCurrentWeekRecipies() throws Exception {
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

	public void listMyWeeks() throws Exception {
		List<WeekPlan> allWeeks = getModel().getAllWeeks();
		getView().setMenuOptions(allWeeks);
		int selection = getView().askUserToChooseWeek();
		if (selection > allWeeks.size()) {
			throw new IndexOutOfBoundsException();
		}
		WeekPlan weekPlan = allWeeks.get(selection);
		displayDailyPlan(weekPlan.getDailyPlan());
	}

	private void displayDailyPlan(List<DayPlan> dailyPlan) {
		int selection;
		getView().setMenuOptions(dailyPlan);
		selection = getView().askUserToChooseDayPlan();
		if (selection > dailyPlan.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		DayPlan dayPlan = dailyPlan.get(selection);
		StringBuilder builder = new StringBuilder();
		builder.append("Name: " + dayPlan.getName()).append("\n").append("Recipes:" + dayPlan.getRecipe());
		builder.append("Ingredients: " + dayPlan.getRecipe().getIngredients());
		builder.append("\n");
		builder.append("Recipe Step:" + dayPlan.getRecipe().getSteps());
		getView().printMessage(builder.toString());
		getView().waitForDecision();
	}

	public void viewSelectedRecipe() throws Exception {
		List<Recipe> viewAllRecipes = viewAllRecipes();
		int selection = getView().askUserToChooseIndexFromList();
		if (selection > viewAllRecipes.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Recipe recipe = viewAllRecipes.get(selection - 1);
		StringBuilder builder = new StringBuilder();
		builder.append("Recipes:" + recipe);
		builder.append("Ingredients: " + recipe.getIngredients());
		builder.append("\n");
		builder.append("Recipe Step:" + recipe.getSteps());
		getView().printMessage(builder.toString());
		getView().waitForDecision();
	}

	private WeekPlan weekPlan = new WeekPlan();

	public void generateNewWeek() throws Exception {
		DayPlan dayPlan = new DayPlan();
		List<String> weekDays = new ArrayList<>();
		for (String day : DateUtil.getWeekDays()) {
			LocalDate date = DateUtil.toDateWithDay(day.replaceAll(" +", " "));
			String recipeStatus="**********";
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
		int selection = getView().askUserToChooseIndexFromList();
		if (selection > weekDays.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		String selectedDay = DateUtil.getWeekDays().get(selection-1);
		LocalDate selectedDate = DateUtil.toDateWithDay(selectedDay.replaceAll(" +", " "));
		dayPlan.setName(DateUtil.getDayString(selectedDate));
		dayPlan.setDate(DateUtil.toDate(selectedDate));
		getView().printMessage("Day Name: " + dayPlan.getName() + "\nDate: " + dayPlan.getDate());

		List<Recipe> viewAllRecipes = viewAllRecipes();
		selection = getView().askUserToChooseRecipe();
		if (selection > viewAllRecipes.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Recipe recipe = viewAllRecipes.get(selection - 1);
		dayPlan.setRecipe(recipe);
		weekPlan.addDailyPlan(dayPlan);
		boolean confirm = getView().askGenerateNewWeek();
		if (confirm) {
			generateNewWeek();
		} else {
			weekPlan.setWeekName("WEEK "+DateUtil.getWeekNumberNow());
			getModel().createRecipeWeek(weekPlan);
			getView().printSaveMessage();
			getView().waitForDecision();
		}
	}
}
