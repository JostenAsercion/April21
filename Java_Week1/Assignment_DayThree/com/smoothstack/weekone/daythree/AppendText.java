/**
 * 
 */
package com.smoothstack.weekone.daythree;

import java.io.FileWriter;
import java.util.Scanner;

/**
 * Week 1 Day 3 Program to append text to an existing file
 * 
 * @author Joa
 *
 */
public class AppendText {

	/**
	 * @param args
	 * @param textToAppend the text that will be appended to the file
	 * @param fileOutput   file output stream for appending to the file
	 * @param input        scanner for user to type the text to append to the file
	 */
	public static void main(String[] args) {
		String textToAppend;
		try {
			FileWriter fWriter = new FileWriter(
					"Assignment_DayThree\\com\\smoothstack\\weekone\\daythree\\appendText.txt", true);
			Scanner input = new Scanner(System.in);

			System.out.println("Enter the text you would like to append to appendText.txt: ");
			textToAppend = input.nextLine();
			input.close();

			fWriter.write(textToAppend);
			fWriter.close();

		} catch (Exception e) {
			System.out.println("appendText.txt not found!");
		}
	}

}
