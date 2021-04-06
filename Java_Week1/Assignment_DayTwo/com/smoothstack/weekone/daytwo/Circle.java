/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Circle class that implements the shape interface and overrides methods
 * 
 * @author Joa
 *
 */
public class Circle implements Shape {

	/*
	 * @param radius the circle radius
	 *  
	 * @param area the area of the circle
	 */
	int radius;
	int area;

	/*
	 * Default constructor
	 */
	Circle() {
		radius = 0;
	}

	/*
	 * Non-default constructor
	 */
	Circle(int r) {
		radius = r;
	}

	@Override
	public void calculateArea() {
		area = (int) (3.14 * Math.pow(radius, 2));
	}

	@Override
	public void display() {
		System.out.println(area);
	}

}
