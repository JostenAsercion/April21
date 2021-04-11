/**
 * 
 */
package com.smoothstack.weekone.dayfive;

import java.util.Arrays;
import java.util.List;

/**
 * Week 1 Day 5 Use Java 8 features to make a list of ints into a modified
 * string
 * 
 * @author Joa
 *
 */
public class EvenOrOdd {

	static String numberString = "";

	protected static String generateString(List<Integer> nums) {

		nums.forEach(n -> {
			if (n % 2 == 0)
				numberString += "e" + n + ",";
			else if (n % 2 == 1)
				numberString += "o" + n + ",";
		});

		// Removes the last comma from the string
		numberString = numberString.substring(0, numberString.length() - 1);

		return numberString;
	}
	/*
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(4242, 8561, 7, 7896, 327183, 123, 421);
		System.out.println(generateString(numbers));
	}
}
