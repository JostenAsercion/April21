/**
 * 
 */
package com.smoothstack.weekone.dayone;

/**
 * Class for the guessing game for assignment 2
 * 
 * @author Joa
 * 
 */
import java.util.Scanner;

public class GuessingGame {

	/**
	 * @param number the generated number (1-100) to guess
	 * @param guess  the number guessed by the user
	 * @param tries  the number of tries the user has remaining
	 * @param input  the user input scanner
	 */
	int number;
	int guess;
	int tries = 5;
	Scanner input = new Scanner(System.in);

	/**
	 * Generates random number then asks user to guess. Continues until out of tries
	 * or if correct.
	 */
	public void StartGame() {
		number = (int) (Math.random() * 100) + 1;

		System.out.println("Guess a number between 1 and 100: ");
		guess = input.nextInt();
		while (tries > 1 && CheckGuessValid(guess)) {
			CheckGuess();
		}
		if (tries == 1)
			System.out.println("Sorry! The correct number was " + number);
	}

	/**
	 * Checks guess for validity
	 */
	private boolean CheckGuessValid(int g) {
		while (g < 1 || g > 100) {
			System.out.println("Guess is not between 1 and 100! Try again: ");
			g = input.nextInt();
		}
		guess = g;
		return true;
	}

	/**
	 * Checks guess for accuracy, asks to try again if wrong
	 */
	private void CheckGuess() {
		if (Math.abs(number - guess) <= 10) {
			System.out.println("Good job! The generated number was " + number);
			System.exit(0);
		} else {
			tries--;
			System.out.println("Not close enough! Tries remaining: " + tries + ". Try again: ");
			guess = input.nextInt();
		}
	}
}
