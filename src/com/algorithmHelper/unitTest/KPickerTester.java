/**
 * 
 */
package com.algorithmHelper.unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algorithmHelper.KPicker;

/**
 * @author Kaibo
 * @since 01/24/2014
 * @version 1.0
 */
public class KPickerTester {

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
	public void testHappyPath() {
		List<Integer> targets = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			targets.add(i);
		KPicker picker = new KPicker();
		int k = 2;
		List<Integer> actual = picker.PickK(targets, k);
		List<Integer> expected = new ArrayList<>();
		expected.add(4);
		expected.add(3);
		
		// asset the result by checking the size and content of the arrays.
		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));

	}

}
