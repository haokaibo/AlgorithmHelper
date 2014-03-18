/**
 * 
 */
package com.effectivejava.classinterface;

/**
 * @author Kaibo
 * 
 */
public class Circle extends Figure {
	
	/**
	 * specific fields.
	 */
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	/*
	 * common method
	 * 
	 * @see com.effectivejava.classinterface.Figure#area()
	 */
	@Override
	double area() {
		return Math.PI * (radius * radius);
	}

}
