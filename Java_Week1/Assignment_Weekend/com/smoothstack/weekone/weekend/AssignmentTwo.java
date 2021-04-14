/**
 * 
 */
package com.smoothstack.weekone.weekend;

import java.util.Arrays;
import java.util.List;

/**
 * Week 1 Weekend. Given list of nonnegative integers, return an integer list of
 * the rightmost digits
 * 
 * @author Joa
 *
 */

public class AssignmentTwo {

	protected static List<Integer> rightmost(List<Integer> numList) {
		List<Integer> right = numList;

		// Every number % 10 returns rightmost digit in number
		right.replaceAll(n -> n % 10);

		return right;
	}

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(101, 112, 95, 44, 66, 117);
		System.out.println("Starting list:");
		numberList.forEach(i -> System.out.println(i));

		List<Integer> rightMostList = rightmost(numberList);
		System.out.println("\nRightmost digit list:");
		rightMostList.forEach(j -> System.out.println(j));
	}
}
