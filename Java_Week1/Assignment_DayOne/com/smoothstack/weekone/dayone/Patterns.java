/**
 * 
 */
package com.smoothstack.weekone.dayone;

/**
 * Class for printing various patterns for assignment 1
 * 
 * @author Joa
 *
 */
public class Patterns {

	/**
	 * Prints pattern one
	 */
	private void patternOne() {
		String currLine = "";
		String lastLine = "";
		for (int i = 0; i < 4; i++) {
			currLine = currLine + "*";
			lastLine = lastLine + "..";
			System.out.println(currLine);
		}
		System.out.println(lastLine + ".\n");
	}

	/**
	 * Prints pattern two
	 */
	private void patternTwo() {
		String firstLine = "";
		String currLine = "";

		for (int i = 0; i < 4; i++) {
			currLine = currLine + "*";
			firstLine = firstLine + "..";
		}

		System.out.println(firstLine + ".");

		for (int i = 4; i > 0; i--) {
			currLine = currLine.substring(0, i);
			System.out.println(currLine);
		}
		System.out.println();
	}

	/**
	 * Prints pattern three
	 */
	private void patternThree() {
		String middle = "*";
		String asterisks = "";
		String space = "     ";
		String lastLine = "";

		for (int i = 0; i < 4; i++) {
			System.out.println(space + asterisks + middle + asterisks + space);
			space = space.substring(0, space.length() - 1);
			asterisks = asterisks + "*";
			lastLine = lastLine + ".";
		}
		System.out.println(lastLine + "..." + lastLine + "\n");
	}

	/**
	 * Prints pattern four
	 */
	private void patternFour() {
		String firstLine = "";
		String middle = "*";
		String asterisks = "***";
		String space = "  ";

		for (int i = 0; i < 5; i++) {
			firstLine = firstLine + ".";
		}

		System.out.println(firstLine + "." + firstLine);
		System.out.println(space + asterisks + middle + asterisks + space);

		for (int i = 0; i < 3; i++) {
			space = space + " ";
			asterisks = asterisks.substring(0, asterisks.length() - 1);
			System.out.println(space + asterisks + middle + asterisks + space);
		}
	}

	/**
	 * Prints each pattern with number to identify
	 */
	public void printPatterns() {
		for (int i = 1; i <= 4; i++) {
			System.out.println(i + ")");

			switch (i) {
			case 1:
				patternOne();
				break;
			case 2:
				patternTwo();
				break;
			case 3:
				patternThree();
				break;
			case 4:
				patternFour();
				break;
			default:
				System.out.println("Error. Out of bounds.\n");
			}
		}
	}
}
