/**
 * 
 */
package com.smoothstack.weekone.weekend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Week 1 Weekend. Lambdas.
 * 
 * @author Joa
 *
 */

//Functional interface

interface PerformOperation {
	boolean check(int a);
}

//Methods
class Methods {

	// Determines if number is odd
	PerformOperation isOdd() {
		return n -> n % 2 == 1;
	}

	// Determines if number is prime
	PerformOperation isPrime() {
		return n -> {
			if (n == 1)
				return false;
			// Checks if composite.
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		};
	}

	// Determine if input is a palindrome.
	PerformOperation isPalindrome() {
		return n -> {
			// Turn n into a String
			String string = String.valueOf(n);
			// Check if not palindrome. Compare outer and inner characters to see if any
			// don't match.
			for (int i = 0; i < string.length() / 2; i++) {
				if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
					return false;
				}
			}
			// If nothing was returned so far, it's a palindrome.
			return true;
		};
	}

	// Returns string representing the output of the number and operation
	String determinedAnswer(int choice, int num) {
		PerformOperation operation;
		String answer = "";
		if (choice == 1) {
			operation = isOdd();
			answer = (operation.check(num)) ? "ODD" : "EVEN";
		} else if (choice == 2) {
			operation = isPrime();
			answer = (operation.check(num)) ? "PRIME" : "COMPOSITE";
		} else if (choice == 3) {
			operation = isPalindrome();
			answer = (operation.check(num)) ? "PALINDROME" : "NOT PALINDROME";
		}
		return answer;
	}
}

//ENTER IN CONSOLE ONE LINE AT A TIME.
public class Lambdas {
	public static void main(String[] args) throws IOException {
		Methods m = new Methods();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int linesToRead = Integer.parseInt(br.readLine());
		while (linesToRead-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			System.out.println(m.determinedAnswer(ch, num));
		}
	}
}
