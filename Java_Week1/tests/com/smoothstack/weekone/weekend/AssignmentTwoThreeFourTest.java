/**
 * 
 */
package com.smoothstack.weekone.weekend;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Joa
 *
 */
public class AssignmentTwoThreeFourTest {

	/**
	 * Test method for Assignment Two rightmost
	 */
	@Test
	public void testRightmost() {
		List<Integer> numList = Arrays.asList(123, 201, 4321, 422, 84);
		List<Integer> expected = Arrays.asList(3, 1, 1, 2, 4);
		assertEquals(AssignmentTwo.rightmost(numList), expected);
	}

	/**
	 * Test method for Assignment Three doubled
	 */
	@Test
	public void testDoubled() {
		List<Integer> numList = Arrays.asList(123, 201, 4321, 422, 84);
		List<Integer> expected = Arrays.asList(246, 402, 8642, 844, 168);
		assertEquals(AssignmentThree.doubled(numList), expected);
	}

	/**
	 * Test method for Assignment Four RemoveX
	 */
	@Test
	public void testRemoveX() {
		List<String> stringList = Arrays.asList("professor x", "x-wing", "xerath");
		List<String> expected = Arrays.asList("professor ", "-wing", "erath");
		assertEquals(AssignmentFour.removeX(stringList), expected);
	}
}
