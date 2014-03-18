/**
 * 
 */
package com.effectivejava.enumAnnotations.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.effectivejava.enumAnnotations.Ensemble;

/**
 * @author Kaibo
 * 
 */
public class EnsembleTest {

	@Test
	public void test() {
		assertEquals(10, Ensemble.DECTET.numberOfMusicians());
		assertEquals(12, Ensemble.TRIPLE_QUARTET.numberOfMusicians());
	}

}
