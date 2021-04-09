/**
 * 
 */
package com.smoothstack.weekone.dayfour;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Week 1 Day 4 JUnit testing for Line class
 * 
 * @author Joa
 *
 */
public class LineTest {

	/**
	 * Test method for getSlope()
	 */
	@Test(expected = ArithmeticException.class)
	public void testGetSlope() {
		Line testLineA = new Line(0, 0, 5, 10);
		Line testLineB = new Line(0, 0, 0, 10);
		assertEquals(2, testLineA.getSlope(), .0001);
		testLineB.getSlope();
	}

	/**
	 * Test method for getDistance()
	 */
	@Test
	public void testGetDistance() {
		Line testLine = new Line(0, 0, 5, 12);
		assertEquals(13, testLine.getDistance(), .0001);
	}

	/**
	 * Test method for parallelTo()
	 */
	@Test
	public void testParallelTo() {
		Line testLineA = new Line(-5, -10, 0, 0);
		Line testLineB = new Line(0, 0, 10, 20);
		Line testLineC = new Line(0, 0, 1, 1);
		assertTrue(testLineA.parallelTo(testLineB));
		assertFalse(testLineB.parallelTo(testLineC));
	}

}
