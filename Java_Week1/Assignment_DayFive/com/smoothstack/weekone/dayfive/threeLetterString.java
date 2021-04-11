/**
 * 
 */
package com.smoothstack.weekone.dayfive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Week 1 Day 5. Given a list of Strings, write a method that returns a list of
 * all strings that start with the letter 'a'(lower case) and have exactly 3
 * letters.
 * 
 * @author Joa
 *
 */
public class threeLetterString {

	protected static List<String> threeLetterList(List<String> list) {
		List<String> newList = null;

		// Filters Strings that start with 'a'
		newList = list.stream().filter(n -> n.charAt(0) == ('a')).collect(Collectors.toList());

		// Filters Strings that have only 3 characters
		newList = newList.stream().filter(n -> n.length() == 3).collect(Collectors.toList());

		return newList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> startList = Arrays.asList("a333", "b11", "c13", "abc", "A32", "a12", "a123", "aik");
		List<String> newList = threeLetterList(startList);

		newList.forEach(n -> System.out.println(n));
	}

}
