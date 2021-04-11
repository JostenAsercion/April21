package com.smoothstack.weekone.dayfive;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class threeLetterStringTest {

	@Test
	public void testThreeLetterList() {
		List<String> startList = Arrays.asList("abc", "b12", "aim", "aaaa", "123");
		List<String> expectedList = Arrays.asList("abc", "aim");

		assertEquals(threeLetterString.threeLetterList(startList), expectedList);
	}

}
