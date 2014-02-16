/**
 * 
 */
package com.amazon.test.unittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazon.test.Solution;

/**
 * @author Kaibo
 * 
 */
public class AmazonTest {

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

	@Test
	public void test() {
		int[] grids = { 1, 2, 1, 2 };
		int[] cards = { 1, 2 };
		int expectedResult = 5;
		int result = Solution.MMChess(grids, cards);
		assertEquals(expectedResult, result);
	}

	@Test
	public void test2() {
		int[] grids = { 1, 2, 1, 2, 1 };
		int[] cards = { 1, 2, 1 };
		int expectedResult = 6;
		int result = Solution.MMChess(grids, cards);
		assertEquals(expectedResult, result);
	}
}
