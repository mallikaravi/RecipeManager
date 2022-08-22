package com.novare.recipe.form;

import java.util.List;

import com.novare.recipe.action.BaseMenuAction;
import com.novare.recipe.util.MenuContext;

public abstract class BaseForm {

	private BaseMenuAction action;
	private List<String> menuOptions;
	private Integer selectedOption;
	private MenuContext context;
	private String userInput;
	private String errorMessage;

	public BaseForm() {
		// TODO Auto-generated constructor stub
	}

	public BaseForm(BaseMenuAction action) {
		this.action = action;
	}

	public BaseMenuAction getAction() {
		return action;
	}

	public void setAction(BaseMenuAction action) {
		this.action = action;
	}

	public List<String> getMenuOptions() {
		return menuOptions;
	}

	public void setMenuOptions(List<String> menuOptions) {
		this.menuOptions = menuOptions;
	}

	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Integer getSelectedOption() {
		return selectedOption;
	}

	public void setContext(MenuContext context) {
		this.context = context;
	}

	public MenuContext getContext() {
		return context;
	}

	public BaseForm handleOption(int selectedOption) {
		return null;
	}

	/**
	 * @return the userInput
	 */
	public String getUserInput() {
		return userInput;
	}

	/**
	 * @param userInput the userInput to set
	 */
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
