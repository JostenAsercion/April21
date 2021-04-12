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

//Methods that use lambdas
class Methods {

	boolean runCheck(PerformOperation p, int number) {
		return p.check(number);
	}

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
}

//ENTER IN CONSOLE ONE LINE AT A TIME.
public class Lambdas {
	public static void main(String[] args) throws IOException {
		PerformOperation operation;
		Methods m = new Methods();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int linesToRead = Integer.parseInt(br.readLine());
		boolean trueOrFalse = false;
		String answer = null;
		while (linesToRead-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (ch == 1) {
				operation = m.isOdd();
				trueOrFalse = m.runCheck(operation, num);
				answer = (trueOrFalse) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				operation = m.isPrime();
				trueOrFalse = m.runCheck(operation, num);
				answer = (trueOrFalse) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				operation = m.isPalindrome();
				trueOrFalse = m.runCheck(operation, num);
				answer = (trueOrFalse) ? "PALINDROME" : "NOT PALINDROME";
			}
			System.out.println(answer);
		}
	}
}
