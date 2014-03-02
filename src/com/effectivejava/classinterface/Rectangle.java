/**
 * 
 */
package com.effectivejava.classinterface;

/**
 * @author Kaibo
 * 
 */
public class Rectangle extends Figure {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.effectivejava.classinterface.Figure#area()
	 */
	@Override
	double area() {
		return length * width;
	}

}
