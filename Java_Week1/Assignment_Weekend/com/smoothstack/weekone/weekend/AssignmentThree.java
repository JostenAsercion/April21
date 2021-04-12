/**
 * 
 */
package com.smoothstack.weekone.weekend;

import java.util.Arrays;
import java.util.List;

/**
 * Week 1 Weekend. Given a list of integers, return a list where each integer is
 * multiplied by 2.
 * 
 * @author Joa
 *
 */
public class AssignmentThree {

	private static List<Integer> doubled(List<Integer> numList) {
		List<Integer> doubled = numList;

		// Multiplies each element by 2
		doubled.replaceAll(n -> n * 2);

		return doubled;
	}

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(101, 112, 95, 44, 66, 117);
		System.out.println("Starting list:");
		numberList.forEach(i -> System.out.println(i));

		List<Integer> doubled = doubled(numberList);
		System.out.println("\nMultiplied by 2 list:");
		doubled.forEach(j -> System.out.println(j));
	}

}
