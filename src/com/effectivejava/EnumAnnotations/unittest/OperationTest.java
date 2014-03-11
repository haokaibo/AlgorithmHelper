/**
 * 
 */
package com.effectivejava.EnumAnnotations.unittest;

import org.junit.Test;

import com.effectivejava.EnumAnnotations.Operation;

/**
 * @author Kaibo
 *
 */
public class OperationTest {

	/**
	 * Test method for {@link com.effectivejava.EnumAnnotations.Operation#Operation(java.lang.String)}.
	 */
	@Test
	public void testOperation() {
		double x = 1.0f;
		double y = 2.0f;
		for(Operation op : Operation.values()){
			System.out.printf("%f %s %f = %f%n", x, op , y , op.apply(x,y));
		}
	}

}
