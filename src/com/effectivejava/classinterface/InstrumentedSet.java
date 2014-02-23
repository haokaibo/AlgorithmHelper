/**
 * Implementation of prefer to composite to inherence.
 */
package com.effectivejava.classinterface;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Kaibo
 * 
 */
// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		Set<Date> s1 = new HashSet<Date>();
		s1.add(new Date());
		s1.add(new Date(111, 12, 22));
		Set<Date> s = new InstrumentedSet<Date>(new TreeSet<Date>(s1));
		System.out.println(s);
	}
}