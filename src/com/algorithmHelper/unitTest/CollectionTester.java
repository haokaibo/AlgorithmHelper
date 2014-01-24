/**
 * 
 */
package com.algorithmHelper.unitTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author u0149807
 * 
 */
public class CollectionTester {

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
	public void testContainsAll() {
		Collection<Integer> c = new HashSet<Integer>();
		Collection<Integer> d = new HashSet<Integer>();
		for (int i = 0; i < 3; i++) {
			c.add(i);
			System.out.printf("%d\t", i);
		}
		System.out.println();
		for (int i = 2; i > 0; i--) {
			d.add(i);
			System.out.printf("%d\t", i);
		}
		System.out.println();
		assertTrue(c.containsAll(d));
	}

	@Test
	public void testRetainAll() {
		System.out.printf("%s\n", "testRetainAll");
		Object[] expected = new Object[] { 1, 2 };
		Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(new Integer[] { 1,
				2 }));
		Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(new Integer[] { 1,
				2, 3 }));
		s1.retainAll(s2);
		Iterator<Integer> it = s1.iterator();
		while(it.hasNext()){
			System.out.printf("%d\t", it.next());
		}
		System.out.println();
		assertArrayEquals(s1.toArray(), expected);
	}

	@Test
	public void testLinkedHashSet() {
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		for (int i = 0; i < 5; i++) {
			linkedHashSet.add(i);
			System.out.printf("%d\t", i);
		}
		System.out.println();
		Iterator<Integer> it = linkedHashSet.iterator();
		it.next();
		it.remove();
		while (it.hasNext()) {
			System.out.printf("%d\t", it.next());
		}
		linkedHashSet.add(0);
		System.out.println();
		Iterator<Integer> it2 = linkedHashSet.iterator();
		while (it2.hasNext()) {
			System.out.printf("%d\t", it2.next());
		}

	}

}
