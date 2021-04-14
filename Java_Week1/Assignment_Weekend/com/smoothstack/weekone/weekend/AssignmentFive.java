/**
 * 
 */
package com.smoothstack.weekone.weekend;

import java.util.stream.IntStream;

/**
 * Week 1 Weekend. Given an array of ints, is it possible to choose a group of
 * some of the ints, such that the group sums to the given target, with this
 * additional constraint: if there are numbers in the array that are adjacent
 * and the identical value, they must either all be chosen, or none of them
 * chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's
 * in the middle must be chosen or not, all as a group. (one loop can be used to
 * find the extent of the identical values).
 * 
 * @author Joa
 *
 */
public class AssignmentFive {

	/*
	 * Choosing groups to not use subtracts the group value from the target. Is
	 * possible when the target becomes zero (the sum of the used groups reaches
	 * target).
	 */
	protected static boolean groupSumClump(int start, int[] nums, int target) {
		// When there are no more groups to process, if target has a remainder
		if (start >= nums.length)
			return target == 0;

		int startOfNextGroup = start;
		int groupSize = 0;

		// Finds start of the next group and finds the size of the current group
		while (startOfNextGroup < nums.length && nums[startOfNextGroup] == nums[start])
			startOfNextGroup++;
		groupSize = startOfNextGroup - start;

		// Do not use current group, try next group
		if (groupSumClump(startOfNextGroup, nums, target))
			return true;
		// Use current group, subtract value of current group from target
		if (groupSumClump(startOfNextGroup, nums, target - nums[start] * groupSize))
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 8 };
		System.out.println(groupSumClump(0, nums, 10));

		nums = IntStream.of(1, 2, 4, 8, 1).toArray();
		System.out.println(groupSumClump(0, nums, 14));

		nums = IntStream.of(2, 4, 4, 8).toArray();
		System.out.println(groupSumClump(0, nums, 14));
	}

}
