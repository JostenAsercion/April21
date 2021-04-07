/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Week 1 Day 2 Adds values from command line and shows result of adding all of
 * them
 * 
 * @author Joa
 *
 */
public class AddValues {

	/**
	 * @param args the supplied numbers to add
	 * @param sum  the sum of the supplied numbers
	 */

	public static void main(String[] args) {
		int sum = 0;
		System.out.println("List of supplied numbers are: ");
		for (String s : args) {
			try {
				sum += Integer.parseInt(s);
				System.out.println(s);
			} catch (NumberFormatException e) {
				System.out.println("Oops. Something went wrong with this input!");
			}
		}
		System.out.println("The sum of these values is " + sum);
	}

}
