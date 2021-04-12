/**
 * 
 */
package com.smoothstack.weekone.dayfive;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Scanner;

/**
 * Week 1 Day 5. Questions 5-7 of the assignment.
 * 
 * @author Joa
 *
 */
public class DateTimeAPI {

	// Question 5: Finds and prints the number of days for each month of a given
	// year
	private static void lengthOfMonths(Year year) {
		for (int i = 1; i <= 12; i++) {
			System.out.println(year.atMonth(i).getMonth() + ": " + year.atMonth(i).lengthOfMonth());
		}
	}

	// Question 6: Given a month of the current year, lists all Mondays in that
	// month
	private static void mondaysInMonth(YearMonth yearMonth) {
		System.out.println("The mondays in the month of " + yearMonth.getMonth() + ":");
		for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
			if (yearMonth.atDay(i).getDayOfWeek().getValue() == 1)
				System.out.println(yearMonth.getMonthValue() + "/" + i);
		}
	}

	// Question 7: Tests whether a given date occurs on Friday the 13th
	private static void ifFridayTheThirteenth(LocalDate date) {
		if (date.getDayOfWeek().getValue() == 5 && date.getDayOfMonth() == 13)
			System.out.println("This date occurs on Friday the 13th");
		else
			System.out.println("This date does not occur on Friday the 13th");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Question 5: Finds and prints the number of days for each month of a given
		// year
		System.out.println("#5 This method finds the length of each month given a year. \nEnter a year: ");
		Year year = Year.of(input.nextInt());
		lengthOfMonths(year);

		// Question 6: Given a month of the current year, lists all Mondays in that
		// month
		System.out.println(
				"\n#6 This method finds the Mondays of a given month in the current year. \nEnter a month #(1 for January, 12 for December): ");
		YearMonth yearMonth = YearMonth.of(Year.now().getValue(), Month.of(input.nextInt()));
		mondaysInMonth(yearMonth);

		// Question 7: Tests whether a given date occurs on Friday the 13th
		System.out.println("\n#7 This method checks if a certain date is Friday the 13th."
				+ "\nEnter a month#(1 for January, 12 for December):");
		int m = input.nextInt();
		System.out.println("Enter a day of the month (1-31):");
		int d = input.nextInt();
		System.out.println("Enter a year:");
		int y = input.nextInt();
		LocalDate date = LocalDate.of(y, m, d);
		ifFridayTheThirteenth(date);
		input.close();
	}
}
