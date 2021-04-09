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
	@Test
	public void testGetSlope() {
		Line testLine = new Line(0, 0, 5, 10);
		assertEquals(2, testLine.getSlope(), 0);
	}

	/**
	 * Test method for getSlope() for dividing by zero
	 */
	@Test(expected = ArithmeticException.class)
	public void testGetSlopeDivideByZero() {
		Line testLine = new Line(0, 0, 0, 10);
		double temp = testLine.getSlope();
	}

	/**
	 * Test method for getDistance()
	 */
	@Test
	public void testGetDistance() {
		Line testLine = new Line(0, 0, 5, 12);
		assertEquals(13, testLine.getDistance(), 0);
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
