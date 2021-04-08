/**
 * 
 */
package com.smoothstack.weekone.daythree;

import java.io.File;
import java.util.Scanner;

/**
 * Methods for use in ListAllFilesAndDirectoriesDriver
 * 
 * @author Joa
 *
 */

public class ListAllFilesAndDirectories {

	/**
	 * Recursively prints the directory and its contents to the console
	 * 
	 * @param directoryString     the string entered by the user for choosing the
	 *                            directory
	 * @param directory           the directory to search through
	 * @param filesAndDirectories the list containing all files and directories in
	 *                            the given directory
	 * @param directoryString     the string representing the directory to search
	 *                            through. supplied by user.
	 */
	public void printDirectory(String directoryString) {
		File[] filesAndDirectories;

		try {
			File directory = new File(directoryString);
			filesAndDirectories = directory.listFiles();
			for (int i = 0; i < filesAndDirectories.length; i++) {
				System.out.println(filesAndDirectories[i].getName());
				if (filesAndDirectories[i].isDirectory())
					printDirectory(filesAndDirectories[i].getAbsolutePath());

			}
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception!");
		}
	}
}
