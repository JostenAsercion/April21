/**
 * 
 */
package com.smoothstack.weekone.dayfive;

import java.util.Arrays;

/**
 * Week 1 Day 5 Basic Lambdas
 * 
 * @author Joa
 *
 */
public class Lambdas {

	protected static int containsEHelper(String a, String b) {
		Integer aHasE;
		Integer bHasE;
		if (a.contains("e") || a.contains("E"))
			aHasE = 0;
		else
			aHasE = 1;

		if (b.contains("e") || b.contains("E"))
			bHasE = 0;
		else
			bHasE = 1;

		return aHasE - bHasE;

	}

	/**
	 * @param list The list of strings to sort
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = new String[] { "Ekko", "Samira", "Dr. Mundo", "Yasuo", "Tryndamere", "Garen" };

		// Sort by length (shortest to longest)
		Arrays.sort(list, (a, b) -> Integer.compare(a.length(), b.length()));
		System.out.println("Sorted by length (shortest to longest):");
		for (String i : list)
			System.out.println(i);

		// Sort by reverse length (longest to shortest)
		Arrays.sort(list, (a, b) -> Integer.compare(b.length(), a.length()));
		System.out.println("\nSorted by length (longest to shortest):");
		for (String i : list)
			System.out.println(i);

		// Sort alphabetically by first character only
		Arrays.sort(list, (a, b) -> Integer.compare(a.charAt(0), b.charAt(0)));
		System.out.println("\nSorted alphabetically by first character only:");
		for (String i : list)
			System.out.println(i);

		// Strings that contain "e" first, everything else second
		// If the string contains 'e' or 'E', value turns to 0, and otherwise 1
		Arrays.sort(list, (a, b) -> Integer.compare(a.contains("e") || a.contains("E") ? 0 : 1,
				b.contains("e") || b.contains("E") ? 0 : 1));
		System.out.println("\nStrings that contain \"e\" first, everything else second:");
		for (String i : list)
			System.out.println(i);

		// Strings that contain "e" first, everything else second
		// Uses static helper method
		Arrays.sort(list, (a, b) -> containsEHelper(a, b));
		System.out.println("\nStrings that contain \"e\" first, everything else second (using static helper):");
		for (String i : list)
			System.out.println(i);
	}

}
