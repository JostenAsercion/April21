/**
 * 
 */
package com.smoothstack.weekone.daytwo;

/**
 * Rectangle class that implements the shape interface and overrides methods
 * 
 * @author Joa
 *
 */
public class Rectangle implements Shape {

	/*
	 * @param length the rectangle length
	 * 
	 * @param width the rectangle width
	 * 
	 * @param area the area of the rectangle
	 */
	int length;
	int width;
	int area;

	/*
	 * Default constructor
	 */
	Rectangle() {
		length = 0;
		width = 0;
	}

	/*
	 * Non-default constructor
	 */
	Rectangle(int l, int w) {
		length = l;
		width = w;
	}

	@Override
	public void calculateArea() {
		area = length * width;
	}

	@Override
	public void display() {
		System.out.println(area);
	}

}
