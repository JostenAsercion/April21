package com.smoothstack.weekone.dayfive;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EvenOrOddTest {

	EvenOrOdd object = new EvenOrOdd();

	@Test
	public void generateStringTest() {
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		assertEquals("e0,o1,e2,o3,e4,o5,e6,o7,e8,o9", EvenOrOdd.generateString(nums));
	}

	@Test
	public void mainTest() {
		EvenOrOdd.main(null);
	}

}
