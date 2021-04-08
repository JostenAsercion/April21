/**
 * 
 */
package com.smoothstack.weekone.daythree;

import java.io.File;
import java.util.Scanner;

/**
 * Week 1 Day 3 Get a list of all file/directory names under a given directory
 * 
 * @author Joa
 *
 */

public class ListAllFilesAndDirectories {

	/**
	 * @param args
	 * @param directoryString     the string entered by the user for choosing the
	 *                            directory
	 * @param directory           the directory to search through
	 * @param filesAndDirectories the list containing all files and directories in
	 *                            the given directory
	 */

	public static void main(String[] args) {
		String directoryString;
		String[] filesAndDirectories;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the directory path: ");
		directoryString = input.nextLine();
		try {
			File directory = new File(directoryString);
			filesAndDirectories = directory.list();
			for (String file : filesAndDirectories) {
				System.out.println(file);
			}
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception!");
		}
	}
}
