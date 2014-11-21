/**
 * 
 */
package com.algorithmHelper.unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algorithmHelper.BitOperator;

/**
 * @author Kaibo
 * 
 */
public class BitOperatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.algorithmHelper.BitOperator#clearBitsIthgrough0(int, int)}.
	 */
	@Test
	public void testClearBitsIthgrough0() {
		int num = 1;
		int i = 2;
		int expectedResult = 0;
		int actual = BitOperator.clearBitsIthgrough0(num, i);
		assertEquals(expectedResult, actual);
	}

	/**
	 * Test method for
	 * {@link com.algorithmHelper.BitOperator#clearBitsIthgrough0(int, int)}.
	 */
	@Test
	public void testUpdateBit() {
		int num = 0b111;
		int i = 1; // mask = ~(0b101)
		int v = 0;
		int expectedResult = 0b101;
		int actual = BitOperator.updateBit(num, i, v);
		assertEquals(expectedResult, actual);
	}

}
