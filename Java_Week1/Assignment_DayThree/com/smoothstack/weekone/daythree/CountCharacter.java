/**
 * 
 */
package com.smoothstack.weekone.daythree;

import java.util.Scanner;

/**
 * Week 1 Day 3 Counts the number of times a particular character appears in a
 * file
 * 
 * @author Joa
 *
 */
public class CountCharacter {

	/**
	 * @param args
	 * @param character   the character determined by the user to count
	 * @param inputString the string read from the scanner to be converted to a char
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char character;
		Scanner input = new Scanner(System.in);
		String inputString;
		input.close();

		System.out.println("Enter the character you want to check for: ");
		inputString = input.nextLine();
		try {
			character = inputString.charAt(0);
			System.out.println("You chose to check for character '" + character + "'");
		} catch (Exception e) {
			System.out.println("Could not detect requested char from input!");
		}

	}

}
