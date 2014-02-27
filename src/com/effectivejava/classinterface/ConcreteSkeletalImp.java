/**
 * 
 */
package com.effectivejava.classinterface;

import java.util.AbstractList;
import java.util.List;

/**
 * @author Kaibo
 * 
 */
public class ConcreteSkeletalImp {
	static List<Integer> intArrayAsList(final int[] a) {
		if (a == null)
			throw new NullPointerException();
		return new AbstractList<Integer>() {
			public Integer get(int i) {
				return a[i]; // Autoboxing (Item 5)
			}

			@Override
			public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // Auto-unboxing
				return oldVal; // Autoboxing
			}

			public int size() {
				return a.length;
			}
		};
	}
}
