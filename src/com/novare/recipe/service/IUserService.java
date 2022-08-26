/**
 * 
 */
package com.novare.recipe.service;

import java.util.List;

import com.novare.recipe.model.WeekPlan;

/**
 * This is the interface of the User.It has all the actions that user performs
 * in this application
 *
 */
public interface IUserService extends IRecipeService {

	/**
	 * This is the method to generate the recipes of the week
	 * 
	 * @return-List of recipes
	 */
	WeekPlan  createRecipeWeek(WeekPlan weeklyPlan) throws Exception;
	
	/**
	 * @This method is used to display all the weeks in the application
	 * @throws Exception
	 */
	List<WeekPlan> getAllWeeks()throws Exception;

}
