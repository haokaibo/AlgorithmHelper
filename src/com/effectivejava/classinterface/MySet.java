/**
 * 
 */
package com.effectivejava.classinterface;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @author Kaibo
 * 
 */
public class MySet<E> extends AbstractSet<E> {
	// Bulk of the class omitted
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
