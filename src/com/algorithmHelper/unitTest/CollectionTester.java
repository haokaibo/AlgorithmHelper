/**
 * 
 */
package com.algorithmHelper.unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
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
		while (it.hasNext()) {
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

	@Test
	public void testToArray() {
		Collection<Integer> c = new ArrayList<>();
		c.add(1);
		c.add(2);
		Integer[] arr = c.toArray(new Integer[0]);
		System.out.println("arr.length is: " + arr.length);
		for (int i = 0, len = arr.length; i < len; i++)
			System.out.printf("arr[%d]=%d%n", i, arr[i]);

	}

	@Test
	public void testShuffle() {
		System.out.println();
		List<Character> chars = new ArrayList<>();
		char[] charMeta = new char[] { 'a', 'b', 'c', 'd', 'e' };
		System.out.println("orgin string: ");
		for (int i = 0; i < 5; i++) {
			chars.add(charMeta[i]);
			System.out.printf("%c\t", charMeta[i]);
		}

		shuffle(chars, new Random());
		System.out.println();
		System.out.println("shuffled char array:");
		for (int i = 0; i < chars.size(); i++) {
			System.out.printf("%c\t", chars.get(i));
		}
	}

	public static <E> Set<E> removeDups(Collection<E> c) {
		return new LinkedHashSet<E>(c);
	}

	public static <E> void swap(List<E> a, int i, int j) {
		E tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	public static void shuffle(List<?> list, Random rnd) {
		for (int i = list.size(); i > 1; i--)
			swap(list, i - 1, rnd.nextInt(i));
	}

	public <E> int indexOf(List<E> list, E e) {
		for (ListIterator<E> it = list.listIterator(); it.hasNext();)
			if (e == null ? it.next() == null : e.equals(it.next()))
				return it.previousIndex();
		// Element not found
		return -1;
	}

	public static <E> void replace(List<E> list, E val,
			List<? extends E> newVals) {
		for (ListIterator<E> it = list.listIterator(); it.hasNext();) {
			if (val == null ? it.next() == null : val.equals(it.next())) {
				it.remove();
				for (E e : newVals)
					it.add(e);
			}
		}
	}
}
