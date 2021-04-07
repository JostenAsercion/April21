/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Week 1 Day 2. Construct a 2D array and find the max number and show its
 * position in an array. Executed from TwoDimensionalArrayMaxDriver.java.
 * 
 * @author Joa
 *
 */
public class TwoDimensionalArrayMax {

	/**
	 * @param matrix the 2D array to find the max of
	 * @param max    the max number in the 2D array
	 * @param row    the row that contains the max value
	 * @param column the column that contains the max value
	 */
	int[][] matrix = new int[4][2];
	int max;
	int row;
	int column;

	/**
	 * Populates 4x2 2D array with random integers between 0 and 100 then prints it
	 * to the console
	 */
	public void populateArray() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = (int) (Math.random() * 100);
			}
			System.out.println("[" + matrix[i][0] + "][" + matrix[i][1] + "]");
		}
	}

	/**
	 * Finds the max value in the 2D array and prints the value to the console
	 */
	public void findMax() {
		max = matrix[0][0];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				if (max < matrix[i][j])
					max = matrix[i][j];
			}
		}
		System.out.println("The max is " + max);
	}

	/**
	 * Finds the location (row, column) of the max value. Rows range from 1 to 4.
	 * Columns range from 1 to 2. Prints the location to the console.
	 */
	public void findMaxLocation() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				if (max == matrix[i][j]) {
					row = i + 1;
					column = j + 1;
				}
			}
		}
		System.out.println("The location of the max is row " + row + " column " + column);
	}

}
