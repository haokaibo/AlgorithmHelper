/**
 * 
 */
package com.algorithmHelper.unitTest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.portal.*;

/**
 * @author u0149807
 * 
 */
public class CollectionTester {

	public static <E> Set<E> removeDups(Collection<E> c) {
		return new LinkedHashSet<E>(c);
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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	public static void shuffle(List<?> list, Random rnd) {
		for (int i = list.size(); i > 1; i--)
			swap(list, i - 1, rnd.nextInt(i));
	}

	public static <E> void swap(List<E> a, int i, int j) {
		E tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void deepCopyTest() {
		System.out.println("---DeepCopy---");
		System.out.println("Test deep copy.");
		Map<Integer, User> m = new HashMap<>();
		for (int i = 0; i < 3; i++)
			m.put(i, new User(new Name("FirstName" + i, "LastName" + i), i));
		Map<Integer, User> m2 = new HashMap<>(m);
		m2.put(0, new User(new Name("Kaibo", "Hao"), 29));
		System.out.printf("m:%s%nm2:%s%n", m.toString(), m2.toString());

	}

	public <E> int indexOf(List<E> list, E e) {
		for (ListIterator<E> it = list.listIterator(); it.hasNext();)
			if (e == null ? it.next() == null : e.equals(it.next()))
				return it.previousIndex();
		// Element not found
		return -1;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void sortNameTest() {
		Name nameArray[] = { new Name("John", "Smith"), new Name("Karl", "Ng"),
				new Name("Jeff", "Smith"), new Name("Tom", "Rich") };

		List<Name> names = Arrays.asList(nameArray);
		Collections.sort(names);

		String expected = "[Karl Ng, Tom Rich, Jeff Smith, John Smith]";
		assertEquals(expected, names.toString());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainsAll() {
		System.out.println("---testContainsAll---");
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
	public void testLinkedHashSet() {
		System.out.println("---testLinkedHashSet---");
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
	public void testShuffle() {
		System.out.println("---testShuffle---");
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

	@Test
	public void testToArray() {
		System.out.println("---testToArray---");
		Collection<Integer> c = new ArrayList<>();
		c.add(1);
		c.add(2);
		Integer[] arr = c.toArray(new Integer[0]);
		System.out.println("arr.length is: " + arr.length);
		for (int i = 0, len = arr.length; i < len; i++)
			System.out.printf("arr[%d]=%d%n", i, arr[i]);

	}

	static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e2.getHireDate() == e1.getHireDate() ? Integer.compare(
					e2.getNumber(), e1.getNumber()) : e2.getHireDate()
					.compareTo(e1.getHireDate());
		}
	};

	@Test
	public void testComparator() throws ParseException {
		System.out.println("---testComparator---");
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		
		List<Employee> listE = new ArrayList<Employee>();
		listE.add(new Employee(new Name("Kaibo", "Hao"), 2,
				ft.parse("2011-08-08")));
		listE.add(new Employee(new Name("Alex", "Wang"), 1,
				ft.parse("2011-08-07")));
		Collections.sort(listE);
		System.out.println(listE);
		Collections.sort(listE, SENIORITY_ORDER);
		System.out.println(listE);
	}
}
