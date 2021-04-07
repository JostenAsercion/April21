/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Triangle class that implements the shape interface and overrides methods
 * 
 * @author Joa
 *
 */
public class Triangle implements Shape {

	/**
	 * @param base   the triangle base
	 * 
	 * @param height the rectangle height
	 * 
	 * @param area   the area of the triangle
	 */
	int base;
	int height;
	int area;

	/*
	 * Default constructor
	 */
	Triangle() {
		base = 0;
		height = 0;
	}

	/*
	 * Non-default constructor
	 */
	Triangle(int b, int h) {
		base = b;
		height = h;
	}

	@Override
	public void calculateArea() {
		area = (int) (base * height) / 2;
	}

	@Override
	public void display() {
		System.out.println(area);
	}

}
