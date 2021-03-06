/**
 * 
 */
package com.algorithmHelper.unitTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kaibo
 * 
 */
public class MathTester {

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
	public void basicMathDemoTest() {
		double a = -191.635;
		double b = 43.74;
		int c = 16, d = 45;

		System.out.printf("The absolute value " + "of %.3f is %.3f%n", a,
				Math.abs(a));

		System.out
				.printf("The ceiling of " + "%.2f is %.0f%n", b, Math.ceil(b));

		System.out.printf("The floor of " + "%.2f is %.0f%n", b, Math.floor(b));

		System.out.printf("The rint of %.2f " + "is %.0f%n", b, Math.rint(b));

		System.out.printf("The max of %d and " + "%d is %d%n", c, d,
				Math.max(c, d));

		System.out.printf("The min of of %d " + "and %d is %d%n", c, d,
				Math.min(c, d));

	}

	@Test
	public void exponentialTest() {
		double x = 11.635;
		double y = 2.76;

		System.out.printf("The value of " + "e is %.4f%n", Math.E);

		System.out.printf("exp(%.3f) " + "is %.3f%n", x, Math.exp(x));

		System.out.printf("log(%.3f) is " + "%.3f%n", x, Math.log(x));

		System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n", x, y,
				Math.pow(x, y));

		System.out.printf("sqrt(%.3f) is " + "%.3f%n", x, Math.sqrt(x));
		System.out.printf("log2^4=%f", Math.log(8) / Math.log(2));
	}

	@Test
	public void trigonometricTest() {
		double degrees = 45.0;
		double radians = Math.toRadians(degrees);

		System.out.format("The value of pi " + "is %.4f%n", Math.PI);

		System.out.format("The sine of %.1f " + "degrees is %.4f%n", degrees,
				Math.sin(radians));

		System.out.format("The cosine of %.1f " + "degrees is %.4f%n", degrees,
				Math.cos(radians));

		System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
				degrees, Math.tan(radians));

		System.out
				.format("The arcsine of %.4f " + "is %.4f degrees %n",
						Math.sin(radians),
						Math.toDegrees(Math.asin(Math.sin(radians))));

		System.out
				.format("The arccosine of %.4f " + "is %.4f degrees %n",
						Math.cos(radians),
						Math.toDegrees(Math.acos(Math.cos(radians))));

		System.out
				.format("The arctangent of %.4f " + "is %.4f degrees %n",
						Math.tan(radians),
						Math.toDegrees(Math.atan(Math.tan(radians))));
	}

	@Test
	public void simplePractice() {
		System.out.printf("%d's hex value is: %d%n", 41,
				Integer.valueOf("41", 16));
	}

}
