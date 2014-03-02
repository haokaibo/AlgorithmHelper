/**
 * 
 */
package com.effectivejava.classinterface;

/**
 * @author Kaibo
 * 
 */
public class Circle extends Figure {
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.effectivejava.classinterface.Figure#area()
	 */
	@Override
	double area() {
		return Math.PI * (radius * radius);
	}

}
