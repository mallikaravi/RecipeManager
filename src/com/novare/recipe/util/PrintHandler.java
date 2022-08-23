package com.novare.recipe.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PrintHandler {
	public static void appTitle() {
		System.out.println("** Welcome To Recipe Manager **");
		System.out.println(); // on purpose to make a space between the title
	}

	public static void optionBackToMainMenu() {
		System.out.println("[0] Quit");
	}

	public static void optionList(List<String> options) {
		for (int index = 0; index < options.size(); index++) {
			int number = index + 1;
			String label = options.get(index);

			System.out.println("[" + number + "] " + label);
		}
	}

	public static void optionListInRow(List<?> options) {
		for (int index = 0; index < options.size(); index++) {
			int number = index + 1;

			if (index % 4 == 0) {
				System.out.println();
			}
			String label = options.get(index).toString();
			System.out.format("[%-2d] %-40s ", number, label);
		}
		System.out.println();
	}

	/**
	 * Method to clear screen in the terminal.I have written a condition to clear
	 * the screen in all the operating systems.
	 * 
	 */
	public static void clearScreen() {

		try {
			String terminal = System.getenv("SHELL");
			if (terminal == null) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				throw new Exception("Found the shell terminal.");
			}
		} catch (Exception e) {
			String clearScreenASCIICode = "\033[H\033[2J";
			System.out.print(clearScreenASCIICode);
			System.out.flush();
		}
	}

	/**
	 * This method is to parse and convert the input string into Integer value,
	 * otherwise it will return -1 which is invalid option
	 * 
	 * @param userInput, user entered value in the terminal @return, integer value
	 */
	public static int readInput(String userInput) {
		try {
			return Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	/**
	 * Here message is displayed with symbols in desired format.I have used enums
	 * for printing various messages including signs.
	 * 
	 * @param icon
	 * @param message
	 */
	public static void log(String message) {
		try {
			PrintStream out = new PrintStream(System.out, true, "UTF-8");
			out.println(message);
		} catch (UnsupportedEncodingException e) {
		}
	}
}