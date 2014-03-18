/**
 * 
 */
package com.effectivejava.enumAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kaibo
 * 
 */
public class Sample3 {
	// Code containing an annotation with an array parameter
	@MultiExceptionTest({ IndexOutOfBoundsException.class,
			NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}
}
