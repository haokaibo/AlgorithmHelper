/**
 * 
 */
package com.effectivejava.enumannotations.unittest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.effectivejava.enumannotations.Ensemble;

/**
 * @author Kaibo
 * 
 */
public class EnsembleTest {

	@Test
	public void test() {
		assertEquals(10, Ensemble.DECTET.numberOfMusicians());
		assertEquals(12, Ensemble.TRIPLE_QUARTET.numberOfMusicians());

		int n = 2 * (Integer.MAX_VALUE / 3);
		int low = 0;
		for (int i = 0; i < 1000000; i++)
			if (random(n) < n / 2)
				low++;
		System.out.println(low);

		System.out.println(Math.abs(Integer.MIN_VALUE) % 5);
	}

	private static final Random rnd = new Random();

	// Common but deeply flawed!
	static int random(int n) {
		return Math.abs(rnd.nextInt()) % n;
	}

}
