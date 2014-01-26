/**
 * 
 */
package com.algorithmHelper.unitTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algorithmHelper.QuickSorter;

/**
 * @author Kaibo
 * 
 */
public class SorterTester {

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
	public void testQuickSorterWithEmptyArray() {
		int[] actuals = new int[] {};
		int[] expecteds = new int[] {};
		
		QuickSorter sorter = new QuickSorter(actuals);
		sorter.sort();
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testQuickSorterWithHappyPath() {
		int[] actuals = new int[] { 4, 3, 2, 5, 1 };
		int[] expecteds = new int[] { 1, 2, 3, 4, 5 };
		QuickSorter sorter = new QuickSorter(actuals);
		sorter.sort();
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
