/**
 * 
 */
package com.regularExpression.unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.regularExpression.RegexTestHarness;

/**
 * @author Kaibo
 * 
 */
public class RegularExpressionTest {

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
	 * {@link com.regularExpression.RegexTestHarness#isMatch(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testIsMatch() {
		String regex = ".*+foo";
		String targetString = "foo";
		System.out.format("regex: %s%ntargetString:%s%n", regex, targetString);
		RegexTestHarness.isMatch(targetString, regex);

	}
	
	/**
	 * Test method for
	 * {@link com.regularExpression.RegexTestHarness#isMatch(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testIsMatch2() {
		String regex = "(kaibo)&&(boy)";
		String targetString = "kaibo is a boy at the age of 29.";
		System.out.format("regex: %s%ntargetString:%s%n", regex, targetString);
		RegexTestHarness.isMatch(targetString, regex);

	}

}
