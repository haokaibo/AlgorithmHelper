/**
 * 
 */
package com.effectivejava.classinterface;

/**
 * @author Kaibo
 * 
 */
public class Rectangle extends Figure {
	// specific fields
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/*
	 * Common methods
	 * 
	 * @see com.effectivejava.classinterface.Figure#area()
	 */
	@Override
	double area() {
		return length * width;
	}

}
