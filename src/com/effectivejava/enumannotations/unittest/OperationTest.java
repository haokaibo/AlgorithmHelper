/**
 * Test for 34 Emulate extensible enums with interfaces.
 */
package com.effectivejava.enumannotations.unittest;

import org.junit.Test;

import com.effectivejava.enumannotations.BaseOperation;
import com.effectivejava.enumannotations.ExtendedOperation;
import com.effectivejava.enumannotations.Operation;

/**
 * @author Kaibo
 *
 */
public class OperationTest {

	/**
	 * Test method for {@link com.effectivejava.enumannotations.BaseOperation#Operation(java.lang.String)}.
	 */
	@Test
	public void testOperation() {
		double x = 1.0f;
		double y = 2.0f;
		for(BaseOperation op : BaseOperation.values()){
			System.out.printf("%f %s %f = %f%n", x, op , y , op.apply(x,y));
		}
	}

	/**
	 * Test method for {@link com.effectivejava.EnumAnnotation.ExtendedOperation#Operation(java.lang.String)}}
	 */
	@Test
	public void testExtendedOperation(){
		double x = 3.0f;
		double y = 2.0f;
		Class<ExtendedOperation> opSet = ExtendedOperation.class;
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n",
			x, op, y, op.apply(x, y));
	}
}
