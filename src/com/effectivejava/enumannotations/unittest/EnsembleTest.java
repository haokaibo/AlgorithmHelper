/**
 * 
 */
package com.effectivejava.enumannotations.unittest;

import static org.junit.Assert.*;

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
	}

}
