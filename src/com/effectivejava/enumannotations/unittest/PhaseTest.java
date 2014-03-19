/**
 * 
 */
package com.effectivejava.enumannotations.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.effectivejava.enumannotations.Phase;

/**
 * @author Kaibo
 *
 */
public class PhaseTest {

	@Test
	public void test() {
		assertEquals(Phase.Transition.MELT, Phase.Transition.from(Phase.SOLID, Phase.LIQUID));
		assertEquals(Phase.Transition.SUBLIME, Phase.Transition.from(Phase.SOLID, Phase.GAS));
		assertEquals(Phase.Transition.CONDENSE, Phase.Transition.from(Phase.GAS, Phase.LIQUID));
		assertEquals(Phase.Transition.DEPOSIT, Phase.Transition.from(Phase.GAS, Phase.SOLID));
		assertEquals(Phase.Transition.BOIL, Phase.Transition.from(Phase.LIQUID, Phase.GAS));
		assertEquals(Phase.Transition.FREEZE, Phase.Transition.from(Phase.LIQUID, Phase.SOLID));
	}

}
