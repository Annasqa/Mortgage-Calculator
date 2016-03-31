/**
 *   File Name: MortgageCalculator.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 28, 2016
 *
 */

package com.sqa.aa;

import java.util.*;

/**
 * MortgageCalculator //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */
public class MortgageCalculator {
	static double interest;
	static double monthlyPayment;
	static double monthlyRate;
	static double principle;
	static String propertyID;
	static Scanner scanner = new Scanner(System.in);
	static double termInMonths;
	static String userName;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		welcomeUserToApp();

		while (requestToContinue()) {
			requestValuesFromUser();
			calculatePayments();
			displayPayments();

		}
		farewellUser();

	}

	/**
	 *
	 */
	private static void calculatePayments() {
		// System.out.println("Calculate payments:\n-------------- ");

		monthlyRate = interest / 12;

		monthlyPayment = Math.round((principle * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths)));

	}

	/**
	 *
	 */
	private static void displayPayments() {
		// System.out.println("Display payments:\n-------------- ");
		System.out.println("Your monthly payments will be " + monthlyPayment + " per month for "
				+ Math.floor(termInMonths / 12) + " years and " + termInMonths % 12 + " months");

	}

	/**
	 *
	 */
	private static void farewellUser() {
		// System.out.println("Farewell user:\n-------------- ");
		System.out.println("Thank you " + userName + " for using the mortgage calculator application.");
		scanner.close();

	}

	/**
	 * @return
	 */
	private static boolean requestToContinue() {
		// System.out.println("Request to continue:\n-------------- ");
		while (true) {
			System.out.println("Would you like to calculate a nother mortgage?");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
				return true;

			} else if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")) {
				return false;

			} else {
				System.out.println("Invalid option (" + input + "), please use Yes/Y or No/N.");

			}
		}

	}

	/**
	 *
	 */
	private static void requestValuesFromUser() {
		// System.out.println("Request values from user:\n-------------- ");
		System.out.print("What is your property ID to calculate the mortgage for");
		String input = scanner.nextLine();
		propertyID = input;

		System.out.print("What is " + propertyID + "'s principle:");
		input = scanner.nextLine();
		principle = Double.parseDouble(input);

		System.out.print("What is " + propertyID + "'s interest:");
		input = scanner.nextLine();
		interest = Double.parseDouble(input);

		System.out.print("What is " + propertyID + "'s term in months:");
		input = scanner.nextLine();
		termInMonths = Double.parseDouble(input);

	}

	/**
	 *
	 */
	private static void welcomeUserToApp() {
		// System.out.println("Welcome user to app:\n-------------- ");
		System.out.println("Welcome user to Mortgadae Calculator Application");
		System.out.println("Hello, Could we please get your name?");
		userName = scanner.nextLine();
	}

}
