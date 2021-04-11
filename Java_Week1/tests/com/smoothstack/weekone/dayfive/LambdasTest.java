package com.smoothstack.weekone.dayfive;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdasTest {

	@Test
	public void testContainsEHelper() {
		String a = "Eeeeeeh";
		String b = "Mhmmmmm";
		String c = "Weeeeeh";

		assertEquals(-1, Lambdas.containsEHelper(a, b));
		assertEquals(1, Lambdas.containsEHelper(b, a));
		assertEquals(0, Lambdas.containsEHelper(a, c));
	}

}
