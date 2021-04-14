package com.smoothstack.weekone.dayfive;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicLambdasTest {

	@Test
	public void testContainsEHelper() {
		String a = "Eeeeeeh";
		String b = "Mhmmmmm";
		String c = "Weeeeeh";

		assertEquals(-1, BasicLambdas.containsEHelper(a, b));
		assertEquals(1, BasicLambdas.containsEHelper(b, a));
		assertEquals(0, BasicLambdas.containsEHelper(a, c));
	}

}
