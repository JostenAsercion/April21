/**
 * 
 */
package com.smoothstack.weekone.weekend;

import java.util.Arrays;
import java.util.List;

/**
 * Week 1 Weekend. Given a list of strings, return a list where each string has
 * all its "x" removed.
 * 
 * @author Joa
 *
 */

public class AssignmentFour {

	private static List<String> removeX(List<String> list) {
		List<String> noX = list;

		// Each x in each element is replaced with an empty string
		noX.replaceAll(n -> n.replace("x", ""));

		return noX;
	}

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("x", "axe", "maxing", "taxes", "auxillary", "x-wing", "the mox");
		System.out.println("Starting list:");
		stringList.forEach(i -> System.out.println(i));

		List<String> noXList = removeX(stringList);
		System.out.println("\nNo x list:");
		noXList.forEach(j -> System.out.println(j));
	}
}
