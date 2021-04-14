/**
 * 
 */
package com.smoothstack.weekone.weekend;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * @author Joa
 *
 */
public class AssignmentFiveTest {

	/**
	 * Test method for groupSumClump
	 */
	@Test
	public void testGroupSumClump() {
		int[] nums = { 2, 4, 8 };
		assertTrue(AssignmentFive.groupSumClump(0, nums, 10));

		nums = IntStream.of(1, 2, 4, 8, 1).toArray();
		assertTrue(AssignmentFive.groupSumClump(0, nums, 14));

		nums = IntStream.of(2, 4, 4, 8).toArray();
		assertFalse(AssignmentFive.groupSumClump(0, nums, 14));
	}

}
