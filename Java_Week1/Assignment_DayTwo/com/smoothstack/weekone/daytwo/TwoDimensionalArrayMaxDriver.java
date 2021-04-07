/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Week 1 Day 2. Construct a 2D array and find the max number and show its
 * position in an array. Uses methods from TwoDimensionalArrayMax.java.
 * 
 * @author Joa
 *
 */
public class TwoDimensionalArrayMaxDriver {

	/**
	 * @param matrix the 2D array to find the max of
	 * @param max    the max number in the 2D array
	 */
	static int[][] matrix = new int[4][2];
	int max;

	public static void main(String[] args) {
		TwoDimensionalArrayMax arrayMax = new TwoDimensionalArrayMax();
		arrayMax.populateArray();
		arrayMax.findMax();
		arrayMax.findMaxLocation();
	}

}
