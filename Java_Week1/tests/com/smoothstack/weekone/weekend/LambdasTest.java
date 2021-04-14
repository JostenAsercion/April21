package com.smoothstack.weekone.weekend;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdasTest {

	Methods m = new Methods();

	@Test
	public void isOddTest() {
		int temp = 1;
		assertTrue(m.isOdd().check(temp));

		temp = 2;
		assertFalse(m.isOdd().check(temp));
	}

	@Test
	public void isPrimeTest() {
		int temp = 29;
		assertTrue(m.isPrime().check(temp));

		temp = 35;
		assertFalse(m.isPrime().check(temp));
	}

	@Test
	public void isPalindromeTest() {
		int temp = 1234321;
		assertTrue(m.isPalindrome().check(temp));

		temp = 1234567;
		assertFalse(m.isPalindrome().check(temp));
	}

	@Test
	public void determineAnswerTest() {
		assertEquals(m.determinedAnswer(1, 3), "ODD");
		assertEquals(m.determinedAnswer(1, 24), "EVEN");
		assertEquals(m.determinedAnswer(2, 19), "PRIME");
		assertEquals(m.determinedAnswer(2, 20), "COMPOSITE");
		assertEquals(m.determinedAnswer(3, 12321), "PALINDROME");
		assertEquals(m.determinedAnswer(3, 12345), "NOT PALINDROME");
	}
}
