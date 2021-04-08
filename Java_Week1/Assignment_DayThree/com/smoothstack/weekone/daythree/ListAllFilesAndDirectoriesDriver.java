/**
 * 
 */
package com.smoothstack.weekone.daythree;

import java.util.Scanner;

/**
 * Week 1 Day 3 Get a list of all file/directory names under a given directory.
 * Uses Methods from ListAllFilesAndDirectories.java.
 * 
 * @author Joa
 *
 */

public class ListAllFilesAndDirectoriesDriver {

	/**
	 * @param args
	 * @param directoryString the string entered by the user for choosing the
	 *                        directory
	 */

	public static void main(String[] args) {
		String directoryString;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the directory path: ");
		directoryString = input.nextLine();
		input.close();

		ListAllFilesAndDirectories lister = new ListAllFilesAndDirectories();
		lister.printDirectory(directoryString);
	}
}
